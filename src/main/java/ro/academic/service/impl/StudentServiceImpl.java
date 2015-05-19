package ro.academic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.academic.access.CurriculumDAO;
import ro.academic.access.StudentDAO;
import ro.academic.adapter.CurriculumCoursesAdapter;
import ro.academic.adapter.StudentAdapter;
import ro.academic.dto.ContractCourseDTO;
import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.model.CurriculumCourse;
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
	
	@Autowired
	private CurriculumDAO curriculumDao;
	

	@Override
	public StudentDTO getStudentByUser(User user) {
		Student student = studentDao.getStudentByUser(user);
		return StudentAdapter.adaptStudentToStudentDTO(student);
	}
	

	public List<CurriculumCoursesDTO> getCoursesForGroup(int group){
		List<CurriculumCoursesDTO> courses = new ArrayList<CurriculumCoursesDTO>();
		for(CurriculumCourse course : curriculumDao.getCurriculumForGroup(group).getCourses()){
			courses.add(CurriculumCoursesAdapter.adaptCCtoCCDTO(course));
		}
		return courses;
		
	}





}
