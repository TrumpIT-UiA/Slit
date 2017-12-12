package userManagement;

import com.sun.org.apache.regexp.internal.RE;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import userManagement.UserManagerLocal;
import users.Student;
import users.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "ProfilePictureServlet",urlPatterns = "ProfilePicture")
public class ProfilePictureServlet extends HttpServlet
{
@EJB
    UserManagerLocal uml;


    /**
     *
     * @param req
     * @param res
     * @throws ServletException
     * @throws NullPointerException
     * @throws IOException
     */
    public void getPicture(HttpServletRequest req, HttpServletResponse res) throws ServletException,NullPointerException,IOException {
        final Part filePart = req.getPart("file");
        InputStream filePartIStream = filePart.getInputStream();
        String email = req.getRemoteUser();
        Student student = new Student();
        student.setEmail(email);
        student.setProfileImage(convertToByteArray(filePartIStream));
        // if setning for å sjekke om filen er av riktig format
        uml.updateUser(student);
        res.sendRedirect("/Slit/MyPage/PasswordSuccess.jsp");
    }


    /**
     * @Author Emil
     * @param filePartInputStream
     * @return
     * @throws IOException
     */

    private byte[] convertToByteArray(InputStream filePartInputStream) throws IOException {
        int bytesRead;
        byte[] buffer = new byte[8192];
        ByteArrayOutputStream fileOutPutStream = new ByteArrayOutputStream();

        while ((bytesRead = filePartInputStream.read(buffer)) != -1) {
            fileOutPutStream.write(buffer, 0, bytesRead);
        }
        fileOutPutStream.flush();

        return fileOutPutStream.toByteArray();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        {
            getPicture(request, response);


        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
