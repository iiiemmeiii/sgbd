package sgbdproj.models.dao.interfaces;

import java.util.List;

import sgbdproj.models.dto.CoursDTO;

public interface ICoursDAO {
    List<CoursDTO> getCours();

    CoursDTO getCoursById(int id);

    boolean createCours(String nom);

    boolean updateCours(int id, String nom);

    boolean deleteCours(int id);
}
