package bdbt_project.Spring.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
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

    private OgrodyDAO ogrodyDAO;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/new_form").setViewName("new_form");
        registry.addViewController("/ogrody_botaniczne").setViewName("ogrody_botaniczne");
        registry.addViewController("/edit_ogrody_botaniczne").setViewName("edit_ogrody_botaniczne");
        registry.addViewController("/new_ogrody_botaniczne").setViewName("new_ogrody_botaniczne");
        registry.addViewController("/ogrody").setViewName("ogrody");
        registry.addViewController("/edit_ogrody").setViewName("edit_ogrody");
        registry.addViewController("/new_ogrody").setViewName("new_ogrody");
    }

    @RequestMapping(value = {"/ogrody"})
    public String showOgrody(Model model) {
        List<Ogrody> listOgrody = ogrodyDAO.list();
        model.addAttribute("ogrodyList", listOgrody);
        return "ogrody";
    }
    @RequestMapping(value = {"/edit_ogrody/{ID_Ogrodu}"})
    public ModelAndView showEditOgrodyForm(@PathVariable(name = "ID_Ogrodu") int ID_Ogrodu) {
        ModelAndView mav = new ModelAndView("edit_ogrody");
        Ogrody ogrody = ogrodyDAO.get(ID_Ogrodu);
        mav.addObject("ogord", ogrody);
        return mav;
    }
    @RequestMapping(value = {"/update_ogrody"}, method = RequestMethod.POST)
    public String update(@ModelAttribute("ogord") Ogrody ogrod) {
        ogrodyDAO.update(ogrod);
        return "redirect:/ogrody";
    }
    @RequestMapping(value = {"/delete_ogrody/{ID_Ogrodu}"})
    public String deleteOgrodyForm(@PathVariable(name = "ID_Ogrodu") int ID_Ogrodu) {
        ogrodyDAO.delete(ID_Ogrodu);
        return "redirect:/ogrody";
    }
    @RequestMapping(value = {"/new_ogrody"})
    public String newOgrody(Model model) {
        Ogrody ogrod = new Ogrody();
        model.addAttribute("ogrod", ogrod);
        return "new_ogrody";
    }
    @RequestMapping(value = {"/save_ogrody"}, method = RequestMethod.POST)
    public String saveOgrody(@ModelAttribute("ogrod") Ogrody ogrod) {
        ogrodyDAO.save(ogrod);
        return "redirect:/ogrody";
    }

    //============================================================================================================================================================================

    @RequestMapping(value = {"/ogrody_botaniczne"})
    public String showOgrodyBotaniczne(Model model) {
        List<OgrodyBotaniczne> ogrodyBotaniczneList = ogrodyBotaniczneDAO.list();
        model.addAttribute("ogrodyBotaniczneList", ogrodyBotaniczneList);
        return "ogrody_botaniczne";
    }
    @RequestMapping(value = {"/edit_ogrody_botaniczne/{id_ogrodu_botanicznego}"})
    public ModelAndView showEditOgrodyBotaniczneForm(@PathVariable(name = "id_ogrodu_botanicznego") int id_ogrodu_botanicznego) {
        ModelAndView mav = new ModelAndView("edit_ogrody_botaniczne");
        OgrodyBotaniczne ogrodyBotaniczne = ogrodyBotaniczneDAO.get(id_ogrodu_botanicznego);
        mav.addObject("ogord_botaniczny", ogrodyBotaniczne);
        return mav;
    }
    @RequestMapping(value = {"/update_ogrody_botaniczne"}, method = RequestMethod.POST)
    public String update(@ModelAttribute("ogord_botaniczny") OgrodyBotaniczne ogrod_botaniczny) {
        ogrodyBotaniczneDAO.update(ogrod_botaniczny);
        return "redirect:/ogrody_botaniczne";
    }
    @RequestMapping(value = {"/delete_ogrody_botaniczne/{id_ogrodu_botanicznego}"})
    public String deleteOgrodyBotaniczneForm(@PathVariable(name = "id_ogrodu_botanicznego") int id_ogrodu_botanicznego) {
        ogrodyBotaniczneDAO.delete(id_ogrodu_botanicznego);
        return "redirect:/ogrody_botaniczne";
    }
    @RequestMapping(value = {"/new_ogrody_botaniczne"})
    public String newOgrodyBotanicznye(Model model) {
        OgrodyBotaniczne ogrod_botaniczny = new OgrodyBotaniczne();
        model.addAttribute("ogrod_botaniczny", ogrod_botaniczny);
        return "new_ogrody_botaniczne";
    }
    @RequestMapping(value = {"/save_ogrody_botaniczne"}, method = RequestMethod.POST)
    public String saveOgrodyBotaniczne(@ModelAttribute("ogrod_botaniczny") OgrodyBotaniczne ogrod_botaniczny) {
        ogrodyBotaniczneDAO.save(ogrod_botaniczny);
        return "redirect:/ogrody_botaniczne";
    }


    //==============================================================================================================================================================================




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
