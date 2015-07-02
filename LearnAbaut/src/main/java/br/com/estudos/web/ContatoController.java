package br.com.estudos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.estudos.dao.ContatoDAO;
import br.com.estudos.model.Contato;

@Controller

@RequestMapping("/contato/**")

public class ContatoController {

	@Autowired

	private ContatoDAO contatoDao;

	@RequestMapping(value = "/contato/{id}", method = RequestMethod.GET)

	public String show(@PathVariable("id") Long id, ModelMap modelMap) {

		modelMap.addAttribute("contato", contatoDao.find(id));

		return "contato/show";

	}

	@RequestMapping(value = "/contato", method = RequestMethod.GET)

	public String list(ModelMap modelMap) {

		modelMap.addAttribute("contatos", contatoDao.findAll());

		return "contato/list";

	}

	@RequestMapping(value = "/contato/{id}", method = RequestMethod.DELETE)

	public String delete(@PathVariable("id") Long id) {

		contatoDao.remove(contatoDao.find(id));

		return "redirect:/contato";

	}

	@RequestMapping(value = "/contato/form", method = RequestMethod.GET)

	public String form(ModelMap modelMap) {

		modelMap.addAttribute("contato", new Contato());

		return "contato/create";

	}

	@RequestMapping(value = "/contato", method = RequestMethod.POST)

	public String create(@ModelAttribute("contato") Contato contato) {

		contatoDao.persist(contato);

		return "redirect:/contato";

	}

	@RequestMapping(value = "/contato/{id}/form", method = RequestMethod.GET)

	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) {

		modelMap.addAttribute("contato", contatoDao.find(id));

		return "contato/update";

	}

	@RequestMapping(method = RequestMethod.PUT)

	public String update(@ModelAttribute("contato") Contato contato) {

		contatoDao.merge(contato);

		return "redirect:/contato";

	}

}