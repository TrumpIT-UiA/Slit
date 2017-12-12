package fileManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DownloadServlet", urlPatterns = {"/Download"})
public class DownloadServlet {

@EJB
private
FileManagerLocal FileManager;

    private void Download (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        ArrayList<File> modulListe = (ArrayList<File>) FileManager.getListFromQuery("SELECT * FROM 'file", File.class);
        request.setAttribute("ModulListe", modulListe);
        request.getRequestDispatcher("/Slit/Download").forward(request, response);
    }


    /**
     * @author Marius
     * Standard Java metode for HTTP GET
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Download(request, response);
    }

    /**
     * @author Marius
     * Standard Java metode for HTTP Post
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Download(request, response);
    }
}
