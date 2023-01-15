package bdbt_project.Spring.Application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.DriverManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OgrodyDAOTest extends Object {

    private OgrodyDAO dao;

    @BeforeEach
    void testSetUp() throws Exception{
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setUrl("jdbc:oracle:thin:@194.29.170.4:1521:xe");
        datasource.setUsername("BDBTGRB14");
        datasource.setPassword("BDBTGRB14");
        datasource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new OgrodyDAO(new JdbcTemplate(datasource));
    }

    @Test
    void list() {
        List<Ogrody> listOgrody = dao.list();

        assertFalse(listOgrody.isEmpty());
    }

    @Test
    void save() {
        Ogrody ogrody = new Ogrody(7,"morski","bardzo fajny",1,2);
        dao.save(ogrody);
    }

    @Test
    void get() {
        int ID_Ogrodu = 2;
        Ogrody ogrody = dao.get(ID_Ogrodu);
        assertNotNull(ogrody);
    }

    @Test
    void update() {
        Ogrody ogrody = new Ogrody();
        ogrody.setID_Ogrodu(34);
        ogrody.setNazwa("tajemniczy");
        ogrody.setOpis("mega");
        ogrody.setID_Ogrodu_Botanicznego(2);
        ogrody.setID_Strefy_Klimatycznej(2);
    }

    @Test
    void delete() {
        int ID_Ogrodu = 2;
        dao.delete(ID_Ogrodu);
    }
}