package bdbt_project.Spring.Application;


public class Pracownicy {
    private int id;
    private String imie;
    private String nazwisko;
    private String plec;
    private String data_urodzenia;
    private String pesel;
    private String numer_telefonu;
    private String numer_konta;
    private int id_ogrodu_botanicznego;
    private int id_adresu;

    public Pracownicy(int id, String imie, String nazwisko, String plec, String data_urodzenia, String pesel, String numer_telefonu, String numer_konta, int id_ogrodu_botanicznego, int id_adresu) {
        super();
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.data_urodzenia = data_urodzenia;
        this.pesel = pesel;
        this.numer_telefonu = numer_telefonu;
        this.numer_konta = numer_konta;
        this.id_ogrodu_botanicznego = id_ogrodu_botanicznego;
        this.id_adresu = id_adresu;
    }

    public Pracownicy(){

    }


    @Override
    public String toString() {
        return "Pracownicy{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numer_telefonu='" + numer_telefonu + '\'' +
                ", numer_konta='" + numer_konta + '\'' +
                ", id_ogrodu_botanicznego=" + id_ogrodu_botanicznego +
                ", id_adresu=" + id_adresu +
                '}';
    }

    public int getId() {
        return id;
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

    public int getId_ogrodu_botanicznego() {
        return id_ogrodu_botanicznego;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setId_ogrodu_botanicznego(int id_ogrodu_botanicznego) {
        this.id_ogrodu_botanicznego = id_ogrodu_botanicznego;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }
}
