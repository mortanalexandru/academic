package ro.academic.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.academic.access.UserDAO;
import ro.academic.model.User;
import ro.academic.model.UserWrapper;
/**
 * User Service for Spring Security
 * @author Alexandru
 *
 */
@Service("userSecurityService")
public class UserSecurityService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	
	/**
	 * Gets User by email
	 */
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user = userDAO.getUserByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("invalid username or password");
		}
		List<GrantedAuthority> authorities = 
                                      buildUserAuthority(user.getPriviledge());
                                      
		return buildUserForAuthentication(user, authorities);
	}

	/**
	 * Adapts the User entity to UserWrapper entity which is stored on session
	 * @param user
	 * @param authorities
	 * @return
	 */
	private UserDetails buildUserForAuthentication(User user, 
			List<GrantedAuthority> authorities) {
			return new UserWrapper(user, true , true, true, true, authorities);
		}
	
	/**
	 * Return a list with user authorities base on his role
	 * @param roles
	 * @return
	 */
	private List<GrantedAuthority> buildUserAuthority(int priviledge) {
	 
		
			Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
	 
			if(priviledge == 1){
				setAuths.add(new SimpleGrantedAuthority("STUDENT"));
			}else if(priviledge == 2){
				setAuths.add(new SimpleGrantedAuthority("TEACHER"));
			}
			
	 
			List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths); 
			return Result;
			
		}
	
}
