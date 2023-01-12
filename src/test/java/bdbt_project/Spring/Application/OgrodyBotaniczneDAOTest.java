package bdbt_project.Spring.Application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OgrodyBotaniczneDAOTest extends Object {

    private OgrodyBotaniczneDAO dao;

    @BeforeEach
    void testSetUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB14");
        datasource.setPassword("BDBTGRB14");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new OgrodyBotaniczneDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<OgrodyBotaniczne> listOgrodyBotaniczne = dao.list();

        assertFalse(listOgrodyBotaniczne.isEmpty());
    }

    @Test
    void save() {
        OgrodyBotaniczne ogrodyBotaniczne = new OgrodyBotaniczne(7,"morski","","567567567","morski@wp.pl",5);
        dao.save(ogrodyBotaniczne);
    }

    @Test
    void get() {
        int ID_Ogrodu_Botanicznego = 2;
        OgrodyBotaniczne ogrodyBotaniczne = dao.get(ID_Ogrodu_Botanicznego);
        assertNotNull(ogrodyBotaniczne);
    }

    @Test
    void update() {
        OgrodyBotaniczne ogrodyBotaniczne = new OgrodyBotaniczne();
        ogrodyBotaniczne.setID_Ogrodu_Botanicznego(34);
        ogrodyBotaniczne.setNazwa("tajemniczy");
        ogrodyBotaniczne.setData_zalozenia("");
        ogrodyBotaniczne.setNumer_telefonu("666666666");
        ogrodyBotaniczne.setAdres_email("tajemniczy@wp.pl");
        ogrodyBotaniczne.setID_Adresu(6);
    }

    @Test
    void delete() {
        int ID_Ogrodu_Botanicznego = 2;
        dao.delete(ID_Ogrodu_Botanicznego);
    }
}