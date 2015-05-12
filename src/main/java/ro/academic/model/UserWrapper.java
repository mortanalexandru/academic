package ro.academic.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.dto.TeacherDTO;

/**
 * Entity to bo stored on session
 * @author Alexandru 
 *
 */
public class UserWrapper implements UserDetails {
	
	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private StudentDTO student;
	
	private TeacherDTO teacher;

	
	private Collection<? extends GrantedAuthority> authorities;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	public UserWrapper(User user, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired,
			boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		
		this.user = user;
		this.authorities = authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
	public User getUser(){
		return this.user;
	}


	public StudentDTO getStudent() {
		return student;
	}
	
	public TeacherDTO getTeacher()
	{
		return teacher;
	}
	


	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	
	public void setTeacher(TeacherDTO teacher)
	{
		this.teacher = teacher;
	}


}
