package ro.academic.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.academic.access.CurriculumDAO;
import ro.academic.access.StudentDAO;
import ro.academic.adapter.CurriculumCoursesAdapter;
import ro.academic.adapter.StudentAdapter;
import ro.academic.dto.ContractCourseDTO;
import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.model.ContractCourse;
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


	@Override
	public void saveContractCoursesForStudent(int group, User user, String[] chosenOptionals) {
		Student student = studentDao.getStudentByUser(user);
		List<ContractCourse> courses = new ArrayList<ContractCourse>();
		Set<CurriculumCourse> allCourses = curriculumDao.getCurriculumForGroup(group).getCourses();
		for(CurriculumCourse course : allCourses){
			if(!course.getCourse().isIsOptional()){
				ContractCourse contrCourse = new ContractCourse();
				contrCourse.setCourse(course);
				contrCourse.setGrade(0);
				contrCourse.setStudent(student);
				courses.add(contrCourse);
			}
		}
		int order = 0 ;
		for(String optionalCourse : chosenOptionals){
			for(CurriculumCourse course : allCourses){
				if(course.getCourse().getCode().equals(optionalCourse)){
					ContractCourse contrCourse = new ContractCourse();
					contrCourse.setCourse(course);
					contrCourse.setGrade(0);
					contrCourse.setStudent(student);
					contrCourse.setOrder(order);
					order++;
					courses.add(contrCourse);
				}
			}
		}
		studentDao.saveCourses(courses);
	}





}
