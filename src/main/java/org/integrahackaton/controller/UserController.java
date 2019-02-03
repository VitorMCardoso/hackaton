package org.integrahackaton.controller;

import java.util.List;

import javax.validation.Valid;

import org.integrahackaton.dao.UserDAO;
import org.integrahackaton.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDAO dao;

    @RequestMapping("/form")
    public ModelAndView form(User produto) {
        ModelAndView modelAndView = new ModelAndView("user/form");
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<User> userList = dao.listar();
        ModelAndView modelAndView = new ModelAndView("user/list");
        modelAndView.addObject("user", userList);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView grava(@Valid User user, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return form(user);
        }
        dao.gravar(user);
        redirectAttributes.addFlashAttribute("sucesso", "Cadastrado");
        return new ModelAndView("redirect:/user");

    }

    @RequestMapping("/detalhe/{id}")
    public ModelAndView detalhe(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("user/find");
        User user = dao.find(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
