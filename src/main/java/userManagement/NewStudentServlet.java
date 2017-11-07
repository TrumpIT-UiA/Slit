package userManagement;

        import users.Student;
        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.HttpConstraint;
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
@WebServlet(name = "NewStudentServlet", urlPatterns = {"/NewStudent"})
@ServletSecurity(
        @HttpConstraint(rolesAllowed = {"Teacher", "Admin"})
)
public class NewStudentServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

    /**
     * Lager en ny student og lagrer den i databasen dersom alt går bra.
     * @param request Ett HTTP request objekt
     * @param response Ett HTTP response objekt
     * @throws IOException
     */
    private void newStudent (HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("passWord");
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");

        Student s = new Student(email.toLowerCase(), password, firstname.toLowerCase(), lastname.toLowerCase());
        if(manager.saveUser(s) == true){
            out.print("Din bruker har blitt opprettet!  ");
            out.print("Du vil nå bli videresendt til innloggingen   ");
            response.sendRedirect("/Slit/Login.jsp");
        } else if (manager.saveUser(s) == false){
            out.print("Din bruker kunne ikke bli opprettet, vennligst prøv igjen ");
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
        newStudent(request, response);
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
            throws ServletException, IOException {
        newStudent(request, response);
    }
}

