package fileManager;

//Servlet-importer

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//IO-Stream
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.ByteArrayOutputStream;

//Logger - fra Object for å føre feil.
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Emil-Ruud
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig(maxFileSize = 16777216) //16Mib
public class UploadServlet extends HttpServlet {
    private final static Logger LOGGER =
            Logger.getLogger(UploadServlet.class.getCanonicalName());

    @EJB
    FileManagerLocal fml;

    private void Upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //Globale variabler
        final String id = UUID.randomUUID().toString();
        final Part filePart = request.getPart("file");
        //byte[] fileContent = Maybe(filePartInputStream);

        //Lager en inputstream som skal "holde" på strømmen av bits ("Parts" som til sammen er filen)
        InputStream filePartInputStream;
        try {
            final String fileName = getFileName(filePart);
            filePartInputStream = filePart.getInputStream();
            if (fileName.endsWith(".zip") && filePart.getSize() <= 16777216) {

                byte[] fileContent = convertToByteArray(filePartInputStream);
                FileEntity fileEntity = new FileEntity(id, fileName, fileContent);

                //Dette skal "sende" filen ved hjelp av persistence til databasen
                if (fml.saveFile(fileEntity)) {
                    String message = "Filen er lastet opp ";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("welcome.jsp");
                } else {
                    String message = "Får ikke lastet filen opp til databasen";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("welcome.jsp");
                }
            } else {
                String message = "Filen må være av typen .zip og under 16Mb for å kunne bli lastet opp";
                request.getSession().setAttribute("message", message);
                response.sendRedirect("welcome.jsp");
            }
        } catch (IOException ioe) {
            throw new ServletException();
        }
    }

    //Felt for å hente ut filnavnet - ferdig metode fra Oracle sine sider
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

    private byte[] convertToByteArray(InputStream filePartInputStream) throws IOException {
        int bytesRead;
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream fileOutPutStream = new ByteArrayOutputStream();

        while ((bytesRead = filePartInputStream.read(buffer)) != -1) {
            fileOutPutStream.write(buffer, 0, bytesRead);
        }
        fileOutPutStream.flush();

        return fileOutPutStream.toByteArray();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Upload(request, response);
    }
}