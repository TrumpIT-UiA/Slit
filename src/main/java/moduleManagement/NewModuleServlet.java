package moduleManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet som oppretter en modul i databasen fra parameterne som skrives inn.
 */
@WebServlet (name = "newModule", urlPatterns = {"/newModule"})
public class NewModuleServlet extends HttpServlet {
    /**
     * Oppretter entity manager for modul
     */
    @EJB
    ModuleManagerLocal manager;


    private void newModule(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        String learningGoals = request.getParameter("learningGoals");
        String resources = request.getParameter("resources");
        String tasks = request.getParameter("tasks");
        String approvalCriteria = request.getParameter("approvalCriteria");
        String deadline = request.getParameter("deadline");


        Module m = new Module(learningGoals, resources, tasks, approvalCriteria, deadline);
        if(manager.saveModule(m) == true){
            out.print("Modulen har nå blitt opprettet!");
            response.sendRedirect("/Slit/Login.jsp");
        } else if (manager.saveModule(m) == false){
            out.print("Modulen kunne ikke opprettes. Prøv igjen.");
        }

    }

    /**
     * Standard Java metode for HTTP GET
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newModule(request, response);
    }

    /**
     * Standard Java metode for HTTP Post
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newModule(request, response);
    }
}


