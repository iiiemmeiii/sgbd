package sgbdproj.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sgbdproj.models.dao.interfaces.ISectionDAO;
import sgbdproj.models.dto.SectionDTO;

public class SectionDAO implements ISectionDAO {

    private final Connection _conn;
    final String tabName = "Sections";

    public SectionDAO(Connection conn) {
        this._conn = conn;
    }

    @Override
    public List<SectionDTO> getSection() {
        List<SectionDTO> sections = new ArrayList<>();

        String sql = "SELECT * FROM sections";

        try (
                PreparedStatement stm = _conn.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);

                sections.add(new SectionDTO(id, nom));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sections;
    }

    @Override
    public SectionDTO getSectionById(int id) {
        SectionDTO sectionDTO = null;
        String sql = String.format("""
                SELECT * FROM %s
                WHERE id = ?
                """, tabName);

        try (PreparedStatement ps = _conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idSec = rs.getInt(1);
                    String nom = rs.getString(2);

                    sectionDTO = new SectionDTO(idSec, nom);

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sectionDTO;
    }

    @Override
    public boolean createSection(String nom) {
        String sql = String.format("""
                INSERT INTO %s (nom) VALUES (?);
                """, tabName);
        try (PreparedStatement ps = _conn.prepareStatement(sql)) {
            ps.setString(2, nom);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean updateSection(int id, String nom) {
        String sql = String.format("""
                UPDATE TABLE %s SET nom = ? WHERE id = ?;
                """, tabName);
        try (PreparedStatement ps = _conn.prepareStatement(sql)) {
            ps.setString(1, nom);
            ps.setInt(2, id);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteSection(int id) {
        String sql = String.format("""
                DELETE FROM %s WHERE id = ?
                """, tabName);
        try (PreparedStatement ps = _conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

}
