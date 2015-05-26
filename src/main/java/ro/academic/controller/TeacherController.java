package ro.academic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestParam;

import ro.academic.constants.UrlMappings;
import ro.academic.constants.ViewNames;
import ro.academic.model.UserWrapper;
import ro.academic.service.CurriculumCoursesService;
import ro.academic.service.TeacherService;
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
		if(userDetail.getTeacher().getDegree() == 2)
			model.setViewName(ViewNames.CHIEF_HOME.getViewName());
		else
			model.setViewName(ViewNames.TEACHER_HOME.getViewName());
		
		model.addObject("username", userDetail.getUsername());
		model.addObject("teacher", userDetail.getTeacher());
		
		
		return model;
	}

	@RequestMapping(value = UrlMappings.TEACHER_MANAGE_COURSES, method = RequestMethod.GET)
	public ModelAndView getCatalogView() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserWrapper userDetail = (UserWrapper) auth.getPrincipal();
		ModelAndView model = new ModelAndView();
		model.setViewName(ViewNames.TEACHER_MANAGE_COURSES.getViewName());
		
		model.addObject("username", userDetail.getUsername());
		model.addObject("teacher", userDetail.getTeacher());
		model.addObject("courses", ccService.getCCByTeacher(userDetail.getUser()));
		
		
		return model;
	}
	@RequestMapping(value = UrlMappings.TEACHER_PROPOSE_COURSES, method = RequestMethod.GET)
	public ModelAndView getProposeCourses() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserWrapper userDetail = (UserWrapper) auth.getPrincipal();
		ModelAndView model = new ModelAndView();
		model.setViewName(ViewNames.TEACHER_PROPOSE_COURSES.getViewName());
		
		model.addObject("username", userDetail.getUsername());
		model.addObject("teacher", userDetail.getTeacher());
		
		ccService.getCCByTeacher(userDetail.getUser());
		return model;
	}

	@RequestMapping(value = UrlMappings.GET_COURSE, method = RequestMethod.GET)
	public ModelAndView getCourse(@RequestParam(value = "code", required = true) String code, @RequestParam(value = "semester", required = true) int semester ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserWrapper userDetail = (UserWrapper) auth.getPrincipal();
		ModelAndView model = new ModelAndView();
		model.setViewName(ViewNames.GET_COURSE.getViewName());
		model.addObject("code", code);
		model.addObject("semester", semester);
		model.addObject("username", userDetail.getUsername());
		model.addObject("teacher", userDetail.getTeacher());
		model.addObject("students", ccService.getStudentsByCC(code));
		
		

		return model;
	}


}
