package fr.treeptik.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Categorie;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDAO categorieDAO;

	@Override
	public Categorie findOne(Integer id) throws ServiceException {
		try {
			return categorieDAO.findOne(id);
		} catch (DAOException e) {
			throw new ServiceException("Erreur find categorie", e);
		}
	}

	@Transactional
	@Override
	public Categorie save(Categorie categorie) throws ServiceException {
		try {
			return categorieDAO.save(categorie);
		} catch (DAOException e) {
			throw new ServiceException("Erreur save categorie", e);
		}
	}

	@Transactional
	@Override
	public void remove(Integer id) throws ServiceException {
		try {
			Categorie categorie = categorieDAO.findOne(id);
			categorieDAO.delete(categorie);
		} catch (DAOException e) {
			throw new ServiceException("Erreur delete categorie", e);
		}

	}

	@Override
	public List<Categorie> findAll() throws ServiceException {
		try {
			return categorieDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Erreur save categorie", e);
		}
	}
}
