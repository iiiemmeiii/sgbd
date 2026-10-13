package sgbdproj.controller;

import java.sql.SQLException;
import java.util.List;

import sgbdproj.models.dao.StatusDAO;
import sgbdproj.models.dto.StatusDTO;

public class StatusController {

    private final StatusDAO _statusDAO;

    public StatusController(StatusDAO statusDAO) {
        this._statusDAO = statusDAO;
    }

    public void getAllStatus() throws SQLException {
        System.out.println("\nSTATUS: getAllStatus");

        List<StatusDTO> status = _statusDAO.getStatus();

        for (StatusDTO elem : status) {
            System.out.println(elem.getstatus());
        }
    }
}
