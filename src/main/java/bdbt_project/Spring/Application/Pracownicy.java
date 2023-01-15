package bdbt_project.Spring.Application;


public class Pracownicy {
    private int ID_Pracownika;
    private String imie;
    private String nazwisko;
    private String plec;
    private String data_urodzenia;
    private String pesel;
    private String numer_telefonu;
    private String numer_konta;
    private int ID_Ogrodu_Botanicznego;
    private int ID_Adresu;

    public Pracownicy(int ID_Pracownika, String imie, String nazwisko, String plec, String data_urodzenia, String pesel, String numer_telefonu, String numer_konta, int iID_Ogrodu_Botanicznego, int ID_Adresu) {
        super();
        this.ID_Pracownika = ID_Pracownika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.numer_telefonu = numer_telefonu;
        this.numer_konta = numer_konta;
        this.ID_Ogrodu_Botanicznego = ID_Ogrodu_Botanicznego;
        this.ID_Adresu = ID_Adresu;
    }

    public Pracownicy(){

    }


    @Override
    public String toString() {
        return "Pracownicy{" +
                "ID_Pracownika=" + ID_Pracownika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", numer_konta='" + numer_konta + '\'' +
                ", ID_Ogrodu_Botanicznego=" + ID_Ogrodu_Botanicznego +
                ", ID_Adresu=" + ID_Adresu +
                '}';
    }

    public int getID_Pracownika() {
        return ID_Pracownika;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public String getNumer_telefonu() {
        return numer_telefonu;
    }

    public String getNumer_konta() {
        return numer_konta;
    }

    public int getID_Ogrodu_Botanicznego() {
        return ID_Ogrodu_Botanicznego;
    }

    public int getID_Adresu() {
        return ID_Adresu;
    }

    public void setID_Pracownika(int ID_Pracownika) {
        this.ID_Pracownika = ID_Pracownika;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setNumer_telefonu(String numer_telefonu) {
        this.numer_telefonu = numer_telefonu;
    }

    public void setNumer_konta(String numer_konta) {
        this.numer_konta = numer_konta;
    }

    public void setID_Ogrodu_Botanicznego(int ID_Ogrodu_Botanicznego) {
        this.ID_Ogrodu_Botanicznego = ID_Ogrodu_Botanicznego;
    }

    public void setID_Adresu(int ID_Adresu) {
        this.ID_Adresu = ID_Adresu;
    }
}
