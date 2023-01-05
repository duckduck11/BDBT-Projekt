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

}
