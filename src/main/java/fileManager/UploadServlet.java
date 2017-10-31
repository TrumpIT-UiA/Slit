package fileManager;

//ServletImport

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//IO-Stream

//Logger - fra Object for å føre feil.

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "UploadServlet", urlPatterns = {"/Upload"})
@MultipartConfig
public class UploadServlet extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException: if a servlet-specific error occurs
     * @throws IOException: if an I/O error occurs
     * @throws FileUploadException
     * @author Emil Ruud
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
            // Check that we have a file upload request
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            // Create a factory for disk-based file items
            if (isMultipart == true) {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // Configure a repository (to ensure a secure temp location is used)
                ServletContext servletContext = this.getServletConfig().getServletContext();
                File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
                factory.setRepository(repository);

                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                // Parse the request
                List<FileItem> items = null;
                try {
                    items = upload.parseRequest(request);
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }

                Iterator<FileItem> iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = iterator.next();
                    if (item.isFormField()) {
                        processFormField(item);
                    } else if (!item.isFormField()) {
                        processUploadedFile(item);
                    }
                }
            } else {
                printWriter.print("Neineinei....");
            }

        }
    private void processUploadedFile(FileItem item) {
        
    }

    private void processFormField(FileItem item) {

    }
}

