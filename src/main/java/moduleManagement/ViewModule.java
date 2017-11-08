package moduleManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Author Emil-Ruud
 * Dette er en servlet som henter ut data fra en gitt modul
 */

@WebServlet(name = "ViewModule", urlPatterns = {"/ViewModule"})
public class ViewModule extends HttpServlet {

    @EJB
    ModuleManagerLocal em;
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     * Sjekker hvilken av modulknappene som har blitt trykket i
     * ModuleDescriptionAndDelivery
     */

    private void viewModule(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (request.getParameter("module1") != null) {
            Module module = em.getModule(1);
            String modulNummer = "1";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module2") != null) {
            Module module = em.getModule(2);
            String modulNummer = "2";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module3") != null) {
            Module module = em.getModule(3);
            String modulNummer = "3";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module4") != null) {
            Module module = em.getModule(4);
            String modulNummer = "4";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module5") != null) {
            Module module = em.getModule(5);
            String modulNummer = "5";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);
        }
    }

    /**
     * @param request
     * @param response
     * @param modulNummer
     * @param goals
     * @param resources
     * @param deadline
     * @param approvalCriterias
     * @param tasks
     * @throws IOException
     * @throws ServletException
     */

    private void skrivModul(HttpServletRequest request, HttpServletResponse response, String modulNummer, String goals, String resources, String deadline, String approvalCriterias, String tasks) throws IOException, ServletException {

        request.getSession().setAttribute("mNr", modulNummer);
        request.getSession().setAttribute("goals", goals);
        request.getSession().setAttribute("resources", resources);
        request.getSession().setAttribute("deadline", deadline);
        request.getSession().setAttribute("approvalCriterias", approvalCriterias);
        request.getSession().setAttribute("tasks", tasks);
        response.sendRedirect("ModuleDescriptionAndDelivery.jsp");

        //Dette "passer" et parameter til session, slik at andre servlets
        //kan hente inn verdien.
        HttpSession session = request.getSession();
        session.setAttribute("modulNummer", modulNummer);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        viewModule(request, response);
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
        viewModule(request, response);
    }
}

