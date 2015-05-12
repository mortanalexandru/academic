package ro.academic.access;

import ro.academic.model.User;

/**
 *  User DAO interface
 * @author Alexandru
 *
 */
public interface UserDAO {
	
	/**
	 * Gets user by username
	 * @param email
	 * @return
	 */
	public User getUserByUsername(String email);
	
}
