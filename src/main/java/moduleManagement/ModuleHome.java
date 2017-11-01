package moduleManagement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @Author Vebjørn
 * Skal bli en slags oversikt over alle modulene
 */
@WebServlet (name= "ModuleHome", urlPatterns = {"/Modules"})
public class ModuleHome extends HttpServlet {


}
