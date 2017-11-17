package fileManagement;

import sun.misc.IOUtils;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Arrays;
import java.util.List;


/**
 * @author Emil-Ruud
 */
@WebServlet(name = "DownloadServlet", urlPatterns = {"/Download"})
@MultipartConfig(maxFileSize = 10485760) //10Mib
public class DownloadServlet extends HttpServlet {

    @EJB
    private FileManagerLocal fml;

    private void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // PrintWriter out = response.getWriter();

        int fileID = 10;
        File file = fml.getFile(fileID);

        InputStream inStream = new ByteArrayInputStream(file.getFileContent());

        int bytesRead;
        byte[] buffer = new byte[8192];

        while ((bytesRead = inStream.read(buffer)) != -1) {
            response.getOutputStream().write(buffer, 0, bytesRead);
        }
        inStream.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        download(request, response);
    }
/*
    // Takes file ID from database as parameter and returns the corresponding File entity.
    private File getFile(int id) {

        List<File> fileList = fml.getListFromQuery("SELECT * FROM `file`", File.class);

        for (int i = 0; i < fileList.size(); i++) {
            if (fileList.get(i).getId() == id) {
                return fileList.get(i);
            }
        }
        return null;


        // ??? Får IllegalStateException: EntityManager is closed.
        // Query query = fml.createQuery("SELECT id FROM File where id = :idParam", File.class).setParameter("idParam", id);

        // ??? Mulig det er lurere å endre typen til Object istedenfor å kaste til File.
        // return (File) query.getSingleResult();
    }
*/
}