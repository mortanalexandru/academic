package ro.academic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.academic.access.CourseDAO;
import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.service.CourseService;

public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;
	
	@Override
	public List<CurriculumCoursesDTO> getUnaprovedCourses() {
		// TODO Auto-generated method stub
		return null;
	}

}
