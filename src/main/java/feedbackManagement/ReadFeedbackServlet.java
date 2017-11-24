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

@WebServlet(name = "ReadFeedbackServlet", urlPatterns = "/ReadFeedback")
public class ReadFeedbackServlet extends HttpServlet {

    private void checkButtonValue(HttpServletRequest request, HttpServletResponse response) {
        if (request.getParameter("module1") != null) {
            int knappTrykketInt = 1;
            getFromDB(knappTrykketInt, request, response);

        } else if (request.getParameter("module2") != null) {
            int knappTrykketInt = 2;
            getFromDB(knappTrykketInt, request, response);

        } else if (request.getParameter("module3") != null) {
            int knappTrykketInt = 3;
            getFromDB(knappTrykketInt, request, response);

        } else if (request.getParameter("module4") != null) {
            int knappTrykketInt = 4;
            getFromDB(knappTrykketInt, request, response);

        } else if (request.getParameter("module5") != null) {
            int knappTrykketInt = 5;
            getFromDB(knappTrykketInt, request, response);
        }
    }

    @EJB
    private FeedbackManagerLocal fbml;

    private void getFromDB(int knappTrykketInt, HttpServletRequest req, HttpServletResponse res) {

        String knappTrykketString = Integer.toString(knappTrykketInt);

        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        String currentUser = loggedInUser.getEmail();

        String primaryChunk = currentUser + knappTrykketString + "fb";

        Feedback fb = fbml.getFeedback(primaryChunk);
        String feedbackcontent = fb.getFeedbackContent();
        int score = fb.getScore();
        String timeWritten = fb.getTimeWritten();

        try {
            writeToJSP(req, res, knappTrykketString, feedbackcontent, score, timeWritten);
        } catch (ServletException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void writeToJSP(HttpServletRequest req, HttpServletResponse res, String knappTrykketString, String feedbackcontent, int score, String timeWritten) throws ServletException, IOException {
        req.getSession().setAttribute("modulnr", knappTrykketString);
        req.getSession().setAttribute("feedbackContent", feedbackcontent);
        req.getSession().setAttribute("score", score);
        req.getSession().setAttribute("timewritten", timeWritten);
        res.sendRedirect("ReadFeedback.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkButtonValue(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkButtonValue(request, response);
    }
}
