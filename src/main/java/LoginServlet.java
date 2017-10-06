import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;

/**
 *
 * @author Marius
 */
@WebServlet
public class LoginServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            User u = new User("Peter", "Test123");

            manager.saveUser(u);

            User pet = manager.getUser("Peter");

            pet.setfName("Peter");
            pet.setlName("rå");

            //Henter ut data
            String username = request.getParameter("userName");
            String password = request.getParameter("passWord");

            if (pet.getPassword().equals(password)) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Slit</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("Velkommen til Slit");
                out.print("Du har fått logget inn!" +"" + username + "" + password);
                out.println("</body>");
                out.println("</html>");
            }
            else {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Slit</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("Velkommen til Slit");
                out.print("glhf nub");
                out.println("</body>");
                out.println("</html>");
            }

        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
