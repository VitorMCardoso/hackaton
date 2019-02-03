package org.integrahackaton.controller;

import org.integrahackaton.dao.ImovelDAO;
import org.integrahackaton.dao.PersonDAO;
import org.integrahackaton.dao.UserDAO;
import org.integrahackaton.dto.BuscaRetorno;
import org.integrahackaton.model.Imovel;
import org.integrahackaton.model.Person;
import org.integrahackaton.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/busca")
public class BuscaController {

    @Autowired
    private PersonDAO pessoaDao;
    private ImovelDAO imovelDao;

    @RequestMapping("/")
    public ModelAndView form(HttpServletRequest request) {
        String busca = null;
        if (request.getAttribute("busca") != null) {
            busca = request.getAttribute("busca").toString();
        }

        List<BuscaRetorno> retorno = new ArrayList<BuscaRetorno>();

        if (busca != null) {
            List<Person> personList = pessoaDao.findByNome(busca);
            List<Imovel> imoveisList = imovelDao.findByLog(busca);

            for(Person pessoa : personList) {
                BuscaRetorno r = new BuscaRetorno();

                r.setId(pessoa.getId());
                r.setTitulo(pessoa.getNome());
                r.setTipo("responsavel");

                retorno.add(r);
            }

            for(Imovel imovel : imoveisList) {
                BuscaRetorno r = new BuscaRetorno();

                r.setId(imovel.getId());
                r.setTitulo(imovel.getLogradouro());
                r.setTipo("endereco");

                retorno.add(r);
            }
        }

        ModelAndView modelAndView = new ModelAndView("busca/busca");
        modelAndView.addObject("retorno", retorno);
        return modelAndView;
    }
}
