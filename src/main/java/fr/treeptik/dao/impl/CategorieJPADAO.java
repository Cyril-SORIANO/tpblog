package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.CategorieDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Categorie;

@Repository
public class CategorieJPADAO implements CategorieDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Categorie save(Categorie categorie) throws DAOException {
		try {
			if(categorie.getId()!= null){
				entityManager.merge(categorie);
			} else {
				entityManager.persist(categorie);
			}
		} catch (Exception e) {
			throw new DAOException("erreur save categorie", e);
		}
		return categorie;
	}

	@Override
	public List<Categorie> findAll() throws DAOException {
		try{
			return entityManager.createQuery("select c from Categorie c",Categorie.class).getResultList();
		}catch (PersistenceException e) {
			throw new DAOException("erreur save categorie", e);
		}
	}

	@Override
	public void delete(Categorie categorie) throws DAOException {
		try {
			entityManager.remove(categorie);
			
		} catch (PersistenceException e) {
			throw new DAOException("erreur save categorie", e);
		}
		
	}

	@Override
	public Categorie findOne(Integer id) throws DAOException {
		Categorie categorie;
		try {
			categorie=entityManager.find(Categorie.class, id);
		}  catch (PersistenceException e) {
			throw new DAOException("erreur save categorie", e);
		}
		return categorie;
	}

	@Override
	public Long countByName(String categorieNom) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(c) from Categorie c WHERE c.name LIKE ?1",
							Long.class).setParameter(1, categorieNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName personne", e);
		}
	}

	@Override
	public Long countByNameAndId(String categorieNom, Integer id)
			throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(c) from Categorie c WHERE c.name LIKE ?1 and c.id<> ?2",
							Long.class).setParameter(1, categorieNom).setParameter(2, id)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName personne", e);
		}

	}

}
