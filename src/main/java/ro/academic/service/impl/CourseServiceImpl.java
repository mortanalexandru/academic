package ro.academic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ro.academic.access.CourseDAO;
import ro.academic.dto.ContractCourseDTO;
import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.model.ContractCourse;
import ro.academic.model.Course;
import ro.academic.service.CourseService;

public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseDAO courseDAO;
	
	@Override
	public List<ContractCourseDTO> getUnaprovedCourses() {
		List<ContractCourseDTO> unaprovedCourses = new ArrayList<ContractCourseDTO>();
		for(Course course : courseDAO.getCourses()){
			if(!course.getCurriculumCourses().isEmpty()){
				ContractCourseDTO courseDTO = new ContractCourseDTO();
				courseDTO.setCode(course.getCode());
				courseDTO.setCredits(course.getCredits());
				courseDTO.setName(course.getName());
				courseDTO.setTeacher(course.getTeacher().getName());
				unaprovedCourses.add(courseDTO);
			}
		}
		return unaprovedCourses;
	}

}
