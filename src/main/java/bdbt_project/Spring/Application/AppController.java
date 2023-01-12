package bdbt_project.Spring.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private PracownicyDAO pracownicyDAO;

    @Autowired
    private OgrodyBotaniczneDAO ogrodyBotaniczneDAO;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/new_form").setViewName("new_form");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            } else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }

        @RequestMapping(value = {"/main_admin"})
        public String showAdminPage(Model model) {
            List<Pracownicy> pracownicyList = pracownicyDAO.list();
            model.addAttribute("pracownicyList", pracownicyList);
            return "admin/main_admin";
        }

        @RequestMapping(value = {"index"})
        public String dupa(Model model) {
            List<Pracownicy> pracownicyList = pracownicyDAO.list();
            model.addAttribute("pracownicylist", pracownicyList);
            return "index";
        }

        @RequestMapping(value = {"/new"})
        public String showNewForm(Model model) {
            Pracownicy pracownicy = new Pracownicy();
            model.addAttribute("pracownicy", pracownicy);
            return "new_form";
        }

        @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
        public String save(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            pracownicyDAO.save(pracownicy);

            return "redirect:/";
        }


        @RequestMapping(value = {"/main_user"})
        public String showUserPage(Model model) {
            return "user/main_user";
        }
    }
}
