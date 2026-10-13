package sgbdproj.models.dao.interfaces;

import java.util.List;

import sgbdproj.models.dto.StatusDTO;

public interface IStatusDAO {
    public List<StatusDTO> getStatus();

    public StatusDTO getStatusById(int ind);

    public boolean createStatus(String status);

    public boolean updateStatus(int id, String status);

    public boolean deleteStatus(int id);

}
