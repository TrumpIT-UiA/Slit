package fileManagement;

import javax.ejb.Local;

/**
 * @Author Emil-Ruud
 */

@Local
public interface FileManagerLocal {
    FileEntity getFile(int id);
    boolean saveFile(FileEntity fileEntity);
    boolean updateFile(FileEntity fileEntity);
}
