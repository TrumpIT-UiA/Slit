package authentication;
/**
 * Author: Nicolay Leknes
 * Opprettet 11.13.2017
 * Sist redigert av:    dato:
 */

import userManagement.UserManagerLocal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/Logout"})
class LogoutServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    private void logut(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        if (session != null) {
            session.invalidate();
            request.getRequestDispatcher("/logout.jsp").forward(request, response);
            response.sendRedirect("logout.jsp");
            out.println(session.toString());
            out.println("xD");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logut(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logut(request, response);
    }
}
