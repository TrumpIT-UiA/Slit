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

@WebServlet(name = "ProgressionPlanServlet", urlPatterns = "/ProgressionPlan")
public class ProgressionPlanServlet extends HttpServlet {

    @EJB
    private FeedbackManagerLocal fbml;

    private void getFromDB(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("loggedInUser");
        String email = user.getEmail();
        int i;
        for (i = 1; i < 5; i++) {
            String iString = Integer.toString(i);
            String primaryChunkP = email + iString + "fb";
            try {
                Feedback fb = fbml.getFeedback(primaryChunkP);
                int score = fb.getScore();
                session.setAttribute("progress" + iString, score);
            } catch (NullPointerException npe) {
                session.setAttribute("progress" + iString, 0);
            }
        }
        res.sendRedirect("ProgressionPlan.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getFromDB(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
