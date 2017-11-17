package fileManagement;

import javax.ejb.Local;
import javax.persistence.Query;
import java.util.List;

@Local
public interface FileManagerLocal {
    File getFile(int id);
    List getListFromQuery(String query, Class<File> fileClass);
    Query createQuery(String query, Class<File> fileClass);
    boolean saveFile(File file);
    boolean updateFile(File file);
}
