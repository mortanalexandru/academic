package ro.academic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.academic.access.CurriculumCoursesDAO;
import ro.academic.adapter.CurriculumCoursesAdapter;
import ro.academic.adapter.TeacherAdapter;
import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.TeacherDTO;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.Teacher;
import ro.academic.model.User;
import ro.academic.service.CurriculumCoursesService;

@Service
public class CurriculumCoursesServiceImpl implements CurriculumCoursesService {

	@Autowired
	private CurriculumCoursesDAO ccDAO;
	
	public List<CurriculumCoursesDTO> getCCByTeacher(User user) {
		List<CurriculumCourse> cc = ccDAO.getCurriculumCoursesByTeacher(user);
		return CurriculumCoursesAdapter.adaptCurriculumCourseListToDTO(cc);
		
	}




}
