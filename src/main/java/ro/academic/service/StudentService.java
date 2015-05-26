package ro.academic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.academic.dto.ContractCourseDTO;
import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.model.User;

/**
 * Student service
 * @author Alexandru
 *
 */
public interface StudentService {

	/**
	 * Gets student fto for a given user
	 * @param users
	 * @return
	 */
	public StudentDTO getStudentByUser(User user);
	
	
	public List<CurriculumCoursesDTO> getCoursesForGroup(int group);
	
	public void saveContractCoursesForStudent(int group, User user, String[] courses);
}
