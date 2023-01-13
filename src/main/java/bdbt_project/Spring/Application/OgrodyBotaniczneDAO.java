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
public class OgrodyBotaniczneDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OgrodyBotaniczneDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
    public OgrodyBotaniczneDAO() {
    }


    public List<OgrodyBotaniczne> list(){
        String sql = "SELECT * FROM OGRODY_BOTANICZNE";
        List<OgrodyBotaniczne> listOgrodyBotaniczne = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(OgrodyBotaniczne.class));
        return listOgrodyBotaniczne;
    }

    public void save(OgrodyBotaniczne ogrodyBotaniczne){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Ogrody_Botaniczne").usingColumns("ID_Ogrodu_Botanicznego", "nazwa","data_zalozenia", "numer_telefonu", "adres_email", "ID_Adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ogrodyBotaniczne);
        insertActor.execute(param);
    }

    public OgrodyBotaniczne get(int ID_Ogrodu_Botanicznego){
        Object[] args = {ID_Ogrodu_Botanicznego};
        String sql = "SELECT * FROM OGRODY_BOTANICZNE WHERE id_ogrodu_botanicznego=" + args[0];
        OgrodyBotaniczne ogrodyBotaniczne = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(OgrodyBotaniczne.class));
        return ogrodyBotaniczne;
    }

    public void update(OgrodyBotaniczne ogrodyBotaniczne){
        String sql = "Update ogrody_botaniczne SET nazwa=:nazwa, data_zalozenia=TO_DATE(:data_zalozenia, 'YYYY/MM/DD HH:MI:SS'), numer_telefonu=:numer_telefonu, adres_email=:adres_email, id_adresu=:ID_Adresu where id_ogrodu_botanicznego=:ID_Ogrodu_Botanicznego";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ogrodyBotaniczne);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);

    }

    public void delete(int ID_Ogrodu_Botanicznego){
        String sql = "Delete from ogrody_botaniczne where id_ogrodu_botanicznego = ?";
        jdbcTemplate.update(sql,ID_Ogrodu_Botanicznego);
    }
}
