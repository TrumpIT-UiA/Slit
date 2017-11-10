package fileManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public File getFile(int id) {
        return emFile.find(File.class, id);
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

    @Override
    public boolean updateFile(File file, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String emailActiveUserEmail = (String) session.getAttribute("emailActiveUser");
        String modulNummer = (String) session.getAttribute("modulNummer");
        if (file.getUserEmailFile().equals(emailActiveUserEmail) && getFile(file.getId()).getModulNr().equals(modulNummer)) {
            emFile.merge(file);
            emFile.flush();
        } else {
            return false;
        }
        return true;
    }
}
