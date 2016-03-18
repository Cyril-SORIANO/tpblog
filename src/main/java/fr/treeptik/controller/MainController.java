package fr.treeptik.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.dao.RoleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Personne;
import fr.treeptik.model.Role;
import fr.treeptik.service.PersonneService;
import fr.treeptik.validator.PersonneValidator;

@Controller
public class MainController {

	@Autowired
	private PersonneValidator personneValidator;

	@Autowired
	private PersonneService personneService;

	@Autowired
	private RoleDAO roleDAO;
	

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@RequestMapping(value = "/menu.do", method = RequestMethod.GET)
	public ModelAndView menu() {
		ModelAndView modelAndView = new ModelAndView("menu");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register.do", method = RequestMethod.GET)
	public ModelAndView showPersonne() throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("register");
		Personne personne = new Personne();
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("personne", personne);
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView savePersonne(@Valid Personne personne,
			BindingResult result) throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("register");
		personneValidator.validate(personne, result);
		personne = personneService.save(personne);
		modelAndView = new ModelAndView("redirect:login.do");
		modelAndView.addObject("message","success");
		return modelAndView;
	}
}
