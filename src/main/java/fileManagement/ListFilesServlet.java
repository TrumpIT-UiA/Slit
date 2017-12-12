package fileManagement;

import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ListFilesServlet", urlPatterns = {"/ListFiles"})
public class ListFilesServlet extends HttpServlet {

@EJB
FileManagerLocal FileManager;

    private void Download (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        try {
            Collection<Object> modulListe = FileManager.returnAllFilesFromDB();
            HttpSession session = request.getSession();
            session.setAttribute("ModulListe", modulListe);
            response.sendRedirect("/Slit/App/Module/ListModules.jsp");
        }

        catch (NullPointerException nullp){
            PrintWriter out = response.getWriter();
            out.print("Nullpointer error");
        }
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
