package feedbackManagement;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WriteFeedbackServlet", urlPatterns = "/WriteFeedback")
public class WriteFeedbackServlet extends HttpServlet {
    private void getParametersJSP(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String feedback = req.getParameter("feedback");
        String score = req.getParameter("score");
        int scoreInt = Integer.parseInt(score);

        Feedback f = new Feedback(feedback, scoreInt);
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

    private void saveToDB(Feedback f, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        if (feedbackml.saveFeedback(f) == true) {
            req.getSession().setAttribute("feedbackContent", f.getFeedback());
            req.getSession().setAttribute("score", f.getScore());
            res.sendRedirect("/Slit/ReadFeedback.jsp");
        } else if (feedbackml.saveFeedback(f) == false){
            feedbackml.updateFeedback(f);
            req.getSession().setAttribute("feedbackContent", f.getFeedback());
            req.getSession().setAttribute("score", f.getScore());
            res.sendRedirect("/Slit/ReadFeedback.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getParametersJSP(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
