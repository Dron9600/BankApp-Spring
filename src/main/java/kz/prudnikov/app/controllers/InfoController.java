package kz.prudnikov.app.controllers;

import kz.prudnikov.app.dao.InformationDAO;
import kz.prudnikov.app.entity.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class InfoController {
    private InformationDAO informationDAO;



    @Autowired
    public InfoController(InformationDAO informationDAO) {
        this.informationDAO = informationDAO;
    }

    @GetMapping("/")
    public String index() {
        return "welcome_page";
    }


    @GetMapping("/show_info")
    public String show(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = ((UserDetails) principal).getUsername();
        int idN= informationDAO.findByCustomerName(name);
        model.addAttribute("info", informationDAO.showInfo(idN));
        return "show_info";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("information", new Information());
        return "create_new_customer";
    }

    @PostMapping("/createInfo")
    public String create(@ModelAttribute Information information){
        informationDAO.lastValue();
        informationDAO.saveInfo(information);
        return "redirect:/";
    }





}
