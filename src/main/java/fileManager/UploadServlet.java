package fileManager;

//ServletImport

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//IO-Stream
import java.io.*;

//Logger - fra Object for å føre feil.
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Emil-Ruud
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    private final static Logger LOGGER =
            Logger.getLogger(UploadServlet.class.getCanonicalName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Lagrer filen i /tmp - en teori er at den blir lagret på den virtuelle serveren
        //final PrintWriter writer = response.getWriter();
        final String id = UUID.randomUUID().toString();
        final Part filePart = request.getPart("file");
        //byte[] fileContent = Maybe(filePartInputStream);

        InputStream filePartInputStream;
            try {
                final String fileName = getFileName(filePart);
                filePartInputStream = filePart.getInputStream();
                if (fileName.endsWith(".zip")) {

                    int bytesRead = 0;
                    final byte[] buffer = new byte[1024];
                    ByteArrayOutputStream fileOutPutStream = new ByteArrayOutputStream();

                    while ((bytesRead = filePartInputStream.read(buffer)) != -1) {
                        fileOutPutStream.write(buffer, 0, bytesRead);
                    }
                    byte[] fileContent = fileOutPutStream.toByteArray();
                    FileEntity fileEntity = new FileEntity(id, fileName, fileContent);
                    //UploadTheDamnFile(fileEntity, writer);
                    //writer.print(fileContent);
                    String message = fileEntity.getFileContent().toString();
                    String message2 = fileEntity.getFilename();
                    String message3 = fileEntity.getId();
                    request.getSession().setAttribute("message", "FileContent: " + message + "\n" + "_____FileName: " + message2 + "\n" + "______FileID: " + message3);
                    response.sendRedirect("welcome.jsp");

                } else {
                    String message = "Filen må være av typen .zip!";
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

    //public byte[] Maybe(InputStream filePartInputStream) throws IOException {


        @EJB
        FileManagerLocal fml;

    public void UploadTheDamnFile(FileEntity fileEntity, PrintWriter writer) {
        if (fml.saveFile(fileEntity) == true) {
            writer.print("Suksess... Diiiiiigg");
        } else if (fml.saveFile(fileEntity) == false) {
            writer.print("Får ikke lastet filen opp til databasen...");
        }
    }
}