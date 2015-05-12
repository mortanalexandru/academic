package ro.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.academic.constants.UrlMappings;
import ro.academic.constants.ViewNames;
import ro.academic.model.UserWrapper;
import ro.academic.service.CurriculumCoursesService;
import ro.academic.service.TeacherService;
import ro.academic.service.impl.DepartmentServiceImpl;
import ro.academic.service.impl.TeacherServiceImpl;



@Controller
public class TeacherController {
	@Autowired
	private TeacherService teachService;
	
	@Autowired
	private CurriculumCoursesService ccService;
	
	/**
	 * Default Get method
	 * @return
	 */
	@RequestMapping(value = UrlMappings.TEACHER_HOME, method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserWrapper userDetail = (UserWrapper) auth.getPrincipal();
		ModelAndView model = new ModelAndView();
		model.setViewName(ViewNames.TEACHER_HOME.getViewName());
		
		model.addObject("username", userDetail.getUsername());
		model.addObject("teacher", userDetail.getTeacher());
		
		ccService.getCCByTeacher(userDetail.getUser());
		
		
		return model;
	}
}
