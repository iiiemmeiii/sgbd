package sgbdproj.controller;

import java.sql.SQLException;
import java.util.List;

import sgbdproj.models.dao.SectionDAO;
import sgbdproj.models.dto.SectionDTO;

public class SectionController {
    private final SectionDAO _sectionDAO;

    public SectionController(SectionDAO sectionDAO) {
        this._sectionDAO = sectionDAO;
    }

    public void getAllSection() throws SQLException {
        System.out.println("\nSECTION: getAllSection");

        List<SectionDTO> allSections = _sectionDAO.getSection();
        for (SectionDTO elem : allSections) {
            System.out.println(elem.getString());
        }

    }

    public void getUniqueSection(int id) throws SQLException {
        System.out.println("\nSECTION: getUniqueSection");
        SectionDTO section = _sectionDAO.getSectionById(id);
        System.out.println(section.getString());
    }

    public void createSection(String nom) throws SQLException {
        System.out.println("\nSECTION: createSection");
        boolean isCreated = _sectionDAO.createSection(nom);
        String msg = isCreated ? "SECTION CREATED SUCCESSFULLY" : "ERROR: SECTION CREATED ERROR";
        System.out.println(msg);

    }

    public void updateSection(int id, String nom) throws SQLException {
        System.out.println("\nSECTION: updatedSection");
        boolean isUpdated = _sectionDAO.updateSection(id, nom);
        String msg = isUpdated ? "SECTION UPDATED SUCCESSFULLY" : "ERROR: SECTION UPDATED ERROR";
        System.out.println(msg);

    }

    public void deleteSection(int id) throws SQLException {
        System.out.println("\nSECTION: deleteSection");
        boolean isDeleted = _sectionDAO.deleteSection(id);
        String msg = isDeleted ? "SECTION DELETED SUCCESSFULLY" : "ERROR: SECTION DELETED ERROR";
        System.out.println(msg);

    }

}
