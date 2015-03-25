package ro.academic.access;

import ro.academic.model.User;

/**
 *  User DAO interface
 * @author Alexandru
 *
 */
public interface UserDAO {
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	public User getUserByUsername(String email);
	
}
