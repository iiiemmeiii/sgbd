package sgbdproj.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sgbdproj.models.dao.interfaces.IStatusDAO;
import sgbdproj.models.dto.StatusDTO;

public class StatusDAO implements IStatusDAO {
    private final Connection _connection;

    public StatusDAO(Connection connection) {
        this._connection = connection;
    }

    @Override
    public List<StatusDTO> getStatus() {
        List<StatusDTO> status = new ArrayList<>();
        String sql = """
                SELECT * FROM status
                """;
        try (
                PreparedStatement ps = this._connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);

                status.add(new StatusDTO(id, nom));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public StatusDTO getStatusById(int ind) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean createStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean updateStatus(int id, String status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteStatus(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
