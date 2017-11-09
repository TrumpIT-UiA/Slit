package authentication;

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
 * Servlet for å håndtere innlogging via forms
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    /**
     * @author Marius
     * Metode for å logge inn en bruker
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws IOException Standard java exception
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        
        try {
            User u = manager.getUser(email.toLowerCase());
            if (u.getPassword().equals(password)) {
                request.getSession().setAttribute("user", u);
                response.sendRedirect("/Slit/welcome.jsp");
            } else {
                request.setAttribute("error", "Unknown login, try again");
                response.sendRedirect("/Slit/LoginFailed.jsp");
            }
        }
        catch (NullPointerException nullp){
            System.err.println("NullPointerException: " + nullp.getMessage());
            response.sendRedirect("/Slit/LoginFailed.jsp");
        }
    }

    /**
     * Standard Java metode for HTTP GET
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
    }

    /**
     * Standard Java metode for HTTP Post
     * @param request Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException Standard java exception
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        login(request, response);
    }
}




