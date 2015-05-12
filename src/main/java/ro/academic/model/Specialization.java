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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Specialization")
public class Specialization {

	private int id;
	
	private String name;
	
	private Department department;
	
	private Language language;
	
	private Set<Curriculum> curriculums;

	@Id
	@Column(name = "idSpecialization", unique = true, nullable = false, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name = "name", length = 64)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @ManyToOne
    @JoinColumn(name = "department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

    @ManyToOne
    @JoinColumn(name = "language_id")
	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	@OneToMany(mappedBy = "specialization", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	public Set<Curriculum> getCurriculums() {
		return curriculums;
	}

	public void setCurriculums(Set<Curriculum> curriculums) {
		this.curriculums = curriculums;
	}
	
	
}
