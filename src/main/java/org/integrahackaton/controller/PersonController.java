package org.integrahackaton.controller;

import org.integrahackaton.dao.PersonDAO;
import org.integrahackaton.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonDAO dao;

    @RequestMapping("/form")
    public ModelAndView form(Person person) {
        ModelAndView modelAndView = new ModelAndView("person/form");
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Person> personList = dao.listar();
        ModelAndView modelAndView = new ModelAndView("person/list");
        modelAndView.addObject("person", personList);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView grava(@Valid Person person, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return form(person);
        }
        dao.gravar(person);
        redirectAttributes.addFlashAttribute("sucesso", "Cadastrado");
        return new ModelAndView("redirect:/person");

    }

    @RequestMapping("/detalheById/{id}")
    public ModelAndView detalhe(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("person/find");
        Person person = dao.findById(id);
        modelAndView.addObject("person", person);
        return modelAndView;
    }

    @RequestMapping("/detalheByDoc/{doc}")
    public ModelAndView detalhe(@PathVariable String doc) {
        ModelAndView modelAndView = new ModelAndView("person/find");
        List<Person> personList = dao.findByDoc(doc);
        modelAndView.addObject("person", personList);
        return modelAndView;
    }
}
