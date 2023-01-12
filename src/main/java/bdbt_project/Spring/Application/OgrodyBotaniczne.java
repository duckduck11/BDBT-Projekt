package bdbt_project.Spring.Application;

public class OgrodyBotaniczne {
    private int ID_Ogrodu_Botanicznego;
    private String nazwa;
    private String data_zalozenia;
    private String numer_telefonu;
    private String adres_email;
    private int ID_Adresu;

    public OgrodyBotaniczne(int ID_Ogrodu_Botanicznego, String nazwa, String data_zalozenia, String numer_telefonu, String adres_email, int ID_Adresu) {
        this.ID_Ogrodu_Botanicznego = ID_Ogrodu_Botanicznego;
        this.nazwa = nazwa;
        this.data_zalozenia = data_zalozenia;
        this.numer_telefonu = numer_telefonu;
        this.adres_email = adres_email;
        this.ID_Adresu = ID_Adresu;
    }

    public OgrodyBotaniczne(){

    }

    public int getID_Ogrodu_Botanicznego() {
        return ID_Ogrodu_Botanicznego;
    }

    public void setID_Ogrodu_Botanicznego(int ID_Ogrodu_Botanicznego) {
        this.ID_Ogrodu_Botanicznego = ID_Ogrodu_Botanicznego;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getData_zalozenia() {
        return data_zalozenia;
    }

    public void setData_zalozenia(String data_zalozenia) {
        this.data_zalozenia = data_zalozenia;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public String getAdres_email() {
        return adres_email;
    }

    public void setAdres_email(String adres_email) {
        this.adres_email = adres_email;
    }

    public int getID_Adresu() {
        return ID_Adresu;
    }

    public void setID_Adresu(int ID_Adresu) {
        this.ID_Adresu = ID_Adresu;
    }

    @Override
    public String toString() {
        return "OgrodyBotaniczne{" +
                "ID_Ogrodu_Botanicznego=" + ID_Ogrodu_Botanicznego +
                ", nazwa='" + nazwa + '\'' +
                ", data_zalozenia='" + data_zalozenia + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", adres_email='" + adres_email + '\'' +
                ", ID_Adresu=" + ID_Adresu +
                '}';
    }

}
