package feedbackManagement;

import Diverse.StringEditor;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ProgressionPlanServlet", urlPatterns = "/ProgressionPlan")
public class ProgressionPlanServlet extends HttpServlet {

    @EJB
    private FeedbackManagerLocal fbml;

    private void getFromDB(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getRemoteUser();
        String primaryChunkP1 = email + 1 + "fb";
        String primaryChunkP2 = email + 2 + "fb";
        String primaryChunkP3 = email + 3 + "fb";
        String primaryChunkP4 = email + 4 + "fb";
        String primaryChunkP5 = email + 5 + "fb";
        int scoreInt1;
        int scoreInt2;
        int scoreInt3;
        int scoreInt4;
        int scoreInt5;

        try {
            Feedback fb1 = fbml.getFeedback(primaryChunkP1);
            scoreInt1 = fb1.getScore();
        } catch (NullPointerException npe) {
            scoreInt1 = 0;
        }
        try {
            Feedback fb2 = fbml.getFeedback(primaryChunkP2);
            scoreInt2 = fb2.getScore();
        } catch (NullPointerException npe) {
            scoreInt2 = 0;
        }
        try {
            Feedback fb3 = fbml.getFeedback(primaryChunkP3);
            scoreInt3 = fb3.getScore();
        } catch (NullPointerException npe) {
            scoreInt3 = 0;
        }
        try {
            Feedback fb4 = fbml.getFeedback(primaryChunkP4);
            scoreInt4 = fb4.getScore();
        } catch (NullPointerException npe) {
            scoreInt4 = 0;
        }
        try {
            Feedback fb5 = fbml.getFeedback(primaryChunkP5);
            scoreInt5 = fb5.getScore();
        } catch (NullPointerException npe) {
            scoreInt5 = 0;
        }

        String p1 = "<div id=\"bar1\" style= \"height: " + scoreInt1 + "cm\">M #1<br>Score " + scoreInt1 + "</div>";
        String p2 = "<div id=\"bar2\" style= \"height: " + scoreInt2 + "cm\">M #2<br>Score " + scoreInt2 + "</div>";
        String p3 = "<div id=\"bar3\" style= \"height: " + scoreInt3 + "cm\">M #3<br>Score " + scoreInt3 + "</div>";
        String p4 = "<div id=\"bar4\" style= \"height: " + scoreInt4 + "cm\">M #4<br>Score " + scoreInt4 + "</div>";
        String p5 = "<div id=\"bar5\" style= \"height: " + scoreInt5 + "cm\">M #5<br>Score " + scoreInt5 + "</div>";

        writeNewJSP(res, p1, p2, p3, p4, p5);
    }

    private void getAllFromDB(HttpServletRequest req, HttpServletResponse res) throws IOException {
        List feedbackList = fbml.allEntries();
        StringEditor se = new StringEditor();

        int sumScoreModul1 = 0;
        int sumScoreModul2 = 0;
        int sumScoreModul3 = 0;
        int sumScoreModul4 = 0;
        int sumScoreModul5 = 0;

        int antallModul1 = 0;
        int antallModul2 = 0;
        int antallModul3 = 0;
        int antallModul4 = 0;
        int antallModul5 = 0;

        Iterator<Feedback> iter = feedbackList.iterator();

        while (iter.hasNext()) {
            Feedback f = iter.next();
            String garbage = f.getPrimaryChunk();
            String halfGarbage = se.rmCharsFromString(garbage, 2);
            String moduleNr = se.getLastCharFromString(halfGarbage);
            int modulInt = Integer.parseInt(moduleNr);

            switch (modulInt) {
                case 1:
                    sumScoreModul1 = sumScoreModul1 + f.getScore();
                    antallModul1++;
                    break;
                case 2:
                    sumScoreModul2 = sumScoreModul2 + f.getScore();
                    antallModul2++;
                    break;
                case 3:
                    sumScoreModul3 = sumScoreModul3 + f.getScore();
                    antallModul3++;
                    break;
                case 4:
                    sumScoreModul4 = sumScoreModul4 + f.getScore();
                    antallModul4++;
                    break;
                case 5:
                    sumScoreModul5 = sumScoreModul5 + f.getScore();
                    antallModul5++;
            }
        }

        double intersection1;
        double intersection2;
        double intersection3;
        double intersection4;
        double intersection5;

        if (antallModul1 == 0) {
            intersection1 = 0;
        } else {
            intersection1 = sumScoreModul1 / antallModul1;
        }
        if (antallModul2 == 0) {
            intersection2 = 0;
        } else {
            intersection2 = sumScoreModul2 / antallModul2;
        }
        if (antallModul3 == 0) {
            intersection3 = 0;
        } else {
            intersection3 = sumScoreModul3 / antallModul3;
        }
        if (antallModul4 == 0) {
            intersection4 = 0;
        } else {
            intersection4 = sumScoreModul4 / antallModul4;
        }
        if (antallModul5 == 0) {
            intersection5 = 0;
        } else {
            intersection5 = sumScoreModul5 / antallModul5;
        }
        System.out.println("Gjennomsnitt modul 1: " + intersection1);
        System.out.println("Gjennomsnitt modul 2: " + intersection2);
        System.out.println("Gjennomsnitt modul 3: " + intersection3);
        System.out.println("Gjennomsnitt modul 4: " + intersection4);
        System.out.println("Gjennomsnitt modul 5: " + intersection5);

        int totalDelivered = antallModul1 + antallModul2 + antallModul3 + antallModul4 + antallModul5;

        System.out.println("Antall som har levert modul 1: " + antallModul1);
        System.out.println("Antall som har levert modul 2: " + antallModul2);
        System.out.println("Antall som har levert modul 3: " + antallModul3);
        System.out.println("Antall som har levert modul 4: " + antallModul4);
        System.out.println("Antall som har levert modul 5: " + antallModul5);

        System.out.println("Antall leverte moduler med feedback: " + totalDelivered);

        String p1 = "<div id=\"bar1\" style= \"height: " + intersection1 + "cm\">M #1<br>Score " + intersection1 + "</div>";
        String p2 = "<div id=\"bar2\" style= \"height: " + intersection2 + "cm\">M #2<br>Score " + intersection2 + "</div>";
        String p3 = "<div id=\"bar3\" style= \"height: " + intersection3 + "cm\">M #3<br>Score " + intersection3 + "</div>";
        String p4 = "<div id=\"bar4\" style= \"height: " + intersection4 + "cm\">M #4<br>Score " + intersection4 + "</div>";
        String p5 = "<div id=\"bar5\" style= \"height: " + intersection5 + "cm\">M #5<br>Score " + intersection5 + "</div>";

        writeNewJSP(res, p1, p2, p3, p4, p5);
    }

