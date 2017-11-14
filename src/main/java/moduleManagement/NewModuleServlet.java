package moduleManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Vebjørn
 * Servlet som oppretter en modul i databasen fra parameterne som skrives inn.
 */

@WebServlet(name = "newModule", urlPatterns = {"/newModule"})
public class NewModuleServlet extends HttpServlet {

    /**
     * Sjekker hvilken "radio" ("Modul 1", "Modul 2", osv.) som er blitt merket
     * og skriver informasjonen til et nytt objekt: Module.
     */

    private void newModule(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameter("module") == null) {
            String errorMessage = "NB! Du må velge modulnummer!";
            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect("newModule.jsp");
        } else if (request.getParameter("module").equals("1")) {
            int moduleID = 1;
            getParameters(moduleID, request, response);
        } else if (request.getParameter("module").equals("2")) {
            int moduleID = 2;
            getParameters(moduleID, request, response);
        } else if (request.getParameter("module").equals("3")) {
            int moduleID = 3;
            getParameters(moduleID, request, response);
        } else if (request.getParameter("module").equals("4")) {
            int moduleID = 4;
            getParameters(moduleID, request, response);

        } else if (request.getParameter("module").equals("5")) {
            int moduleID = 5;
            getParameters(moduleID, request, response);
        }
    }

    /**
     * @param moduleID
     * @param request
     * @param response
     */
    private void getParameters(int moduleID, HttpServletRequest request, HttpServletResponse response) {
        String learningGoals = request.getParameter("learningGoals");
        String resources = request.getParameter("resources");
        String tasks = request.getParameter("tasks");
        String approvalCriteria = request.getParameter("approvalCriteria");
        String deadline = request.getParameter("deadline");

        Module m = new Module(moduleID, learningGoals, resources, tasks, approvalCriteria, deadline);
        try {
            saveToDB(m, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    @EJB
    private
    ModuleManagerLocal manager;

    /**
     * @param m
     * @param response
     * @throws ServletException
     * @throws IOException      Lagrer modulen i databasen
     */

    private void saveToDB(Module m, HttpServletResponse response) throws ServletException, IOException {
        if (manager.saveModule(m)) {
            response.sendRedirect("/Slit/ModuleDescriptionAndDelivery.jsp");
        } else {
            if (manager.updateModule(m)) {
                response.sendRedirect("/Slit/ModuleDescriptionAndDelivery.jsp");
            } else {
                response.sendRedirect("/Slit/ModuleDescriptionAndDelivery.jsp");
            }
        }
    }

    /**
     * Standard Java metode for HTTP GET
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newModule(request, response);
    }

    /**
     * Standard Java metode for HTTP Post
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newModule(request, response);
    }
}


