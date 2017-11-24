package feedbackManagement;

import users.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "WriteFeedbackServlet", urlPatterns = "/WriteFeedback")
public class WriteFeedbackServlet extends HttpServlet {

    private void checkButtonValue(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (req.getParameter("module") == null) {
            String errorMessage = "NB! Du må velge modulnummer!";
            req.getSession().setAttribute("errorMessage", errorMessage);
            res.sendRedirect("WriteFeedBack.jsp");
        } else if (req.getParameter("module").equals("1")) {
            String modulNr = "1";
            getParametersJSP(modulNr, req, res);
        } else if (req.getParameter("module").equals("2")) {
            String modulNr = "2";
            getParametersJSP(modulNr, req, res);
        } else if (req.getParameter("module").equals("3")) {
            String modulNr = "3";
            getParametersJSP(modulNr, req, res);
        } else if (req.getParameter("module").equals("4")) {
            String modulNr = "4";
            getParametersJSP(modulNr, req, res);
        } else if (req.getParameter("module").equals("5")) {
            String modulNr = "5";
            getParametersJSP(modulNr, req, res);
        }
    }

    private void getParametersJSP(String modulNr, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String feedback = req.getParameter("feedback");
        String score = req.getParameter("score");
        int scoreInt = Integer.parseInt(score);

        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        String currentUserEmail = loggedInUser.getEmail();
        String primaryChunk = currentUserEmail + modulNr + "fb";

        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateobj = new Date();
        String timeWritten = df.format(dateobj);

        Feedback f = new Feedback(primaryChunk, feedback, scoreInt, timeWritten);
        try {
            saveToDB(f, req, res);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ServletException se) {
            se.printStackTrace();
        }
    }

    @EJB
    private FeedbackManagerLocal feedbackml;

    private void saveToDB(Feedback f, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        if (feedbackml.updateFeedback(f)) {
            req.getSession().setAttribute("feedbackContent", f.getFeedbackContent());
            req.getSession().setAttribute("score", f.getScore());
            req.getSession().setAttribute("timeWritten", f.getTimeWritten());
            res.sendRedirect("/Slit/ReadFeedback.jsp");
        } else {
            feedbackml.saveFeedback(f);
                req.getSession().setAttribute("feedbackContent", f.getFeedbackContent());
                req.getSession().setAttribute("score", f.getScore());
                req.getSession().setAttribute("timeWritten", f.getTimeWritten());
                res.sendRedirect("/Slit/ReadFeedback.jsp");
            }
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkButtonValue(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
