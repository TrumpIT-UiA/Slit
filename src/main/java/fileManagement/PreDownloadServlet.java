package fileManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PDS", urlPatterns = {"/PDS"})
public class PreDownloadServlet extends HttpServlet {

    @EJB
    FileManagerLocal fml;

    private void pds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Dette er veldig rotete og bør gjøres om til en .jsp istedenfor.
        // Sende parametere

        out.println("<!DOCTYPE html>");
        out.println("<html");
        out.println("<title>Tittel</title>");
        out.println("</head>");
        out.println("<body>");

        List<File> fileList = fml.getListFromQuery("SELECT * FROM `file`", File.class);

        for (File fileEntity : fileList) {
            out.println("<form action=\"/Slit/PDS-" + fileEntity.getId() + "\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"" + fileEntity.getId() + "\" value=\""
                    + fileEntity.getFilename() + "\">"); // Lastet opp av: ); // Legg til hvem som har levert.
            out.println("</form>");
        }
        out.println("</body>");
        out.println("</html>");

/*
        String gi = request.getParameter("hdnbt");
        out.println("button value" +gi);


        List<File> fileList = fml.getListFromQuery("SELECT * FROM fileentity", File.class);
*/


    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pds(request, response);
    }
}