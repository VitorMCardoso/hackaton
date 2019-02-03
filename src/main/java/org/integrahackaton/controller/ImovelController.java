package org.integrahackaton.controller;

import org.integrahackaton.dao.ImovelDAO;
import org.integrahackaton.model.Imovel;
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
@RequestMapping("/imovel")
public class ImovelController {

    @Autowired
    private ImovelDAO dao;

    @RequestMapping("/form")
    public ModelAndView form(Imovel imovel) {
        ModelAndView modelAndView = new ModelAndView("imovel/form");
        return modelAndView;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Imovel> imovelList = dao.listar();
        ModelAndView modelAndView = new ModelAndView("imovel/list");
        modelAndView.addObject("imovel", imovelList);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView grava(@Valid Imovel imovel, BindingResult result, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return form(imovel);
        }
        dao.gravar(imovel);
        redirectAttributes.addFlashAttribute("sucesso", "Cadastrado");
        return new ModelAndView("redirect:/imovel");

    }

    @RequestMapping("/detalheById/{id}")
    public ModelAndView detalhe(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("imovel/find");
        Imovel imovel = dao.findById(id);
        modelAndView.addObject("imovel", imovel);
        return modelAndView;
    }

    @RequestMapping("/detalheByLog/{log}")
    public ModelAndView detalhe(@PathVariable String log) {
        ModelAndView modelAndView = new ModelAndView("imovel/find");
        List<Imovel> imovelList = dao.findByLog(log);
        modelAndView.addObject("imovel", imovelList);
        return modelAndView;
    }
}
