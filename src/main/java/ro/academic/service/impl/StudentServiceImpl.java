package ro.academic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.academic.access.StudentDAO;
import ro.academic.adapter.StudentAdapter;
import ro.academic.dto.StudentDTO;
import ro.academic.model.Student;
import ro.academic.model.User;
import ro.academic.service.StudentService;

/**
 * Student Service implementation
 * @author Alexandru
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDao;
	

	@Override
	public StudentDTO getStudentByUser(User user) {
		Student student = studentDao.getStudentByUser(user);
		return StudentAdapter.adaptStudentToStudentDTO(student);
	}
	

}