    /**
     * Denne metoden skriver hele den nye JSP-en, dette må gjøre fordi diverse html elementer
     * kan være forskjellige fra gang til gang - i dette tilfelle: stolpediagrammet.
     * res må være inkludert inn pga PrintWriter();
     * p1, p2, p3, p4, p5 er stolpene i diagrammet hvor scoren er høyden i cm.
     * @param res
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @param p5
     * @throws IOException
     */
    private void writeNewJSP(HttpServletResponse res, String p1, String p2, String p3, String p4, String p5) throws IOException {
        PrintWriter out = res.getWriter();

        out.write("<!DOCTYPE html>");
        out.write("<html lang=\"no\">");
        out.write("<head>");
        out.write("<title>Modulbeskrivelse & Innlevering</title>");
        out.write("<meta charset=\"UTF-8\">");
        out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
        out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"Templates/CSS/MainPageTemplate.css\">");
        out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"Templates/CSS/barChartStylesheet.css\">");
        out.write("<script src=\"Templates/Javascript/goToTop.js\"></script>");
        out.write("</head>");
        out.write("<body>");
        out.write("<div class=\"navbar\">");
        out.write("<a href=\"/App/welcome.jsp\">&Sopf;&Lopf;&Iopf;&Topf;</a>");
        out.write("<a href=\"/Admin/opprettAdmin.jsp\">Admin</a>");
        out.write("<a class=\"active\" href=\"/Slit/ModuleDescriptionAndDelivery.jsp\">Moduler</a>");
        out.write("<div class=\"knapperHoyre\">");
        out.write("<a href=\"/Slit/MyPage\">Min side</a>");
        out.write("<a href=\"Logout\">Logout</a>");
        out.write("</div>");
        out.write("</div>");
        out.write("<div class=\"sidenav\">");
        out.write("<label for=\"sidebarFeedback\" class=\"sidenavContent\">");
        out.write("Feedback");
        out.write("</label>");
        out.write("<br>");
        out.write("<label for=\"sidebarProgPlan\" class=\"sidenavContent\" style=\"margin-bottom: 20px;\">");
        out.write("Din progresjon");
        out.write("</label>");
        out.write("<form action=\"ReadFeedback.jsp\">");
        out.write("<input type=\"submit\" id=\"sidebarFeedback\" class=\"sidebarFeedback\">");
        out.write("</form>");
        out.write("<form action=\"/Slit/ProgressionPlan\" method=\"post\">");
        out.write("<input type=\"submit\" id=\"sidebarProgPlan\" class=\"sidebarProgPlan\">");
        out.write("</form>");
        out.write("</div>");
        out.write("<main style=\"margin-top: 200px; margin-left: 500px;\">");
        out.write("<h1 style=\"position: relative; top: -80px; right: 220px\">Stolpediagram for din progresjon</h1>");
        out.write("<div class=\"bars\">");
        out.write(p1);
        out.write(p2);
        out.write(p3);
        out.write(p4);
        out.write(p5);
        out.write("</div>");
        out.write("</main>");
        out.write("<button onclick=\"topFunction()\" id=\"goToTop\" title=\"Go to top\">Gå til toppen</button>");
        out.write("</body>");
        out.write("</html>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Denne henter ut den innloggede brukeren sin score på hver modul.
        getFromDB(request, response);

        //Denne metoden regner ut gjennomsnittsscore til leverte moduler
        //- altså, dersom noen ikke har levert vil ikke dette bli tatt med i beregningen

        //getAllFromDB(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
