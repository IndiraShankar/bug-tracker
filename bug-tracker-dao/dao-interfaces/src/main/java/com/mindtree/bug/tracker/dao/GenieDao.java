package com.mindtree.bug.tracker.dao;

import java.util.List;

import com.mindtree.bug.tracker.entity.Genie;
import com.mindtree.bug.tracker.entity.User;
import com.mindtree.bug.tracker.exception.DatabaseException;

/**
 * @author M1035940
 *
 */
public interface GenieDao {

	/**
	 * @param genieForm
	 * @return
	 * @throws DatabaseException
	 */
	boolean saveGenie(Genie genieForm) throws DatabaseException;

	/**
	 * @param username
	 * @return
	 * @throws DatabaseException
	 */
	List<Genie> getAllAssignedGenie(String username) throws DatabaseException;

	/**
	 * @param slno
	 * @return
	 * @throws DatabaseException
	 */
	boolean changeGenieStatus(String slno) throws DatabaseException;

	/**
	 * @return
	 * @throws DatabaseException
	 */
	List<Genie> getAllGenie() throws DatabaseException;

	/**
	 * @return
	 * @throws DatabaseException
	 */
	List<User> getAllAssociate() throws DatabaseException;

	/**
	 * @param slno
	 * @param associateName
	 * @return
	 * @throws DatabaseException
	 */
	String assignAssociate(int slno, String associateName) throws DatabaseException;
}
