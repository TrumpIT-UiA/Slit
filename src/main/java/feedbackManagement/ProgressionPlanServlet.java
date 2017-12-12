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

        getAllFromDB(res, p1, p2, p3, p4, p5);
    }

    private void getAllFromDB(HttpServletResponse res, String p1, String p2, String p3, String p4, String p5) throws IOException {
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

        int totalDelivered = antallModul1 + antallModul2 + antallModul3 + antallModul4 + antallModul5;

        String i1 = "<div id=\"bar1\" style= \"height: " + intersection1 + "cm\">M #1<br>Score " + intersection1 + "</div>";
        String i2 = "<div id=\"bar2\" style= \"height: " + intersection2 + "cm\">M #2<br>Score " + intersection2 + "</div>";
        String i3 = "<div id=\"bar3\" style= \"height: " + intersection3 + "cm\">M #3<br>Score " + intersection3 + "</div>";
        String i4 = "<div id=\"bar4\" style= \"height: " + intersection4 + "cm\">M #4<br>Score " + intersection4 + "</div>";
        String i5 = "<div id=\"bar5\" style= \"height: " + intersection5 + "cm\">M #5<br>Score " + intersection5 + "</div>";

        writeNewJSP(res, p1, p2, p3, p4, p5, i1, i2, i3, i4, i5, totalDelivered, antallModul1, antallModul2, antallModul3, antallModul4, antallModul5);
    }

    /**
     * Denne metoden skriver hele den nye JSP-en, dette må gjøre fordi diverse html elementer
     * kan være forskjellige fra gang til gang - i dette tilfelle: høyden på stolpene diagrammet.
     * res må være inkludert pga PrintWriter();
     * p1, p2, p3, p4, p5: stolpene i diagrammet hvor scoren er høyden i cm.
     * i1, i2, i3, i4, i5: stolpene i diagrammet hvor høyden er gjennomsnittsverdien av score.
     * a, b, c, d, e: antall ganger én modul har blitt levert; ex: a er antall ganger modul 1 har blitt levert.
     *
     * @param res
     * @param p1
     * @param p2
     * @param p3
     * @param p4
     * @param p5
     * @param i1
     * @param i2
     * @param i3
     * @param i4
     * @param i5
     * @param totalDelivered
     * @param a
     * @param b
     * @param c
     * @param d
     * @param e
     * @throws IOException
     */
    private void writeNewJSP(HttpServletResponse res, String p1, String p2, String p3, String p4, String p5, String i1, String i2, String i3, String i4, String i5, int totalDelivered, int a, int b, int c, int d, int e) throws IOException {
        PrintWriter out = res.getWriter();

        out.write("<!--Interphase by TEMPLATED\n" +
                "templated.co @templatedco\n" +
                "Released for free under the Creative Commons Attribution 3.0 license (templated.co/license)\n" +
                "Modified for use in SLIT -->\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <!-- <meta charset=\"UTF-8\"> -->\n" +
                "    <title>Slit</title>\n" +
                "    <meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\"/>\n" +
                "    <meta name=\"description\" content=\"\"/>\n" +
                "    <meta name=\"keywords\" content=\"\"/>\n" +
                "\n" +
                "    <script src=\"/Slit/Static/js/jquery.min.js\"></script>\n" +
                "    <script src=\"/Slit/Static/js/skel.min.js\"></script>\n" +
                "    <script src=\"/Slit/Static/js/skel-layers.min.js\"></script>\n" +
                "    <script src=\"/Slit/Static/js/init.js\"></script>\n" +
                "    <script src=\"/Slit/Static/Javascript/goToTop.js\"></script>\n" +
                "\n" +
                "    <link rel=\"stylesheet\" href=\"/Slit/Static/Styles/skel.css\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"/Slit/Static/Styles/style.css\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"/Slit/Static/Styles/style-xlarge.css\"/>\n" +
                "    <link rel=\"stylesheet\" href=\"/Slit/Static/Styles/barChartStylesheet.css\"/>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body>\n" +
                "<!-- Header -->\n" +
                "<header id=\"header\">\n" +
                "    <h1><a href=\"../../App/welcome.jsp\">Slit</a></h1>\n" +
                "    <nav id=\"nav\">\n" +
                "        <ul>\n" +
                "            <li><a href=\"../../App/welcome.jsp\">Home</a></li>\n" +
                "            <li><a href=\"../../App/Module/ViewModule.jsp\">Moduler</a></li>\n" +
                "            <li><a href=\"../../Admin/AdminPage.jsp\">Admin</a></li>\n" +
                "        </ul>\n" +
                "    </nav>\n" +
                "</header>\n" +
                "\n" +
                "<!-- Main -->\n" +
                "<section id=\"main\" class=\"wrapper\">\n" +
                "    <div class=\"container\">\n" +
                "\n" +
                "        <header class=\"major\">\n" +
                "            <h2>Stolpediagram for din progresjon</h2>\n" +
                "            <p>Her finner du din progresjon i IS-109" +
                "        </header>" +
                "<main style=\"display: inline-block\">" +
                "<h1 style=\"position: relative\"></h1>" +
                "<div class=\"bars\">" +
                p1 +
                p2 +
                p3 +
                p4 +
                p5 +
                "</div>" +
                "<br>" +
                "<h2 style=\"position: relative\">Gjennomsnitt-score per modul i IS-109 for alle leverte moduler</h1>" +
                "<br>" +
                "<div class=\"bars\" style=\"margin-top: 60px bottom: 200px\">" +
                i1 +
                i2 +
                i3 +
                i4 +
                i5 +
                "</div>" +
                "<div style=\"position: relative; margin-bottom: 40px; margin-top: 30px;\">" +
                "<BR>Totalt antall leverte moduler i IS-109: " + totalDelivered + " moduler" +
                "<BR>Antall som har levert modul 1: " + a + " personer." +
                "<BR>Antall som har levert modul 2: " + b + " personer." +
                "<BR>Antall som har levert modul 3: " + c + " personer." +
                "<BR>Antall som har levert modul 4: " + d + " personer." +
                "<BR>Antall som har levert modul 5: " + e + " personer." +
                "</div>" +
                "</main>" +
                "</div>\n" +
                "</section>\n" +
                "\n" +
                "<!-- Footer -->\n" +
                "<footer id=\"footer\">\n" +
                "    <div class=\"container\">\n" +
                "        <div class=\"row\">\n" +
                "            <section class=\"4u$ 12u$(medium) 12u$(small)\">\n" +
                "                <h3>Kontakt oss</h3>\n" +
                "                <ul class=\"icons\">\n" +
                "                    <li><a href=\"https://github.com/TrumpIT-UiA\" class=\"icon rounded fa-github\"><span class=\"label\">Github</span></a>\n" +
                "                    </li>\n" +
                "                </ul>\n" +
                "            </section>\n" +
                "        </div>\n" +
                "        <ul class=\"copyright\">\n" +
                "            <li>&copy; Untitled. All rights reserved.</li>\n" +
                "            <li>Design: <a href=\"http://templated.co\">TEMPLATED</a></li>\n" +
                "            <li>Images: <a href=\"http://unsplash.com\">Unsplash</a></li>\n" +
                "        </ul>\n" +
                "    </div>\n" +
                "</footer>\n" +
                "<a>\n" +
                "    <button onclick=\"topFunction()\" id=\"goToTop\" title=\"Go to top\">Gå til toppen</button>\n" +
                "</a>\n" +
                "</body>\n" +
                "</html>");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Denne henter ut den innloggede brukeren sin score på hver modul.
        getFromDB(request, response);

        //Denne metoden regner ut gjennomsnittsscore til leverte moduler
        //- altså, dersom noen ikke har levert vil ikke dette bli tatt med i beregningen
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
