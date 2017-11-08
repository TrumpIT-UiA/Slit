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

    /**
     * Sjekker hvilken av modulknappene som har blitt trykket i
     * ModuleDescriptionAndDelivery
     */

    @EJB
    ModuleManagerLocal em;

    private void viewModule(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UploadServlet us = new UploadServlet();
        if (request.getParameter("module1") != null) {
            Module module = em.getModule(1);
            String mNr = "1";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();
            us.setModulNr(mNr);

            request.getSession().setAttribute("mNr", mNr);
            request.getSession().setAttribute("goals", goals);
            request.getSession().setAttribute("resources", resources);
            request.getSession().setAttribute("deadline", deadline);
            request.getSession().setAttribute("approvalCriterias", approvalCriterias);
            request.getSession().setAttribute("tasks", tasks);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");

        } else if (request.getParameter("module2") != null) {
            Module module = em.getModule(2);
            String mNr = "2";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();
            us.setModulNr(mNr);

            request.getSession().setAttribute("mNr", mNr);
            request.getSession().setAttribute("goals", goals);
            request.getSession().setAttribute("resources", resources);
            request.getSession().setAttribute("deadline", deadline);
            request.getSession().setAttribute("approvalCriterias", approvalCriterias);
            request.getSession().setAttribute("tasks", tasks);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");

        } else if (request.getParameter("module3") != null) {
            Module module = em.getModule(3);
            String mNr = "3";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();
            us.setModulNr(mNr);

            request.getSession().setAttribute("mNr", mNr);
            request.getSession().setAttribute("goals", goals);
            request.getSession().setAttribute("resources", resources);
            request.getSession().setAttribute("deadline", deadline);
            request.getSession().setAttribute("approvalCriterias", approvalCriterias);
            request.getSession().setAttribute("tasks", tasks);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");

        } else if (request.getParameter("module4") != null) {
            Module module = em.getModule(4);
            String mNr = "4";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();
            us.setModulNr(mNr);

            request.getSession().setAttribute("mNr", mNr);
            request.getSession().setAttribute("goals", goals);
            request.getSession().setAttribute("resources", resources);
            request.getSession().setAttribute("deadline", deadline);
            request.getSession().setAttribute("approvalCriterias", approvalCriterias);
            request.getSession().setAttribute("tasks", tasks);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");

        } else if (request.getParameter("module5") != null) {
            Module module = em.getModule(5);
            String mNr = "5";
            String goals = module.getLearningGoals();
            String resources = module.getResources();
            String deadline = module.getDeadline();
            String approvalCriterias = module.getApprovalCriteria();
            String tasks = module.getTasks();
            us.setModulNr(mNr);

            request.getSession().setAttribute("mNr", mNr);
            request.getSession().setAttribute("goals", goals);
            request.getSession().setAttribute("resources", resources);
            request.getSession().setAttribute("deadline", deadline);
            request.getSession().setAttribute("approvalCriterias", approvalCriterias);
            request.getSession().setAttribute("tasks", tasks);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");

        }


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

