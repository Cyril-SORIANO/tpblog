package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;

import fr.treeptik.model.Personne;

@Service
public class PersonneServiceImpl implements PersonneService {

	@Autowired
	private PersonneDAO personneDAO;

	@Override
	public Personne findById(Integer id) throws ServiceException {
		try {
			return personneDAO.findOne(id);

		} catch (DAOException e) {
			throw new ServiceException("Erreur find personne", e);
		}
	}

	@Transactional
	@Override
	public Personne save(Personne personne) throws ServiceException {
		try {
			return personneDAO.save(personne);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save personne", e);
		}
	}

	@Transactional
	@Override
	public void remove(Integer id) throws ServiceException {
		try {
			Personne personne = personneDAO.findOne(id);
			personneDAO.delete(personne);
		} catch (DAOException e) {
			throw new ServiceException("Erreur delete personne", e);

		}
	}

	@Override
	public List<Personne> findAll() throws ServiceException {
		try {
			return personneDAO.findAll();

		} catch (DAOException e) {
			throw new ServiceException("Erreur save personne", e);
		}
	}

	@Override
	public Personne findByName(String personneNom) throws ServiceException {
		try {
			return personneDAO.findByName(personneNom);

		} catch (DAOException e) {
			throw new ServiceException("Erreur save personne", e);
		}
	}
}
