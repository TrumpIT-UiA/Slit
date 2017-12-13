package userManagement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LogoutServlet", urlPatterns = {"Log"})
    public class LogoutServlet extends HttpServlet {

    /**
     * Metode for muligheten til å avslutte sesjonen, og logge ut.
     *
     * @param request  Et HTTP Request objekt
     * @param respone Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     *
     */
        public void logout (HttpServletRequest request,HttpServletResponse respone) throws ServletException, IOException {
            HttpSession avslutt = request.getSession();
           // String logga = request.getRemoteUser();
                    avslutt.invalidate();
            avslutt.getId();

            respone.sendRedirect("/Slit/MyPage/Logout.jsp");

            }

    /**
     * Standard Java metode for HTTP Post
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logout(request,response);
        }
    /**
     * Standard Java metode for HTTP Post
     *
     * @param request  Et HTTP Request objekt
     * @param response Et HTTP Response objekt
     * @throws ServletException Standard java exception
     * @throws IOException      Standard java exception
     */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logout(request,response);
        }
    }

