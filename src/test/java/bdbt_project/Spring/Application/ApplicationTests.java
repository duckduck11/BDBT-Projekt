package bdbt_project.Spring.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private PracownicyDAO pracownicyDAO;

	@Test
	void contextLoads() {
		List<Pracownicy> pracownicyList = pracownicyDAO.list();
		System.out.println(pracownicyList.get(0));
		assertFalse(pracownicyList.isEmpty());
	}

	@Test
	void save() {
		Pracownicy pracownicy = new Pracownicy(6,"Tomek","Norgia","M","123.1231","23423","234234","eewrer",4,3);
		pracownicyDAO.save(pracownicy);
	}



}
