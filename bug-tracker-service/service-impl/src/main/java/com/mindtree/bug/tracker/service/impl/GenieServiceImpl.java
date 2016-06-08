package com.mindtree.bug.tracker.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.bug.tracker.dao.GenieDao;
import com.mindtree.bug.tracker.entity.Genie;
import com.mindtree.bug.tracker.entity.User;
import com.mindtree.bug.tracker.exception.DatabaseException;
import com.mindtree.bug.tracker.exception.ServiceException;
import com.mindtree.bug.tracker.service.GenieService;

/**
 * @author M1035940
 *
 */
@Service
@Transactional
public class GenieServiceImpl implements GenieService {

	/**
	 * 
	 */
	private GenieDao genieDao;

	/**
	 * @param genieDao
	 */
	public void setGenieDao(GenieDao genieDao) {
		this.genieDao = genieDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.bug.tracker.service.GenieService#saveGenie(com.mindtree.bug.
	 * tracker.entity.Genie)
	 */
	public boolean saveGenie(Genie genieForm) throws ServiceException {
		try {
			return genieDao.saveGenie(genieForm);
		} catch (DatabaseException databaseException) {
			throw new ServiceException(databaseException.getMessage(), databaseException);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.bug.tracker.service.GenieService#getAllAssignedGenie(java.
	 * lang.String)
	 */
	public List<Genie> getAllAssignedGenie(String mid) throws ServiceException {
		try {
			return genieDao.getAllAssignedGenie(mid);
		} catch (DatabaseException databaseException) {
			throw new ServiceException(databaseException.getCause());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.bug.tracker.service.GenieService#changeGenieStatus(java.lang
	 * .String)
	 */
	public boolean changeGenieStatus(String slno) throws ServiceException {
		try {
			return genieDao.changeGenieStatus(slno);
		} catch (DatabaseException databaseException) {
			throw new ServiceException(databaseException.getCause());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.bug.tracker.service.GenieService#getAllGenie()
	 */
	public List<Genie> getAllGenie() throws ServiceException {
		try {
			return genieDao.getAllGenie();
		} catch (DatabaseException databaseException) {
			throw new ServiceException(databaseException.getCause());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.bug.tracker.service.GenieService#getAllAssociate()
	 */
	public List<User> getAllAssociate() throws ServiceException {
		try {
			return genieDao.getAllAssociate();
		} catch (DatabaseException databaseException) {
			throw new ServiceException(databaseException.getCause());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.bug.tracker.service.GenieService#assignAssociate(java.lang.
	 * String, java.lang.String)
	 */
	public String assignAssociate(int slno, String associateName) throws ServiceException {
		try {
			return genieDao.assignAssociate(slno, associateName);
		} catch (DatabaseException databaseException) {
			throw new ServiceException(databaseException.getCause());
		}
	}
}
