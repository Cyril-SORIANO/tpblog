package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.RoleDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Role;

@Repository
public class RoleJPADAO implements RoleDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Role save(Role role) throws DAOException {
		try {
			if (role.getId() != null) {
				entityManager.merge(role);
			} else {
				entityManager.persist(role);
			}
		} catch (PersistenceException e) {
			throw new DAOException("erreur save role", e);
		}
		return role;
	}

	@Override
	public Role findOne(Integer id) throws DAOException {
		Role role;
		try {
			role = entityManager.find(Role.class, id);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save role", e);
		}
		return role;
	}

	@Override
	public void delete(Role role) throws DAOException {
		try {
			entityManager.remove(role);
		} catch (PersistenceException e) {
			throw new DAOException("erreur save role", e);
		}

	}

	@Override
	public List<Role> findAll() throws DAOException {
		try {
			return entityManager
					.createQuery("select r from Role r", Role.class)
					.getResultList();
		} catch (PersistenceException e) {
			throw new DAOException("erreur save role", e);
		}

	}
}
