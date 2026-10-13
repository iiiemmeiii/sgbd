package sgbdproj;

import java.sql.Connection;
import java.sql.SQLException;

import sgbdproj.controller.CoursController;
import sgbdproj.controller.SectionController;
import sgbdproj.controller.StatusController;
import sgbdproj.models.bootstrap.PostgresInitializeDb;
import sgbdproj.models.config.PostgresDbConnection;
import sgbdproj.models.dao.CoursDAO;
import sgbdproj.models.dao.SectionDAO;
import sgbdproj.models.dao.StatusDAO;

public class Connexion {
    public static void main(String[] args) {
        //
        PostgresInitializeDb.initialize();

        try (Connection connection = PostgresDbConnection.getConnection();) {

            // CONNECTION //
            CoursDAO coursDAO = new CoursDAO(connection);
            CoursController coursController = new CoursController(coursDAO);

            coursController.getAllCours();
            coursController.getUniqueCours(1);
            // coursController.createCours("");

            //
            System.out.println("\n##############CONTROLLER DIVIDER###########\n");

            SectionDAO sectionDAO = new SectionDAO(connection);
            SectionController sectionController = new SectionController(sectionDAO);
            sectionController.getAllSection();

            System.out.println("\n##############CONTROLLER DIVIDER###########\n");

            StatusDAO statusDAO = new StatusDAO(connection);
            StatusController statusController = new StatusController(statusDAO);
            statusController.getAllStatus();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
