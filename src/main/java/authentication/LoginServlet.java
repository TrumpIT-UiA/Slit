package authentication;

import netscape.security.Principal;
import userManagement.UserManagerLocal;
import users.User;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Marius
 * Autentiserer en bruker mot lagret data
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    /**
     * @author Marius
     * @param request  En HTTP Request spørring
     * @param response En HTTP Response spørring
     * @throws IOException Kastes når man får feil v/ Input/Output
     * Metode for å logge inn en bruker i systemet
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        String emailFromForm = request.getParameter("j_username").toLowerCase();
        String passwordFromForm = request.getParameter("j_password");

        try {
            User userThatLogsIn = manager.getUser(emailFromForm);
            String passwordFromDB = userThatLogsIn.getPassword();

            if (passwordFromDB.equals(passwordFromForm)) {
                request.getSession().setAttribute("TheLoggedInUser", userThatLogsIn);
                response.sendRedirect("/Slit/welcome.jsp");
            } else {
                request.setAttribute("error", "Unknown login, try again");
                response.sendRedirect("/Slit/LoginFailed.jsp");
            }
        } catch (NullPointerException nullPointer) {
            System.err.println("NullPointerException: " + nullPointer.getMessage());
            response.sendRedirect("/Slit/LoginFailed.jsp");
        }
    }

    /**
     * Standard Java metode for HTTP GET spørringer
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //login(request, response);
    }

    /**
     * Standard Java metode for HTTP Post spørringer
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
    }
}





