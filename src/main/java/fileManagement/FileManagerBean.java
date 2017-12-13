package fileManagement;

import users.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * @Author Emil-Ruud
 */

@Stateless
public class FileManagerBean implements FileManagerLocal {

    @PersistenceContext
    private EntityManager emFile;

    public FileManagerBean() {
        // Når persistence/stateless/entitymanager blir brukt MÅ det være en tom constructor
    }

    @Override
    public File getFile(String mergedNrEmail) {
        return emFile.find(File.class, mergedNrEmail);
    }

    @Override
    public List getListFromQuery(String query, Class<File> fileClass) {
        if (emFile.isOpen()) {
            return emFile.createNativeQuery(query, fileClass).getResultList();

        } else {
            return null;
        }
    }

    @Override
    public Query createQuery(String query) {
        if (emFile.isOpen()) {
            return emFile.createQuery(query);
        } else {
            return null;
        }
    }

    @Override
    public boolean saveFile(File file) {
        File existing = getFile(file.getMergedNrEmail());
        if (existing == null) {
            emFile.persist(file);
            emFile.flush();
        } else {
            return false;
        }
        return true;
    }

    @Override
    public Collection<Object> returnAllFilesFromDB() {
        Query query = emFile.createQuery("SELECT e FROM File e");
        return (Collection<Object>) query.getResultList();
    }

    @Override
    public boolean updateFile(File file, HttpServletRequest request, HttpServletResponse response) throws NullPointerException {
        File existing = getFile(file.getMergedNrEmail());
            if (existing != null) {
                emFile.merge(file);
                emFile.flush();
            } else {
                return false;
            }
            return true;
    }

}