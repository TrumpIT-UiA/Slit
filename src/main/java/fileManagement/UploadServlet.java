package fileManagement;

//Servlet-importer

import Diverse.DataRelated;
import users.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;

//EJB for kommunikasjon med databasen
import javax.ejb.EJB;

//IO-Stream
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;

//Logger - fra Object for å føre feil
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Emil-Ruud
 */

@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig(maxFileSize = 10485760) //15Mib

public class UploadServlet extends HttpServlet {
    private final static Logger LOGGER =
            Logger.getLogger(UploadServlet.class.getCanonicalName());

    @EJB
    FileManagerLocal fml;

    private void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        request.setCharacterEncoding("UTF-8");

        //Lokale variabler
        final Part filePart = request.getPart("file");
        //Lager en inputstream som skal "holde" på strømmen av bits ("Parts" som til sammen er filen)
        InputStream filePartInputStream;

        HttpSession session = request.getSession();
        LocalDate localDateDeadline = (LocalDate) session.getAttribute("deadline");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String textDate = formatter.format(LocalDate.now());
        LocalDate parsedToday = LocalDate.parse(textDate, formatter);


        try {
            if (parsedToday.isAfter(localDateDeadline)) {
                String message = "Fristen har dessverre gått ut...";
                skrivUt(message, request, response);
            } else {
                String fileName = getFileNameOracle(filePart);
                if (fileName.endsWith(".zip")) { //Sjekker om fil-endelsen er .zip
                    if (filePart.getSize() <= 10485760) { //Sjekker at filen IKKE er større enn 10Mib

                        filePartInputStream = filePart.getInputStream();

                        String modulNummer = (String) session.getAttribute("modulNummer");
                        User loggedInUser = (User) session.getAttribute("loggedInUser");
                        String comment = request.getParameter("studComment");
                        String currentUserEmail = loggedInUser.getEmail();
                        String mergedNrEmail = currentUserEmail + modulNummer;
                        byte[] fileContent = convertToByteArray(filePartInputStream); //fileContent er selve filen som array av bytes
                        DataRelated dr = new DataRelated();
                        String deliveredTime = dr.getCurrentTimeString();

                        File file = new File(mergedNrEmail, loggedInUser.getEmail(), modulNummer, fileName, deliveredTime, fileContent, comment);

                        /**
                         * Dette skal "sende" filen ved hjelp av persistence til databasen, saveFile
                         * ligger i FileManagerLocal, men blir overrided i FileManagerBean - gå dit
                         * for å se kommunikasjonen med databasen.
                         */
                        if (fml.updateFile(file, request, response)) {
                            String message = "Filen din har blitt oppdatert.<BR>Info om ny innlevering:<BR>Filnavn: " + file.getFilename() + "<BR>Filstørrelse: " + filePart.getSize() + " bytes" + "<BR>Levert: " + dr.getCurrentTimeString() + "<BR>Kommentar: " + comment;
                            skrivUt(message, request, response);
                        } else {
                            if (fml.saveFile(file)) {
                                String message = "Filen din har blitt lastet opp.";
                                skrivUt(message, request, response);
                            } else {
                                String message = "Filen din kunne ikke bli lastet opp";
                                skrivUt(message, request, response);
                            }
                        }
                        //fml.updateFile(file, request, response);
                    } else {
                        String message = "Filen kan ikke være større enn 10Mib (10 485 760 bytes).";
                        skrivUt(message, request, response);
                    }
                    // Filen er ikke zip
                } else {
                    String message = "Filen må være av typen .zip (en helt vanlig zip-fil).";
                    skrivUt(message, request, response);
                }
            }
        } catch (
                IOException ioe)

        {
            throw new ServletException();
        }


    }

    void skrivUt(String message, HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("message", message);
        response.sendRedirect("ModuleDescriptionAndDelivery.jsp");
    }

    private String getFileNameOracle(final Part part) {
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
     * @param part
     * @return filnavnet
     * Felt for å hente ut filnavnet - ferdiglagd metode fra Oracle sine sider:
     * https://docs.oracle.com/javaee/6/tutorial/doc/glraq.html#gmhbq
     * Feltet returnerer filnavnet eller null.
     */

    /**
     * @param filePartInputStream
     * @return fileOutPutStream as byte[]
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
        try {
            upload(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}