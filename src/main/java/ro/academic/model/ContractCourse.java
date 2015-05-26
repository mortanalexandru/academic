package ro.academic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Curriculum_Course_Student")
public class ContractCourse {

	private int id;
	
	private CurriculumCourse course;
	
	private Student student;
	
	private int grade;
	
	private int order;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idCurriculum_Course_Student", unique = true, nullable = false, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "curriculumCourse")
	public CurriculumCourse getCourse() {
		return course;
	}

	public void setCourse(CurriculumCourse course) {
		this.course = course;
	}


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "grade", unique = false, 
			nullable = false, length = 11)
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Column(name = "orderSort", unique = false, 
			nullable = false, length = 11)
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
	
}
