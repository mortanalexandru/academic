package ro.academic.dto;


import java.io.Serializable;
import java.util.List;

import ro.academic.model.User;

/**
 * Student dto
 * @author Alexandru
 *
 */
public class StudentDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	
	private int group;
	
	private User user;
	
	private String curriculum;
	
	private String specialization;
	
	private String department;

	private String id;
	
	private List<ContractCourseDTO> courses;

	public String getId()
	{
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<ContractCourseDTO> getCourses() {
		return courses;
	}

	public void setCourses(List<ContractCourseDTO> courses) {
		this.courses = courses;
	}

}
