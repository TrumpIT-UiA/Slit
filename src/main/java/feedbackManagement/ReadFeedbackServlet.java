package feedbackManagement;

import Diverse.StringEditor;

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

    StringEditor stringLinebreak = new StringEditor();

    private void checkButtonValue(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void getFromDB(int knappTrykketInt, HttpServletRequest req, HttpServletResponse res) throws IOException {

        String knappTrykketString = Integer.toString(knappTrykketInt);

        HttpSession session = req.getSession();
        String currentUser = req.getRemoteUser();

        String primaryChunk = currentUser + knappTrykketString + "fb";

        Feedback fb = fbml.getFeedback(primaryChunk);
        if (fb == null) {
            writeNullToJSP(req, res, knappTrykketString);
        } else {
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
    }

    private void writeToJSP(HttpServletRequest req, HttpServletResponse res, String knappTrykketString, String feedbackcontent, int score, String timeWritten) throws ServletException, IOException {
        req.getSession().setAttribute("feedbackError", null);
        req.getSession().setAttribute("modulnr", knappTrykketString);
        req.getSession().setAttribute("comment", stringLinebreak.LineBreak(feedbackcontent));
        req.getSession().setAttribute("score", score);
        req.getSession().setAttribute("timewritten", timeWritten);
        res.sendRedirect("ReadFeedback.jsp");
    }
    private void writeNullToJSP(HttpServletRequest req, HttpServletResponse res, String knappTrykketString) throws IOException {
        String feedbackError = "Det skjedde en feil ¯\\_(&#x30C4;)_/¯<BR>Vi fant dessverre ingenting i databasen.<BR>Tips: Spør læreren om han/hun har lagt ut feedback til din modul nr. " + knappTrykketString + ".";
        req.getSession().setAttribute("feedbackError", feedbackError);
        req.getSession().setAttribute("modulnr", null);
        req.getSession().setAttribute("comment", null);
        req.getSession().setAttribute("score", null);
        req.getSession().setAttribute("timewritten", null);
        res.sendRedirect("ReadFeedback.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkButtonValue(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        checkButtonValue(request, response);
    }
}
