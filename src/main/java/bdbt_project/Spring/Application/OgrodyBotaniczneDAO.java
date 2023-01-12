package bdbt_project.Spring.Application;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
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
        String sql = "SELECT * FROM OGRODY_BOTANICZNE WHERE ID_OGRODU_BOTANICZNEGO = ?";
        Object[] args = {ID_Ogrodu_Botanicznego};
        OgrodyBotaniczne ogrodyBotaniczne = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(OgrodyBotaniczne.class));
        return ogrodyBotaniczne;
    }

    public void update(OgrodyBotaniczne ogrodyBotaniczne){

    }

    public void delete(int ID_Ogrodu){

    }
}
