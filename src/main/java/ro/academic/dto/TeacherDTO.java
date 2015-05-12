package ro.academic.dto;

import ro.academic.model.Department;
import ro.academic.model.User;

public class TeacherDTO {
    private String name;
    
    private int degree;
    
	private Department department;
    
    private User user;
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
