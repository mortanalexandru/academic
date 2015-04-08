package ro.academic.constants;

/**
 * View Names
 * @author Alexandru
 *
 */
public enum ViewNames {
	
	LANDING_VIEW("teacherHome"),
	LOGIN_VIEW("login"),
	HOME_VIEW("home"),
	EDIT_VIEW("edit");
	
	private ViewNames(String viewName){
		this.setViewName(viewName);
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	private String viewName;
	
	
}
