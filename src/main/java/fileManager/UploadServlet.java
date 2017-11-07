package fileManager;

//Servlet-importer

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Emil-Ruud
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@HttpConstraint(rolesAllowed = {"Teacher", "Admin", "Student", "AssistantTeacher"})
@MultipartConfig(maxFileSize = 15728640) //16Mib

public class UploadServlet extends HttpServlet {
    private final static Logger LOGGER =
            Logger.getLogger(UploadServlet.class.getCanonicalName());

    @EJB
    FileManagerLocal fml;

    private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        //Globale variabler
        final Part filePart = request.getPart("file");

        //Lager en inputstream som skal "holde" på strømmen av bits ("Parts" som til sammen er filen)
        InputStream filePartInputStream;
        try {
            final String fileName = getFileName(filePart);
            filePartInputStream = filePart.getInputStream();
            if (fileName.endsWith(".zip")) { //Sjekker om fil-endelsen er .zip
                if (filePart.getSize() <= 10485760) { //Sjekker at filen IKKE er større enn 10Mib

                    byte[] fileContent = convertToByteArray(filePartInputStream); //fileContent er selve filen som array av bytes
                    FileEntity fileEntity = new FileEntity(fileName, fileContent);

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
                    String message = "Filen kan ikke være større enn 10Mib (10 485 760 bytes).";
                    request.getSession().setAttribute("message", message);
                    response.sendRedirect("welcome.jsp");
                }
            } else {
                String message = "Filen må være av typen .zip (en helt vanlig zip-fil).";
                request.getSession().setAttribute("message", message);
                response.sendRedirect("welcome.jsp");
            }
        } catch (IOException ioe)

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
     * @throws IOException Skriver InputStream-en til en ByteArrayOutputStream ved hjelp av en while-løkke
     *                     som blir returner i form av en array av bytes.
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
        upload(request, response);
    }
}

///////////////////////////////////////////////////////
/**
 * Kode for å sjekke tiden, skal brukes senere for deadline og lukke innlevering.
 * Date date = new Date() ;
 * SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;
 * dateFormat.format(date);
 * System.out.println(dateFormat.format(date));
 *
 * if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("12:07")))
 * {
 * System.out.println("Current time is greater than 12.07");
 * }else{
 * System.out.println("Current time is less than 12.07");
 * }
 */