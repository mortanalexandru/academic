package ro.academic.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Curriculum_Course")
public class CurriculumCourse {

	private int id;
	
	private Curriculum curriculum;
	
	private Course course;
	
	private String description;
	
	private Teacher teacher;
	
	private Set<ContractCourse> contractedCourses;
	
	private int semester;

	@Id
	@Column(name = "idCurriculumCourse", unique = true, nullable = false, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curriculum")
	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course")
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "description", unique = false, 
			nullable = false, length=45)
	public String getDescription() {
		return description;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher")
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	public Set<ContractCourse> getContractedCourses() {
		return contractedCourses;
	}

	public void setContractedCourses(Set<ContractCourse> contractedCourses) {
		this.contractedCourses = contractedCourses;
	}

	@Column(name = "semester", unique = false, 
			nullable = false, length=11)
	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}
	
}
