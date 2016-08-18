package ru.ionov.temptracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ionov.temptracker.sessionbeans.UsernameHolder;

@Controller
public class AuthController
{
    private static final String NAME_KEY = "name";

    @Autowired
    private UsernameHolder usernameHolder;

    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false) String name, Model model)
    {
        if (!StringUtils.isEmpty(name))
        {
            usernameHolder.setUsername(name);
        }
        model.addAttribute(NAME_KEY, usernameHolder.getUsername());

        return "index";
    }

    @RequestMapping("/logout")
    public String logout()
    {
        usernameHolder.setUsername(null);
        return "index";
    }
}