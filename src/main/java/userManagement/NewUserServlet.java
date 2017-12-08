package userManagement;

import users.Admin;
import users.AssistantTeacher;
import users.Teacher;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Marius
 * Servlet for å håndtere opprettelse av nye brukere
 */
@WebServlet(name = "NewUserServlet", urlPatterns = {"/NewUser"})
public class NewUserServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    /**
     * Lager en ny bruker ut ifra definert type og lagrer den i databasen dersom alt går bra.
     *
     * @param request  Ett HTTP request objekt
     * @param response Ett HTTP response objekt
     * @throws IOException
     */
    private void newUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String usertype = request.getParameter("userType");

        if (usertype.equals("Teacher")) {
            String Role = "Teacher";
            Teacher t = new Teacher(email.toLowerCase(), password, firstname.toLowerCase(), lastname.toLowerCase());
            if (manager.saveUser(t)) {
                out.print("Din bruker har blitt opprettet!  ");
            } else if (!manager.saveUser(t)) {
                out.print("Din bruker kunne ikke bli opprettet, vennligst prøv igjen ");
            }

        } else if (usertype.equals("AssistantTeacher")) {
            String Role ="AssistantTeacher";
            AssistantTeacher at = new AssistantTeacher(email.toLowerCase(), password, firstname.toLowerCase(), lastname.toLowerCase());
            if (manager.saveUser(at)) {
                out.print("Din bruker har blitt opprettet!  ");
            } else if (!manager.saveUser(at)) {
                out.print("Din bruker kunne ikke bli opprettet, vennligst prøv igjen ");
            }

        } else if (usertype.equals("Admin")) {
            String Role = "Admin";
            Admin a = new Admin(email.toLowerCase(), password, firstname.toLowerCase(), lastname.toLowerCase());
            if (manager.saveUser(a)) {
                out.print("Din bruker har blitt opprettet!  ");
            } else if (!manager.saveUser(a)) {
                out.print("Din bruker kunne ikke bli opprettet, vennligst prøv igjen ");
            }
        }
    }

    /**
     * Standard Java metode for HTTP GET
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newUser(request, response);
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
        newUser(request, response);
    }
}


