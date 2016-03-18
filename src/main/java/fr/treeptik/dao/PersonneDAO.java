package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Personne;


public interface PersonneDAO {

	Personne save(Personne personne) throws DAOException;

	List<Personne> findAll() throws DAOException;

	void delete(Personne personne) throws DAOException;

	Personne findOne(Integer id) throws DAOException;

	Personne findByName(String personneNom) throws DAOException;

	Long countByName(String personneNom) throws DAOException;

	Long countByNameAndId(String personneNom, Integer id) throws DAOException;

}
