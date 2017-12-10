package moduleManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;

/**
 * @Author Vebjørn
 * @Author Emil
 * Servlet som oppretter en modul i databasen fra parameterne som skrives inn.
 */

@WebServlet(name = "newModule", urlPatterns = {"/newModule"})
public class NewModuleServlet extends HttpServlet {

    /**
     * Sjekker hvilken "radio" ("Modul 1", "Modul 2", osv.) som er blitt merket
     * og skriver informasjonen til et nytt objekt: Module.
     * @param request HTTP request objekt
     * @param response HTTP response objekt
     * @throws IOException Java exception
     * @throws ParseException Java exception
     */
    private void newModule(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
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
     * I denne metoden henter man input fra text area i newModule.jsp
     * @param moduleID ID på modulen
     * @param request HTTP request objekt
     * @param response HTTP response objekt
     */
    private void getParameters(int moduleID, HttpServletRequest request, HttpServletResponse response) throws ParseException, IOException {
        String learningGoals = new String( request.getParameter( "learningGoals").getBytes( "ISO-8859-1" ), "UTF-8" );
        String resources = new String( request.getParameter( "resources").getBytes( "ISO-8859-1" ), "UTF-8" );
        String tasks = new String( request.getParameter( "tasks").getBytes( "ISO-8859-1" ), "UTF-8" );
        String approvalCriterias = new String( request.getParameter( "approvalCriterias").getBytes( "ISO-8859-1" ), "UTF-8" );
        String deadlineJSP = request.getParameter("deadline");

        if (deadlineJSP.isEmpty()) {
            String errorMessage = "ERROR: du må velge en dato for dead line!";
            request.getSession().setAttribute("errorMessage", errorMessage);
            response.sendRedirect("newModule.jsp");
        } else {

            Module m = new Module(moduleID, learningGoals,resources, tasks, approvalCriterias, deadlineJSP);
            try {

                saveToDB(m, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }


        }
    }

    /**
     * Oppretter en Entity Manager for Modul
     */
    @EJB
    private
    ModuleManagerLocal manager;

    /**
     * Lagrer modulen i databasen
     * @param module Et modulobjekt som skal lagres
     * @param response Et HTTP response objekt
     * @throws ServletException
     * @throws IOException
     */

    private void saveToDB(Module module, HttpServletResponse response) throws ServletException, IOException {
        if (manager.updateModule(module)) {
            response.sendRedirect("/Slit/ModuleDescriptionAndDelivery.jsp");
        } else {
            if (manager.saveModule(module)) {
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
        try {
            newModule(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
        try {
            newModule(request, response);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}


