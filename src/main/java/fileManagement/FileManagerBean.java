package fileManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class FileManagerBean implements FileManagerLocal {

    @PersistenceContext
    private EntityManager emFile;

    public FileManagerBean() {
        // Når persistence/stateless/entitymanager blir brukt MÅ det være en tom constructor
    }

    @Override
    public File getFile(int id) { return emFile.find(File.class, id); }

    // Returns a list containing FileEntity objects.
    @Override
    public List getListFromQuery(String query, Class<File> fileClass){
        return emFile.createNativeQuery(query, fileClass).getResultList();
    }

    @Override
    public Query createQuery(String query, Class<File> fileClass) {
        return emFile.createQuery(query);
    }

    @Override
    public boolean saveFile(File file) {
        File existing = getFile(file.getId());
        if (existing == null) {
            emFile.persist(file);
            emFile.flush();
        } else {
            return false;
        }
        return true;
    }

    public boolean updateFile(File file) {
        File existing = getFile(file.getId());
        if (existing != null) {
            emFile.persist(file);
        } else {
            return false;
        }
        return true;
    }
}