package fr.treeptik.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.exception.DAOException;

import fr.treeptik.model.Personne;

@Component
public class PersonneValidator implements Validator {

	@Autowired
	private PersonneDAO personneDAO;

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.getClass().equals(Personne.class);
	}

	@Override
	public void validate(Object personne, Errors errors) {

		Personne p = (Personne) personne;

		if (p.getNom() == null) {
			errors.rejectValue("nom","hack","Le nom est nul");
		}

		Integer id = p.getId();
		if (id != null) {

			try {
				Long countByNameAndId = personneDAO.countByNameAndId(p.getNom(),
						id);

				if (countByNameAndId != 0) {
					errors.rejectValue("nom","hack", "Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				Long countByName = personneDAO.countByName(p.getNom());

				if (countByName!= 0) {
					errors.rejectValue("nom", "hack","Le nom est déjà pris");
				}

			} catch (DAOException e) {
				e.printStackTrace();
			}
		}
	}

}
