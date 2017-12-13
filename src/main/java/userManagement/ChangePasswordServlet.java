package userManagement;
import users.User;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * ChangePasswordServlet håndterer bytting av passord, og lagrer det i DB.
 * @author Nicolay Leknes
 * @version 1.0
 * @since 11.13.2017
 */

/**
 * Definerer at dette er en webservlet og gjør om navnet til ChangePassword
 */
@WebServlet(name = "ChangePasswordServlet", urlPatterns = {"/ChangePassword"})
public class ChangePasswordServlet extends HttpServlet {

    /**
     * Henter ut brukerinformasjon fra usermanager local.
     */
    @EJB
    private UserManagerLocal manager;

    /**
     * Metode for bytting av pasord
     *
     * @param request  Et HTTP request objekt
     * @param response Et HTTP response objekt
     * @throws IOException If: Sjekker om input i form stemmer overens, og sammenligner nuverende passord.
     */
    private void changePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, NullPointerException {
        String loggedInUsersUsername = request.getRemoteUser();
        User userFromTheDB = manager.getUser(loggedInUsersUsername);
        String oldPasswordFromDB = userFromTheDB.getPassword();
        String oldPasswordFromForm = request.getParameter("theOldPW");
        String newPasswordFromForm = request.getParameter("theNewPW");
        String newPasswordToCheckFromForm = request.getParameter("theNewPWCheck");
        userFromTheDB.setPassword(newPasswordFromForm);
        if (oldPasswordFromDB.equalsIgnoreCase(oldPasswordFromForm) && newPasswordFromForm.equalsIgnoreCase(newPasswordToCheckFromForm)) {
            userFromTheDB.setPassword(newPasswordFromForm);
            manager.updateUser(userFromTheDB);
            System.out.println("Passordet ble endret");
            response.sendRedirect("/Slit/MyPage/PasswordSuccess.jsp");

        } else {
            response.sendRedirect("/Slit/MyPage/FailedPassword.jsp");
        }
    }

    /**
     * Standard Java metode for HTTP Get
     *
     * @param request  Et HTTP request objekt
     * @param response Et HTTP response objekt
     * @throws ServletException standard java exception
     * @throws IOException      standard java exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        changePassword(request, response);
    }

    /**
     * Standard Java metode for HTTP Post
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {


            changePassword(request, response);
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }
}