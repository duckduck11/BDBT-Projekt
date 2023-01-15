package bdbt_project.Spring.Application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PracownicyDAOTest extends Object {

    private PracownicyDAO dao;

    @BeforeEach
    void testSetUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB14");
        datasource.setPassword("BDBTGRB14");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new PracownicyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Pracownicy> listPracownicy = dao.list();

        assertFalse(listPracownicy.isEmpty());
    }

    @Test
    void save() {
        Pracownicy pracownicy = new Pracownicy(2,"Maciej","Kowalski","M","","123345567","111111111","",2,2);
        dao.save(pracownicy);
    }

    @Test
    void get() {
        int ID_Pracownika = 2;
        Pracownicy pracownicy = dao.get(ID_Pracownika);
        assertNotNull(pracownicy);
    }

    @Test
    void update() {
        Pracownicy pracownicy = new Pracownicy();
        pracownicy.setID_Pracownika(34);
        pracownicy.setImie("Jaś");
        pracownicy.setNazwisko("Mega");
        pracownicy.setID_Ogrodu_Botanicznego(2);
        pracownicy.setID_Adresu(2);
        pracownicy.setPlec("M");
        pracownicy.setPesel("21434573");
        pracownicy.setData_urodzenia("");
        pracownicy.setNumer_telefonu("456456456");
        pracownicy.setNumer_konta("21434573");
    }

    @Test
    void delete() {
        int ID_Pracownika = 2;
        dao.delete(ID_Pracownika);
    }
}