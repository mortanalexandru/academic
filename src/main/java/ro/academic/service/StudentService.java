package ro.academic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ro.academic.dto.ContractCourseDTO;
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
	
	
	
}
