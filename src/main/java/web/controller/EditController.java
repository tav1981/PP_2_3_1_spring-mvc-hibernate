package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

@Controller
public class EditController {

    private UserService userService;

    @Autowired
    public EditController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/edit")
    public String printWelcome(ModelMap model,
                               @RequestParam(value = "edit", required = false, defaultValue = "0") Long editId,
                               @RequestParam(value = "newPole", required = false, defaultValue = "0") int newPole) {


        User user = userService.getForId(editId);

        model.addAttribute("user", user);
        System.out.println("Id пользователя для редактирования = " + editId);

        if (newPole == 1) {
            return "add";
        }
        return "edit";
    }

}