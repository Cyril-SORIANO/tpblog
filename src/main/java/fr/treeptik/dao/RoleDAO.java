package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Role;

public interface RoleDAO {

	Role save(Role role) throws DAOException;

	List<Role> findAll() throws DAOException;

	void delete(Role role) throws DAOException;

	Role findOne(Integer id) throws DAOException;

}
