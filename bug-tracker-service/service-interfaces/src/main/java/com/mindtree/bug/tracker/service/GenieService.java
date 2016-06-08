package com.mindtree.bug.tracker.service;

import java.util.List;

import com.mindtree.bug.tracker.entity.Genie;
import com.mindtree.bug.tracker.entity.User;
import com.mindtree.bug.tracker.exception.ServiceException;

/**
 * @author M1035940
 *
 */
public interface GenieService {

	/**
	 * @param genieForm
	 * @return
	 * @throws ServiceException
	 */
	boolean saveGenie(Genie genieForm) throws ServiceException;

	/**
	 * @param userName
	 * @return
	 * @throws ServiceException
	 */
	List<Genie> getAllAssignedGenie(String userName) throws ServiceException;

	/**
	 * @param slno
	 * @return
	 * @throws ServiceException
	 */
	boolean changeGenieStatus(String slno) throws ServiceException;

	/**
	 * @return
	 * @throws ServiceException
	 */
	List<Genie> getAllGenie() throws ServiceException;

	/**
	 * @return
	 * @throws ServiceException
	 */
	List<User> getAllAssociate() throws ServiceException;

	/**
	 * @param slno
	 * @param associateName
	 * @return
	 * @throws ServiceException
	 */
	String assignAssociate(int slno, String associateName) throws ServiceException;

}
