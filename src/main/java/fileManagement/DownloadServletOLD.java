package fileManagement;

import javax.ejb.EJB;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Emil-Ruud
 */
@WebServlet(name = "DownloadServletOLD", urlPatterns = {"/DownloadOLD"})
@MultipartConfig(maxFileSize = 10485760) //10Mib
public class DownloadServletOLD extends HttpServlet {

    @EJB
    FileManagerLocal fml;

    private void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        //Query query = fml.createQuery("SELECT id FROM FileEntity where id = :idParam").setParameter("idParam,", 1);
        // query.setParameter("idParam", 1);
        //FileEntity fe = (FileEntity) query.getSingleResult();

        //out.println(fe.getFilename());

        out.print(getFile(1).getName());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        download(request, response);
    }

    // Takes file ID from database as parameter and returns the corresponding File entity.
    private File getFile(int id) {

        // ??? Får IllegalStateException: EntityManager is closed.
        Query query = fml.createQuery("SELECT fileID FROM File WHERE fileID = :idParam").setParameter("idParam", id);

        // ??? Mulig det er lurere å endre typen til Object istedenfor å caste til File.
        return (File) query.getResultList();
    }
}