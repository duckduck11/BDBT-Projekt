package bdbt_project.Spring.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
@Repository
public class PracownicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public PracownicyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public PracownicyDAO() {
    }

    public List<Pracownicy> list(){
        String sql = "SELECT * FROM PRACOWNICY";
        List<Pracownicy> listPracownicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return listPracownicy;
    }

//    public void save(Pracownicy pracownicy){
//        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
//        insertActor.withTableName("Pracownicy").usingColumns("ID_Pracownika", "imie", "nazwisko", "plec", "data_urodzenia", "pesel","numer_telefonu", "numer_konta", "ID_Ogrodu_Botanicznego", "ID_Adresu");
//        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
//        insertActor.execute(param);
//    }

    public void save(Pracownicy pracownicy){
        String sql = "INSERT INTO PRACOWNICY (ID_Pracownika, imie, nazwisko, plec, data_urodzenia, pesel, numer_telefonu, numer_konta, ID_Ogrodu_Botanicznego, ID_Adresu) VALUES (:ID_Pracownika, :imie, :nazwisko, :plec, TO_DATE(:data_urodzenia, 'YYYY/MM/DD HH:MI:SS'), :pesel, :numer_telefonu, :numer_konta, :ID_Ogrodu_Botanicznego, :ID_Adresu)";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public Pracownicy get(int ID_Pracownika){
        Object[] args = {ID_Pracownika};
        String sql = "SELECT * FROM PRACOWNICY WHERE ID_PRACOWNIKA=" + args[0];
        Pracownicy pracownicy = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Pracownicy.class));
        return pracownicy;
    }

    public void update(Pracownicy pracownicy){
        String sql = "Update PRACOWNICY SET imie=:imie, nazwisko=:nazwisko, plec=:plec, data_urodzenia=TO_DATE(:data_urodzenia, 'YYYY/MM/DD HH:MI:SS'), pesel=:pesel, numer_telefonu=:numer_telefonu, numer_konta=:numer_konta, ID_Ogrodu_Botanicznego=:ID_Ogrodu_Botanicznego, ID_Adresu=:ID_Adresu WHERE ID_Pracownika=:ID_Pracownika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pracownicy);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(int ID_Pracownika){
        String sql = "Delete from Pracownicy where ID_Pracownika = ?";
        jdbcTemplate.update(sql,ID_Pracownika);
    }
}