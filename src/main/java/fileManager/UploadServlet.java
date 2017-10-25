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
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);
        InputStream filecontent;
        final PrintWriter writer = response.getWriter();

        // final byte[] fileContent = fraInputTilByteArray(filecontent);
        if (fileName.endsWith(".zip")) //De første karakterene er [B@ som indikerer .zip
        {
            filecontent = filePart.getInputStream();
            final byte[] fileContent = fraInputTilByteArray(filecontent);
            final String id = UUID.randomUUID().toString();
            FileEntity fileEntity = new FileEntity(id, fileName, fileContent);
            //writer.print(fileEntity.getFileContent());
            //UploadTheDamnFile(fileEntity, writer);

            byte[] message = fileEntity.getFileContent();
            request.getSession().setAttribute("message", message);
            response.sendRedirect("welcome.jsp");

        } else {
            String message = "Filen må være av typen .zip!";
            request.getSession().setAttribute("message", message);
            response.sendRedirect("welcome.jsp");
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
    //Tror problemet er at kun en "Part" av filen blir hentet inn - legg while doPost
    public static byte[] fraInputTilByteArray(InputStream filecontent) throws IOException {
        byte[] buffer = new byte[8192];
        int bytesRead;
        ByteArrayOutputStream fileContentArray = new ByteArrayOutputStream();
        while ((bytesRead = filecontent.read(buffer)) != -1) {
            fileContentArray.write(buffer, 0, bytesRead);
        }
        return fileContentArray.toByteArray();
    }

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