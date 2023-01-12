package bdbt_project.Spring.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


@Repository
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public  PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public PracownicyDAO(){

    }

    public List<Pracownicy> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownicy> pracownicyList = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicyList;
    }

    public void save(Pracownicy pracownicy) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pracownicy").usingColumns("id_pracownika","imie","nazwisko","plec","data_urodzenia","pesel","numer_telefonu","numer_konta","id_ogrodu_botanicznego","id_adresu");

        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        insertActor.execute(param);
    }

    public Pracownicy get(int id) {
        return null;
    }

    public void update(Pracownicy pracownicy) {
    }


    public void delete(int id) {
    }



}
