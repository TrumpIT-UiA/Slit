package authentication;
/**
 * Author: Nicolay Leknes
 * Opprettet 11.13.2017
 * Sist redigert av:    dato:
 */
import userManagement.UserManagerLocal;
import users.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "WelcomeServlet", urlPatterns = {"/Welcome"})
class VelkommenServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    private void SessionHent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        {
            String brukeren = request.getRemoteUser();
            User loggedinUser = manager.getUser(brukeren);
            request.getSession().setAttribute("TheLoggedInUser", loggedinUser);
            response.sendRedirect("/Slit/App/welcome.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            SessionHent(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            SessionHent(request,response);
    }

}
