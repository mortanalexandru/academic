package ro.academic.access;

import ro.academic.model.Curriculum;

public interface CurriculumDAO {

	public Curriculum getCurriculumForGroup(int group);
	
	public Curriculum getCurriculumForSemester(int semester);
}
