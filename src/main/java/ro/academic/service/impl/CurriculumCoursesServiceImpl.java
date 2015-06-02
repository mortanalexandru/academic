package ro.academic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.academic.access.CurriculumCoursesDAO;
import ro.academic.access.TeacherDAO;
import ro.academic.adapter.CurriculumCoursesAdapter;
import ro.academic.adapter.TeacherAdapter;
import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.dto.TeacherDTO;
import ro.academic.model.Course;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.OptionalCourse;
import ro.academic.model.Teacher;
import ro.academic.model.User;
import ro.academic.service.CurriculumCoursesService;

@Service
public class CurriculumCoursesServiceImpl implements CurriculumCoursesService {

	@Autowired
	private CurriculumCoursesDAO ccDAO;
	@Autowired
	private TeacherDAO tDAO;
	
	public List<CurriculumCoursesDTO> getCCByTeacher(User user) {
		List<CurriculumCourse> cc = ccDAO.getCurriculumCoursesByTeacher(user);
		return CurriculumCoursesAdapter.adaptCurriculumCourseListToDTO(cc);
		
	}
	public List<CurriculumCoursesDTO> getAllCC() {
		List<CurriculumCourse> cc = ccDAO.getCurriculumCourses();
		return CurriculumCoursesAdapter.adaptCurriculumCourseListToDTO(cc);
		
	}
	
	public List<StudentDTO> getStudentsByCC(String code)
	{
		List<CurriculumCourse> cc = ccDAO.getStudentsByCurriculumCourses(code);
		return CurriculumCoursesAdapter.adaptCurriculumCourseListToStudentDTO(cc);
	}
	
	public void saveProposedCourses(OptionalCourse courses, User user)
	{
		Course c = new Course();
		c.setName(courses.getName());
		c.setSemester(Integer.parseInt(courses.getSemester()));
		c.setCredits(Integer.parseInt(courses.getCredits()));
		c.setTeacher(tDAO.getTeacherByUser(user));
		c.setCode(courses.getCode());
		c.setIsOptional(true);
		
		
		ccDAO.setCurriculumCourses(c);
		
	}


}
