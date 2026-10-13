package sgbdproj.models.dto;

public class CoursDTO {
    private final int _id;
    private final String _nom;
    private final String _section_id;

    public CoursDTO(int id, String nom, String section_id) {
        _id = id;
        _nom = nom;
        _section_id = section_id;
    };

    public int getId() {
        return _id;
    }

    public String getNom() {
        return _nom;
    }

    public String getSection_id() {
        return _section_id;
    }

    public String geString() {
        String str = String.format("Id: %s | nom: %s | section_id: %s", this._id, this._nom, this._section_id);
        return str;
    }

}
