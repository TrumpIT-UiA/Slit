package fileManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;


/**
 * @author Snorre
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/Download"})
@MultipartConfig(maxFileSize = 10485760) //10Mib
public class DownloadServlet extends HttpServlet {

    @EJB
    private FileManagerLocal fml;

    private void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String modulNummer = (String) session.getAttribute("modulNummer");
        String currentUserEmail = request.getRemoteUser();
        //Tester litt
        //String currentUserEmail =
        //String mergedNrEmail = currentUserEmail + modulNummer;
        String mergedNrEmail = (String) request.getParameter("MergedNrUsernameFromListModules");

        downloadFile(request, response, mergedNrEmail, modulNummer);
    }

    private void downloadFile(HttpServletRequest request, HttpServletResponse response, String mergedNumberEmail, String modulNummer) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            File file = fml.getFile(mergedNumberEmail);

            InputStream inStream = new ByteArrayInputStream(file.getFileContent());

            int bytesRead;
            byte[] buffer = new byte[8192];

            while ((bytesRead = inStream.read(buffer)) != -1) {
                response.getOutputStream().write(buffer, 0, bytesRead);
            }
            inStream.close();
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            System.out.println("inStream = null, dvs det ligger ingen fil i DB");
            request.getSession().setAttribute("moduleError", "Du har dessverre ikke levert modul " + modulNummer);
            response.sendRedirect("/Slit/App/Module/ViewModule.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        download(request, response);
    }
}