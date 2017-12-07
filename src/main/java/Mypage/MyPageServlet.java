package Mypage;
import userManagement.UserManagerLocal;
import users.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Nicolay
 * Opprettet 11.13.2017
 * Sist oppdatert av: Nicolay Leknes dato: 07/12/2017
 *Servlet for å håndtere mypage
 */
@WebServlet(name = "MyPageServlet", urlPatterns = {"/MyPage"})
public class MyPageServlet extends HttpServlet {

private String message;

    @EJB
    UserManagerLocal manager;

    /**
     * @throws IOException
     * Lager ny httpsession med navnet session
     * Setter maks session time før logout
     * Henter ut informasjon fra session
     */
    private void sessionAccept(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30 * 60);
        User loggedInUser = (User) session.getAttribute("TheLoggedInUser");

        String fnavn = loggedInUser.getfName();
        String enavn = loggedInUser.getlName();
        String epost = loggedInUser.getEmail();


        session.setAttribute("messageJSP", "Velkommen" + "epost");
        response.sendRedirect("Innstillinger.jsp");

    }
    /**
     * @throws IOException
     * Gjør HTML lesbart
     * Redirecter til mypage.jsp
     */
    private void mainPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
       // message = "Vælkommen til servlet av Nicolay";
        response.sendRedirect("MyPage.jsp");
    }

    /**
     * @throws IOException
     * (Lage en logut som avslutter session)
     */
    private void Logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
    }

    /**
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        mainPage(request, response);
    }

    /**
     *
     */

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sessionAccept(request, response);
    }
}





