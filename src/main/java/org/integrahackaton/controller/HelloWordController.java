package org.integrahackaton.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWordController {

    @RequestMapping("/hello")
    public @ResponseBody
    ModelAndView hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        ModelAndView modelAndView = new ModelAndView("/hello");
        modelAndView.addObject("name", name);
        return modelAndView;
        //model.addAttribute("name", name);
        //return "hello";
    }
}
