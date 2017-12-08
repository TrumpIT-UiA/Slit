package userManagement;

import users.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Marius
 * Servlet for å legge et brukerobjekt i sesjonen
 */
@WebServlet(name = "UserSessionServlet", urlPatterns = {"/PutUser"})
public class UserSessionServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    private void PutUserInSession(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String usernameOfUser = request.getParameter("j_username");
        String passwordOfUser = request.getParameter("j_password");

        //Henter ut brukeren fra databasen
        User userFromTheDB = manager.getUser(usernameOfUser);
        HttpSession session = request.getSession();
        session.setAttribute("TheLoggedInUser", userFromTheDB);

        request.getRequestDispatcher("j_security_check").forward(request, response);
}

    /**
     * @author Marius
     * Standard Java metode for HTTP GET
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PutUserInSession(request, response);
    }

    /**
     * @author Marius
     * Standard Java metode for HTTP Post
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PutUserInSession(request, response);
    }
}


