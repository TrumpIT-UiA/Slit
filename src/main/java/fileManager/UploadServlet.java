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
import java.io.ByteArrayOutputStream;

//Logger - fra Object for å føre feil.
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Emil-Ruud
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig(maxFileSize = 15728640) //16Mib
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

        //Lager en inputstream som skal "holde" på strømmen av bits ("Parts" som til sammen er filen)
        InputStream filePartInputStream;
        try {
            final String fileName = getFileName(filePart);
            filePartInputStream = filePart.getInputStream();
            if (fileName.endsWith(".zip")) { //Sjekker om fil-endelsen er .zip
                if (filePart.getSize() <= 15728640) { //Sjekker at filen IKKE er større enn 15Mib

                    byte[] fileContent = convertToByteArray(filePartInputStream); //fileContent er selve filen som array av bytes
                    FileEntity fileEntity = new FileEntity(id, fileName, fileContent);

                    /**
                     * Dette skal "sende" filen ved hjelp av persistence til databasen, saveFile
                     * ligger i FileManagerLocal, men blir overrided i FileManagerBean - gå dit
                     * for å se kommunikasjonen med databasen.
                     */

                    if (fml.saveFile(fileEntity)) {
                        String message = "Hurra! Filen er lastet opp!";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("welcome.jsp");
                    } else {
                        String message = "Får ikke lastet filen opp til databasen.";
                        request.getSession().setAttribute("message", message);
                        response.sendRedirect("welcome.jsp");
                    }
                } else {
                    String message = "Filen kan ikke være større enn 15Mib (15 728 640 bytes).";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("welcome.jsp");

                }
            } else {
                String message = "Filen må være av typen .zip (en helt vanlig zip-fil).";
                request.getSession().setAttribute("message", message);
                response.sendRedirect("welcome.jsp");
            }
        } catch (
                IOException ioe)

        {
            throw new ServletException();
        }
    }

    /**
     * @param part
     * @return filnavnet
     * Felt for å hente ut filnavnet - ferdiglagd metode fra Oracle sine sider:
     * https://docs.oracle.com/javaee/6/tutorial/doc/glraq.html#gmhbq
     * Feltet returnerer filnavnet eller null.
     */

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

    /**
     * @param filePartInputStream
     * @return fileOutPutStream som en array av bytes.
     * @throws IOException
     * Skriver InputStream-en til en ByteArrayOutputStream som blir returnert
     * som en array av bytes.
     */
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