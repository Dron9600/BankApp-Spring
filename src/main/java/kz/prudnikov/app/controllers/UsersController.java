package kz.prudnikov.app.controllers;

//import kz.prudnikov.app.dao.EmployeeDAO;
//import kz.prudnikov.app.entity.Employee;
import kz.prudnikov.app.dao.UsersDAO;
import kz.prudnikov.app.entity.Information;
import kz.prudnikov.app.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UsersController {

    private final UsersDAO usersDAO;

    @Autowired
    public UsersController(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }


    @GetMapping("/new-user")
    public String newUser(Model model) {
        model.addAttribute("user", new Users());
        return "new_users";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("users") @Valid Users users){
        usersDAO.saveUsers(users);
        String name = users.getUsername();
        return "redirect:/new";
    }

    @GetMapping("/update-user")
    public String updateUser(Model model) {
        model.addAttribute("user", new Users());
        return "update/update_customer";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute Users users){
        return "redirect:/new";
    }


}
