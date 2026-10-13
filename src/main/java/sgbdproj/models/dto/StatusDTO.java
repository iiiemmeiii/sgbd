package sgbdproj.models.dto;

public class StatusDTO {
    private final int _id;
    private String _status;

    public StatusDTO(int id, String status) {
        this._id = id;
        this._status = status; 
    }

    public String getstatus() {
        return this._status;
    }

    public void setstatus(String value) {
        this._status = value;
    }

    public int getId() {
        return this._id;
    }
    
}
