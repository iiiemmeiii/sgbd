package sgbdproj.models.dao.interfaces;

import java.util.List;

import sgbdproj.models.dto.SectionDTO;

public interface ISectionDAO {
    List<SectionDTO> getSection();

    SectionDTO getSectionById(int id);

    boolean createSection(String nom);

    boolean updateSection(int id, String nom);

    boolean deleteSection(int id);
}
