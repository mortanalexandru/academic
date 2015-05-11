package ro.academic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.academic.constants.UrlMappings;
import ro.academic.constants.ViewNames;
import ro.academic.model.UserWrapper;
import ro.academic.service.DepartmentServiceImpl;

/**
 * User Controller
 * @author Alexandru
 *
 */
@Controller
public class UserController {
	

	
	/**
	 * Get method for login
	 * @param error
	 * @param logout
	 * @param request
	 * @return
	 */
	@RequestMapping(value = UrlMappings.LOGIN_URL, method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error, HttpServletRequest request) {
		boolean hasErrors = false;
		ModelAndView model = new ModelAndView();
		model.setViewName(ViewNames.LOGIN_VIEW.getViewName());
		if(error != null){
			hasErrors = true;
		}
		model.addObject("error", hasErrors);
		return model;

	}
	

	@RequestMapping(value = UrlMappings.EDIT_PAGE, method = RequestMethod.GET)
	public ModelAndView getEditPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserWrapper userDetail = (UserWrapper) auth.getPrincipal();
		
		ModelAndView model = new ModelAndView();
		model.setViewName("editAccount");
		return model;

	}

}
