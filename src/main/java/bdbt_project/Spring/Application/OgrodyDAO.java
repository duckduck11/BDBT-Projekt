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
public class OgrodyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public OgrodyDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public OgrodyDAO() {
    }

    public List<Ogrody> list(){
        String sql = "SELECT * FROM OGRODY";
        List<Ogrody> listOgrody = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ogrody.class));
        return listOgrody;
    }

    public void save(Ogrody ogrody){
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("Ogrody").usingColumns("ID_Ogrodu", "nazwa","opis", "ID_Ogrodu_Botanicznego", "ID_Strefy_Klimatycznej");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ogrody);
        insertActor.execute(param);
    }

    public Ogrody get(int ID_Ogrodu){
        Object[] args = {ID_Ogrodu};
        String sql = "SELECT * FROM OGRODY WHERE ID_Ogrodu=" + args[0];
        Ogrody ogrody = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Ogrody.class));
        return ogrody;
    }

    public void update(Ogrody ogrody){
        String sql = "Update ogrody SET nazwa=:nazwa, opis=:opis, ID_Ogrodu_Botanicznego=:ID_Ogrodu_Botanicznego, ID_Strefy_Klimatycznej=:ID_Strefy_Klimatycznej where ID_Ogrodu=:ID_Ogrodu";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(ogrody);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(int ID_Ogrodu){
        String sql = "Delete from ogrody where ID_Ogrodu = ?";
        jdbcTemplate.update(sql,ID_Ogrodu);
    }
}
