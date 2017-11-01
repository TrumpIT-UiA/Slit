package fileManager;

import javax.ejb.Local;

@Local
public interface FileManagerLocal {
    FileEntity getFile(String id);
    boolean saveFile(FileEntity fileEntity);
    boolean updateFile(FileEntity fileEntity);
}
