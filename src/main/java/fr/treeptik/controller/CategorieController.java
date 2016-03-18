package fr.treeptik.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Categorie;
import fr.treeptik.service.CategorieService;
import fr.treeptik.validator.CategorieValidator;

@Controller
@RequestMapping(value = "/categorie")
public class CategorieController {

	@Autowired
	private CategorieValidator categorieValidator;

	@Autowired
	private CategorieService categorieService;

	@RequestMapping(value = "/categorie.do", method = RequestMethod.GET)
	public ModelAndView initForm() {
		ModelAndView modelAndView = new ModelAndView("categorie");
		modelAndView.addObject("categorie", new Categorie());
		return modelAndView;
	}

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam("id") Integer id)
			throws ServiceException, DAOException {
		Categorie categorie = categorieService.findOne(id);
		ModelAndView modelAndView = new ModelAndView("categorie");
		modelAndView.addObject("categorie", categorie);
		return modelAndView;
	}

	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	public ModelAndView listCategorie(HttpServletRequest request)
			throws ServiceException {
		return new ModelAndView("list-categorie", "categories",
				categorieService.findAll());
	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") Integer id)
			throws ServiceException {
		categorieService.remove(id);
		return new ModelAndView("redirect:list.do");
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	public ModelAndView saveCategorie(@Valid Categorie categorie,
			BindingResult result) throws ServiceException {
		ModelAndView modelAndView = new ModelAndView("categorie");
		categorieValidator.validate(categorie, result);

		if (result.hasErrors()) {
			modelAndView.addObject("categorie", categorie);
			return modelAndView;
		}
		categorie = categorieService.save(categorie);
		modelAndView = new ModelAndView("redirect:list.do");
		return modelAndView;
	}
}
