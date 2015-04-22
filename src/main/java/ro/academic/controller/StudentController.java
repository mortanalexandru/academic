package ro.academic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.academic.constants.UrlMappings;
import ro.academic.constants.ViewNames;
import ro.academic.model.UserWrapper;

@Controller
public class StudentController {

	/**
	 * Default Get method
	 * @return
	 */
	@RequestMapping(value = UrlMappings.STUDENT_CATALOG, method = RequestMethod.GET)
	public ModelAndView getCatalog() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserWrapper userDetail = (UserWrapper) auth.getPrincipal();
		
		ModelAndView model = new ModelAndView();
		model.setViewName(ViewNames.CATALOG_VIEW.getViewName());
		model.addObject("username", userDetail.getUsername());
		return model;
	}
	
	/**
	 * Default Get method
	 * @return
	 */
	@RequestMapping(value = UrlMappings.STUDENT_HOME_PAGE, method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserWrapper userDetail = (UserWrapper) auth.getPrincipal();
		
		ModelAndView model = new ModelAndView();
		model.setViewName(ViewNames.STUDENT_VIEW.getViewName());
		model.addObject("username", userDetail.getUsername());
		return model;

	}
}
