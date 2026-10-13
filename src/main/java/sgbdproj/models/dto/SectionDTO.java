package sgbdproj.models.dto;

public class SectionDTO {
    private final int _id;
    private final String _nom;

    public SectionDTO(int id, String nom) {
        this._id = id;
        this._nom = nom;
    }

    public int getId() {
        return this._id;
    }

    public String getNom() {
        return this._nom;
    }

    public String getString() {
        String str = String.format("id: %s | nom: %s", this._id, this._nom);
        return str;
    }
}
