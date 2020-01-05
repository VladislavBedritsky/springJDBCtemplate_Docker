package com.htp.ex.controller;

import com.htp.ex.model.User;
import com.htp.ex.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ServiceProvider serviceProvider;

    @GetMapping
    public String getUsers (Model model) {

        model.addAttribute("users",serviceProvider.getUserService().findAll());

        return "users";
    }

    @PostMapping
    public String saveUser (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam Integer age
    ) {

        User user = new User(name,email,age);
        serviceProvider.getUserService().save(user);

        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id,
                          Model model) {
        model.addAttribute("user",serviceProvider.getUserService().getById(id));
        return "user";
    }

    @PostMapping("/{id}")
    public String updateById(
            @ModelAttribute("user") User user
    ) {

        serviceProvider.getUserService().update(user);

        return "redirect:/users/"+user.getId();

    }

    @GetMapping("/delete/{id}")
    public String deleteById(
            @PathVariable Integer id
    ) {

        serviceProvider.getUserService().delete(id);
        return "redirect:/users";
    }

}
