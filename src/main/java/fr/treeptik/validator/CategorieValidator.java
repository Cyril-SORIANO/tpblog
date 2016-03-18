package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;

@Component
public class CategorieValidator implements Validator {

	@Autowired
	private CategorieDAO categorieDAO;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Categorie.class);
	}

	@Override
	public void validate(Object categorie, Errors errors) {

		Categorie c = (Categorie) categorie;

		if (c.getName() == null) {
			errors.rejectValue("nom", "hack", "Le nom est nul");
		}

		Integer id = c.getId();
		if (id != null) {

			try {
				Long countByNameAndId = categorieDAO.countByNameAndId(
						c.getName(), id);
				if (countByNameAndId != 0) {
					errors.rejectValue("nom", "hack", "Le nom est déjà pris");
				}
			} catch (DAOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				Long countByName = categorieDAO.countByName(c.getName());
				if (countByName != 0) {
					errors.rejectValue("nom", "hack", "Le nom est déjà pris");
				}
			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

}
