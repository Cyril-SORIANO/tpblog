package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Personne;


@Repository
public class PersonneJPADAO implements PersonneDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Personne save(Personne personne) throws DAOException {
		try {
			if (personne.getId() != null) {
				entityManager.merge(personne);
			} else {
				entityManager.persist(personne);
			}
		} catch (PersistenceException e) {
			throw new DAOException("erreur save personne", e);
		}
		return personne;
	}

	@Override
	public Personne findOne(Integer id) throws DAOException {
		Personne personne;
		try {
			personne = entityManager.find(Personne.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save personne", e);
		}
		return personne;
	}

	@Override
	public void delete(Personne personne) throws DAOException {
		try {
			entityManager.remove(personne);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save personne", e);
		}

	}

	@Override
	public List<Personne> findAll() throws DAOException {
		try {
			return entityManager.createQuery("select p from Personne p",
					Personne.class).getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur save personne", e);
		}

	}

	@Override
	public Personne findByName(String personneNom) throws DAOException {
		try {
			return entityManager
					.createQuery("select p from Personne p WHERE p.nom LIKE ?1",
							Personne.class).setParameter(1, personneNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName personne", e);
		}
	}

	@Override
	public Long countByName(String personneNom) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(p) from Personne p WHERE p.nom LIKE ?1",
							Long.class).setParameter(1, personneNom)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName personne", e);
		}

	}
	
	@Override
	public Long countByNameAndId(String personneNom, Integer id) throws DAOException {
		try {
			return entityManager
					.createQuery(
							"select count(p) from Personne p WHERE p.nom LIKE ?1 and p.id<> ?2",
							Long.class).setParameter(1, personneNom).setParameter(2, id)
					.getSingleResult();
		} catch (PersistenceException e) {
			throw new DAOException("erreur findByName personne", e);
		}

	}
}
