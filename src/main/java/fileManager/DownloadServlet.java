package fileManager;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Emil-Ruud
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/Download"})
@MultipartConfig(maxFileSize = 10485760) //10Mib
public class DownloadServlet extends HttpServlet {

    @EJB
    FileManagerLocal fml;

    private void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        download(request, response);
    }
}