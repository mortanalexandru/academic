package ro.academic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Teacher")
public class Teacher {
	 /**
		 *  Default serial version
		 */
		private static final long serialVersionUID = 1L;
		
	    private int teacherId;
	    
	    private String name;
	    
	    private int degree;
	    
	    private Department department;
	    
	    private User user;
	    
	    private Set<Course> coursesCanTeach;
	    
	    private Set<Course> proposedCourses;
	    
		private Set<CurriculumCourse> courses;
	    
	    @OneToMany(mappedBy = "department_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)  
	    private Set<Course> meetings = new HashSet<Course>();

		@Id
		@Column(name = "teacher_id", unique = true, nullable = false, length = 11)
		public int getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(int teacherId) {
			this.teacherId = teacherId;
		}
		
		@Column(name = "name", unique = false,
				nullable = false, length = 64)
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Column(name = "degree", unique = false, 
				nullable = false, length = 11)
		public int getDegree() {
			return degree;
		}

		public void setDegree(int degree) {
			this.degree = degree;
		}

	    @ManyToOne
	    @JoinColumn(name = "department_id")
		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

	    @OneToOne
	    @JoinColumn(name = "username")
		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinTable(name = "Teacher_Course", joinColumns = { 
				@JoinColumn(name = "teacherId", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "courseId", 
						nullable = false, updatable = false) })
		public Set<Course> getProposedCourses() {
			return proposedCourses;
		}

		public void setProposedCourses(Set<Course> courses) {
			this.proposedCourses = courses;
		}

	    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
		public Set<Course> getCoursesCanTeach() {
			return coursesCanTeach;
		}

		public void setCoursesCanTeach(Set<Course> coursesCanTeach) {
			this.coursesCanTeach = coursesCanTeach;
		}
		
	    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)  
		public Set<CurriculumCourse> getCourses() {
			return courses;
		}

		public void setCourses(Set<CurriculumCourse> courses) {
			this.courses = courses;
		}

}
