package fileManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SetModuleNumberServlet", urlPatterns = {"/SetModuleNumber"})
public class SetModuleNumberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FileEntity fileEntity = new FileEntity();

        if (request.getParameter("module1") != null) {
            fileEntity.setModulNr(1);
        } else if (request.getParameter("module2") != null) {
            fileEntity.setModulNr(2);
        } else if (request.getParameter("module3") != null) {
            fileEntity.setModulNr(3);
        } else if (request.getParameter("module4") != null) {
            fileEntity.setModulNr(4);
        } else if (request.getParameter("module5") != null) {
            fileEntity.setModulNr(5);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
