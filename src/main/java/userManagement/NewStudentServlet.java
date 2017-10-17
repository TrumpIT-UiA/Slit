package userManagement;

        import users.Student;
        import javax.ejb.EJB;
        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

/**
 * @author Marius
 */
@WebServlet
public class NewStudentServlet extends HttpServlet {

    @EJB
    UserManagerLocal manager;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newStudent(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        newStudent(request, response);
    }
}

