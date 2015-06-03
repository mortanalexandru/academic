package ro.academic.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

	private int id;
	
	private String code;
	
	private String name;
	
	private int semester;
	
	private int credits;
	
	private boolean isOptional;
	
	private Teacher teacher;
	
	private Set<Teacher> teachersSpecialized;

	private Set<CurriculumCourse> curriculumCourses;
	
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "course_id", unique = true, nullable = false, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "code", unique = false, 
			nullable = false, length=11)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", unique = false, 
			nullable = false, length = 64)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "credits", unique = false, 
			nullable = false, length = 11)
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Column(name = "is_optional", unique = false, 
			nullable = false, length = 1)
	public boolean isIsOptional() {
		return isOptional;
	}

	public void setIsOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}

    @ManyToOne
    @JoinColumn(name = "proposedTeacher_id")  
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "semester", unique = false, 
			nullable = false, length = 11)
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "proposedCourses")
	public Set<Teacher> getTeachersSpecialized() {
		return teachersSpecialized;
	}

	public void setTeachersSpecialized(Set<Teacher> teachersSpecialized) {
		this.teachersSpecialized = teachersSpecialized;
	}

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER) 
	public Set<CurriculumCourse> getCurriculumCourses() {
		return curriculumCourses;
	}

	public void setCurriculumCourses(Set<CurriculumCourse> curriculumCourses) {
		this.curriculumCourses = curriculumCourses;
	}
	

	
}
