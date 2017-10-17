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
 */
@WebServlet
public class LoginServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String fornavn = request.getParameter("firstName");
        String etternavn = request.getParameter("lastName");

        User u = manager.getUser(email.toLowerCase());
        if(u.getPassword().equals(password)){
            response.sendRedirect("/Slit/welcome.jsp");
        }
        else{
            response.sendRedirect("/Slit/LoginFailed.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        login(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        login(request, response);
    }
}




