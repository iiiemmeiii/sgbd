package sgbdproj.controller;

import java.sql.SQLException;
import java.util.List;

import sgbdproj.models.dao.CoursDAO;
import sgbdproj.models.dto.CoursDTO;

public class CoursController {
    private final CoursDAO _coursDAO;

    public CoursController(CoursDAO coursDAO) {
        this._coursDAO = coursDAO;
    }

    public void getAllCours() throws SQLException {
        System.out.println("\nALL COURS");

        List<CoursDTO> allCours = _coursDAO.getCours();
        for (CoursDTO elem : allCours) {
            System.out.println(elem.geString());
        }
    }

    public void getUniqueCours(int id) throws SQLException {
        System.out.println("\n UNIQUE COURS");

        System.out.println(_coursDAO.getCoursById(id));

    }

    public void createCours(String nom) throws SQLException {
        System.out.println("\n CREATE COURS");

        boolean isCreated = _coursDAO.createCours(nom);

        String msg = isCreated ? "COURS CREATED SUCESSFULLY" : "ERROR: COURS CREATED ERROR";
        System.out.println(msg);
    }

    public void updateCours(int id, String nom) throws SQLException {
        System.out.println("\n UPDATE COURS");

        boolean isUpdated = _coursDAO.updateCours(id, nom);

        String msg = isUpdated ? "COURS UPDATED SUCESSFULLY" : "ERROR: COURS UPDATED ERROR";
        System.out.println(msg);

    }

    public void updateCours(int id) throws SQLException {
        System.out.println("\n DELETE COURS");

        boolean isDeleted = _coursDAO.deleteCours(id);

        String msg = isDeleted ? "COURS DELETED SUCESSFULLY" : "ERROR: COURS DELETED ERROR";
        System.out.println(msg);
    }
}
