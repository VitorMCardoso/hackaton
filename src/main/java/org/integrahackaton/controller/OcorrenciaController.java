package org.integrahackaton.controller;

import org.integrahackaton.dao.ImovelDAO;
import org.integrahackaton.dao.OcorrenciaDAO;
import org.integrahackaton.dao.PersonDAO;
import org.integrahackaton.model.Imovel;
import org.integrahackaton.model.Ocorrencia;
import org.integrahackaton.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaDAO dao;

    @Autowired
    private ImovelDAO daoImovel;

    @Autowired
    private PersonDAO daoPerson;

    @RequestMapping("/form")
    public ModelAndView form(Ocorrencia ocorrencia) {
        ModelAndView modelAndView = new ModelAndView("ocorrencia/form");
        return modelAndView;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Calendar.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        List<Ocorrencia> ocorrenciaList = dao.listar();
        ModelAndView modelAndView = new ModelAndView("ocorrencia/list");
        modelAndView.addObject("ocorrencia", ocorrenciaList);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView grava(@Valid Ocorrencia ocorrencia,
                              BindingResult result,
                              RedirectAttributes redirectAttributes,
                              @ModelAttribute("personName") String personName,
                              @ModelAttribute("imovelName") String imovelName) {

        List<Imovel> imovelList = daoImovel.findByLog(imovelName);
        List<Person> personList = daoPerson.findByDoc(personName);

        if (!imovelList.isEmpty() && !personList.isEmpty()) {
            ocorrencia.setPersonName(personList.get(0));
            ocorrencia.setImovelName(imovelList.get(0));
        }

        /*if (result.hasErrors()) {
            return form(ocorrencia);
        }*/
        dao.gravar(ocorrencia);
        redirectAttributes.addFlashAttribute("sucesso", "Cadastrado");
        return new ModelAndView("redirect:/ocorrencia");

    }

    @RequestMapping("/detalheById/{id}")
    public ModelAndView detalhe(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("ocorrencia/find");
        Ocorrencia ocorrencia = dao.findById(id);
        modelAndView.addObject("ocorrencia", ocorrencia);
        return modelAndView;
    }

    /*@RequestMapping("/detalheByLog/{log}")
    public ModelAndView detalhe(@PathVariable String log) {
        ModelAndView modelAndView = new ModelAndView("imovel/find");
        List<Imovel> imovelList = dao.findByLog(log);
        modelAndView.addObject("imovel", imovelList);
        return modelAndView;
    }*/
}
