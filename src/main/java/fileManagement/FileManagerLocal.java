package fileManagement;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author Emil-Ruud
 */

@Local
public interface FileManagerLocal {
    File getFile(int id);
    boolean saveFile(File file);
    boolean updateFile(File file, HttpServletRequest request);
}
