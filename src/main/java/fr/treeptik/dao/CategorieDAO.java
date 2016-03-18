package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;

public interface CategorieDAO {
	
	Categorie save(Categorie categorie) throws DAOException;
	
	List<Categorie> findAll() throws DAOException;
	
	void delete(Categorie categorie) throws DAOException;
	
	Categorie findOne(Integer id) throws DAOException;

	Long countByName(String categorieNom) throws DAOException;

	Long countByNameAndId(String categorieNom, Integer id) throws DAOException;
}
