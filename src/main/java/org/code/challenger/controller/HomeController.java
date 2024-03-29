package org.code.challenger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping
    public ModelAndView home() {
        return new ModelAndView("redirect:app/index.html");
    }

    @GetMapping("/app/task")
    public ModelAndView task() {
        return new ModelAndView("forward:index.html");
    }

    @GetMapping("/app/top-users")
    public ModelAndView topUsers() {
        return new ModelAndView("forward:index.html");
    }
}
