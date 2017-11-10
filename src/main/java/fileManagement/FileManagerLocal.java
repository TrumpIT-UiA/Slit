package fileManagement;

import javax.ejb.Local;

/**
 * @Author Emil-Ruud
 */

@Local
public interface FileManagerLocal {
    File getFile(int id);
    boolean saveFile(File file);
    boolean updateFile(File file, int modulNummerInt, String userEmailFile);
}
