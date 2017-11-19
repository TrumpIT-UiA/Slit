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

    @EJB
    private FeedbackManagerLocal fbml;

    private void getFromDB(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        String currentUser = loggedInUser.getEmail();

        Feedback fb = fbml.getFeedback(1);
        String feedbackcontent = fb.getFeedback();
        int score = fb.getScore();

        try {
            writeToJSP(req, res, feedbackcontent, score);
        } catch (ServletException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void writeToJSP(HttpServletRequest req, HttpServletResponse res, String feedbackcontent, int score) throws ServletException, IOException {
        req.getSession().setAttribute("feedbackContent", feedbackcontent);
        req.getSession().setAttribute("score", score);
        res.sendRedirect("ReadFeedback.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getFromDB(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
