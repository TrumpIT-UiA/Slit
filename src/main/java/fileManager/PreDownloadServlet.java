package fileManager;

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
        out.println("<!DOCTYPE html>");
        out.println("<html");
        out.println("<title>Tittel</title>");
        out.println("</head>");
        out.println("<body>");

        List<FileEntity> fileEntityList = fml.getFromQuery("SELECT * FROM fileentity", FileEntity.class);

        for (FileEntity fileEntity : fileEntityList) {
            out.println("<form action=\"/Slit/PDS-" + fileEntity.getId() + "\" method=\"post\">");
            out.println("<input type=\"submit\" value=\"" + fileEntity.getFilename() + "\"> Lastet opp av: "); // Legg til hvem som har levert.
            out.println("</form>");
            // out.println(fileEntity.getFilename());
        }
        out.println("</body>");
        out.println("</html>");

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pds(request, response);
    }
}