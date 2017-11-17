package fileManagement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetModuleNumberServlet", urlPatterns = {"/SetModuleNumber"})
public class SetModuleNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File file = new File();

        if (request.getParameter("module1") != null) {
            file.setModulNr(1);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");
        } else if (request.getParameter("module2") != null) {
            file.setModulNr(2);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");
        } else if (request.getParameter("module3") != null) {
            file.setModulNr(3);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");
        } else if (request.getParameter("module4") != null) {
            file.setModulNr(4);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");
        } else if (request.getParameter("module5") != null) {
            file.setModulNr(5);
            response.sendRedirect("ModuleDescriptionAndDelivery.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
