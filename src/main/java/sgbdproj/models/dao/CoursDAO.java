package sgbdproj.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sgbdproj.models.dao.interfaces.ICoursDAO;
import sgbdproj.models.dto.CoursDTO;

public class CoursDAO implements ICoursDAO {
    private final Connection connection;

    public CoursDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<CoursDTO> getCours() {
        List<CoursDTO> cours = new ArrayList<>();
        //
        String sql = """
                SELECT id, nom, section_id FROM cours;
                """;
        try (
                PreparedStatement stm = this.connection.prepareStatement(sql);
                ResultSet resultSet = stm.executeQuery();) {

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nom = resultSet.getString(2);
                String sectionId = resultSet.getString("section_id");

                cours.add(new CoursDTO(id, nom, sectionId));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //
        return cours;
    }

    @Override
    public CoursDTO getCoursById(int id) {
        CoursDTO c = null;
        String sql = "SELECT * FROM cours WHERE id = ?";
        try (PreparedStatement stm = this.connection.prepareStatement(sql);) {
            stm.setInt(1, id);
            try (ResultSet resultSet = stm.executeQuery();) {
                while (resultSet.next()) {
                    int cours_id = resultSet.getInt(1);
                    String nom = resultSet.getString(2);
                    String section_id = resultSet.getString(3);
                    c = new CoursDTO(cours_id, nom, section_id);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    @Override
    public boolean createCours(String nom) {
        String sql = """
                INSERT INTO cours (nom)
                VALUES (?);
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, nom);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCours(int id, String nom) {
        String sql = """
                UPDATE cours
                SET nom = ?
                WHERE id = ?;
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setString(1, nom);
            ps.setInt(2, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCours(int id) {
        String sql = """
                DELETE FROM cours
                WHERE id = ?;
                """;
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
