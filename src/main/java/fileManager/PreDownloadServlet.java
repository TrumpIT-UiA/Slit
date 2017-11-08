package fileManager;

import fileManager.FileEntity;
import fileManager.FileManagerLocal;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PDS", urlPatterns = {"/PDS"})
public class PreDownloadServlet extends HttpServlet {

    private EntityManager emDL;

    @EJB
    FileManagerLocal fml;

    private void pds(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = response.getWriter();

        printWriter.println("xD");
      /*  List<FileEntity> fileList = emDL.createQuery("select * from fileentity").getResultList();

        String password = request.getParameter("password");
        String name = request.getParameter("loginid");

        printWriter.print(password);
        printWriter.print(name);


        printWriter.println(fml.getFile(1));

        for (FileEntity fentity : fileList) {
            printWriter.print("\n File ID: " + fentity.getId()
                    + "Filename: " + fentity.getFilename() + "Moudle number: " + fentity.getModulNr());
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pds(request, response);
    }
}