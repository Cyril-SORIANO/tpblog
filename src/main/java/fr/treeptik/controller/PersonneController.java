package fr.treeptik.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.dao.RoleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Personne;
import fr.treeptik.model.Role;
import fr.treeptik.service.PersonneService;
import fr.treeptik.validator.PersonneValidator;

@Controller
@RequestMapping(value = "/personne")
public class PersonneController {

	private final static Logger LOGGER = Logger
			.getLogger(PersonneController.class);

	@Autowired
	private PersonneValidator personneValidator;

	@Autowired
	private PersonneService personneService;

	@Autowired
	private RoleDAO roleDAO;

	@RequestMapping(value = "/personne.do", method = RequestMethod.GET)
	public ModelAndView initForm() throws DAOException {

		List<Role> roles = roleDAO.findAll();

		ModelAndView modelAndView = new ModelAndView("personne");
		modelAndView.addObject( "personne",new Personne());
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {

		Personne personne = personneService.findById(id);
//		ModelAndView modelAndView = new ModelAndView("client", "client", client);
		//équivalent de la ligne du dessus:
		ModelAndView modelAndView = new ModelAndView("personne");
		modelAndView.addObject("personne", personne);
		//fin de l'équivalence
		List<Role> roles = roleDAO.findAll();
		modelAndView.addObject("roles", roles);
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listPersonne(HttpServletRequest request)
			throws ServiceException {
		String personneNom = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		if (request.getSession().getAttribute("userSessionId") == null) {
			Personne personne = personneService.findByName(personneNom);
			request.getSession().setAttribute("userSessionId", personne.getId());
		}
		return new ModelAndView("list-personne", "personnes",
				personneService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		personneService.remove(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView savePersonne(@Valid Personne personne, BindingResult result)
			throws ServiceException, DAOException {
		ModelAndView modelAndView = new ModelAndView("personne");

		 personneValidator.validate(personne, result);

		if (result.hasErrors()) {
			 for (ObjectError objectError : result.getAllErrors()) {
			 LOGGER.info(objectError.getDefaultMessage());
			 }

//			client = new Client();
personne.setNom(null);
personne.setPassword(null);
			
			List<Role> roles = roleDAO.findAll();
			modelAndView.addObject("personne",personne);
			modelAndView.addObject("roles", roles);
			return modelAndView;
		}
		personne = personneService.save(personne);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;
	}

}
