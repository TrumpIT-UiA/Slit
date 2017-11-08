package moduleManagement;

import fileManagement.File;
import fileManagement.UploadServlet;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Vebjørn
 * Dette er en servlet som henter ut data fra en gitt modul
 */

@WebServlet(name = "ViewModule", urlPatterns = {"/ViewModule"})
public class ViewModule extends HttpServlet {
    private String modulNummer = getModulNummer();
    /**
     * Sjekker hvilken av modulknappene som har blitt trykket i
     * ModuleDescriptionAndDelivery
     */

    @EJB
    ModuleManagerLocal em;

    private void viewModule(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getParameter("module1") != null) {
            Module module = em.getModule(1);
            String modulNummer = "1";
            setModulNr(modulNummer);
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module2") != null) {
            Module module = em.getModule(2);
            String modulNummer = "2";
            setModulNr(modulNummer);
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module3") != null) {
            Module module = em.getModule(3);
            String modulNummer = "3";
            setModulNr(modulNummer);
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module4") != null) {
            Module module = em.getModule(4);
            String modulNummer = "4";
            setModulNr(modulNummer);
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);

        } else if (request.getParameter("module5") != null) {
            Module module = em.getModule(5);
            String modulNummer = "5";
            setModulNr(modulNummer);
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();

            skrivModul(request, response, modulNummer, goals, resources, deadline, approvalCriterias, tasks);
        }
    }

    public void skrivModul(HttpServletRequest request, HttpServletResponse response, String modulNummer, String goals, String resources, String deadline, String approvalCriterias, String tasks) throws IOException {
        request.getSession().setAttribute("mNr", modulNummer);
        request.getSession().setAttribute("goals", goals);
        request.getSession().setAttribute("resources", resources);
        request.getSession().setAttribute("deadline", deadline);
        request.getSession().setAttribute("approvalCriterias", approvalCriterias);
        request.getSession().setAttribute("tasks", tasks);
        response.sendRedirect("ModuleDescriptionAndDelivery.jsp");
    }

    public void setModulNr(String modulNummer) {
        this.modulNummer = modulNummer;
    }

    public String getModulNummer() {
        return modulNummer;
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

