package bdbt_project.Spring.Application;

public class Ogrody {
    private int ID_Ogrodu;
    private String nazwa;
    private String opis;
    private int ID_Ogrodu_Botanicznego;
    private int ID_Strefy_Klimatycznej;

    public Ogrody(int ID_Ogrodu, String nazwa, String opis, int ID_Ogrodu_Botanicznego, int ID_Strefy_Klimatycznej) {
        this.ID_Ogrodu = ID_Ogrodu;
        this.nazwa = nazwa;
        this.opis = opis;
        this.ID_Ogrodu_Botanicznego = ID_Ogrodu_Botanicznego;
        this.ID_Strefy_Klimatycznej = ID_Strefy_Klimatycznej;
    }

    public Ogrody(){

    }

    public int getID_Ogrodu() {
        return ID_Ogrodu;
    }

    public void setID_Ogrodu(int ID_Ogrodu) {
        this.ID_Ogrodu = ID_Ogrodu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getID_Ogrodu_Botanicznego() {
        return ID_Ogrodu_Botanicznego;
    }

    public void setID_Ogrodu_Botanicznego(int ID_Ogrodu_Botanicznego) {
        this.ID_Ogrodu_Botanicznego = ID_Ogrodu_Botanicznego;
    }

    public int getID_Strefy_Klimatycznej() {
        return ID_Strefy_Klimatycznej;
    }

    public void setID_Strefy_Klimatycznej(int ID_Strefy_Klimatycznej) {
        this.ID_Strefy_Klimatycznej = ID_Strefy_Klimatycznej;
    }

    @Override
    public String toString() {
        return "Ogrody{" +
                "ID_Ogrodu=" + ID_Ogrodu +
                ", nazwa='" + nazwa + '\'' +
                ", opis='" + opis + '\'' +
                ", ID_Ogrodu_Botanicznego=" + ID_Ogrodu_Botanicznego +
                ", ID_Strefy_Klimatycznej=" + ID_Strefy_Klimatycznej +
                '}';
    }
}
