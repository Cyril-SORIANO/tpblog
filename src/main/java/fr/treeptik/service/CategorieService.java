package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Categorie;

public interface CategorieService {

	Categorie findOne(Integer id) throws ServiceException;
	
	Categorie save(Categorie categorie) throws ServiceException;
	
	void remove(Integer id) throws ServiceException;
	
	List<Categorie> findAll() throws ServiceException;
	
	
	
	
}
