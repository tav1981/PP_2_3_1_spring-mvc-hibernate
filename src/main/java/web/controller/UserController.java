package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Transactional(readOnly = false)
    @GetMapping()
    public String printUsers(ModelMap model,
                            @RequestParam(value = "count", required = false, defaultValue = "0") byte count,
                            @RequestParam(value = "firstName", required = false, defaultValue = "") String firstName,
                            @RequestParam(value = "lastName", required = false, defaultValue = "") String lastName,
                            @RequestParam(value = "email", required = false, defaultValue = "") String email,
                            @RequestParam(value = "id", required = false, defaultValue = "0") Long id,
                            @RequestParam(value = "delete", required = false, defaultValue = "0") Long deleteId) {

        //создаем 5 пользователей если нет ни одного
       /* if (userService.listUsers((byte) 1).isEmpty()) {
            userService.add(new User("name1", "last1", "1@dd.w"));
            userService.add(new User("name2", "last2", "2@dd.w"));
            userService.add(new User("name3", "last3", "3@dd.w"));
            userService.add(new User("name4", "last4", "4@dd.w"));
            userService.add(new User("name5", "last5", "5@dd.w"));
        }*/

        //удаляем пользователя по Id
        if (deleteId != 0) {
            userService.dell(deleteId);
            System.out.println("Удалить пользователя с Id = " + deleteId);
        }

        //редактируем или добавляем пользователя
        if (!firstName.isEmpty()) {
            userService.edit(id, new User(firstName, lastName, email));
        }

        List<User> users = userService.listUsers(count);
        model.addAttribute("users", users);

        return "users";
    }
}
