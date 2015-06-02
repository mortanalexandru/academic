package ro.academic.constants;

/**
 * View Names
 * @author Alexandru
 *
 */
public enum ViewNames {
	
	LANDING_VIEW("teacherHome"),
	LOGIN_VIEW("loginView"),
	LANDING_PAGE("home"),
	EDIT_VIEW("edit"),
	CATALOG_VIEW("catalogView"),
	STUDENT_VIEW("studentView"),
	TEACHER_HOME("teacherHome"),
	TEACHER_MANAGE_COURSES("teacher_catalogView"),
	TEACHER_PROPOSE_COURSES("teacher_proposeCourses"),
	GET_COURSE("courseView"),
	CHIEF_HOME("chiefHome");
	
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
