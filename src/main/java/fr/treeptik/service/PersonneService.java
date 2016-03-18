package fr.treeptik.service;

import java.util.List;

import fr.treeptik.exception.ServiceException;

import fr.treeptik.model.Personne;

public interface PersonneService {

	Personne findById(Integer id) throws ServiceException;

	Personne save(Personne personne) throws ServiceException;

	void remove(Integer id) throws ServiceException;

	List<Personne> findAll() throws ServiceException;

	Personne findByName(String personneNom) throws ServiceException;


	
	
}
