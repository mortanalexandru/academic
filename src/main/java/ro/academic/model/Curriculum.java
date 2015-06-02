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
@Table(name = "Curriculum")
public class Curriculum {

	private int id;
	
	private int startSem;
	
	private int endSem;
	
	private Specialization specialization;
	
	private Set<CurriculumCourse> courses;
	
	private Set<Group> groups;
	

	@Id
	@Column(name = "idCurriculum", unique = true, nullable = false, length = 11)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "startSem", length = 11)
	public int getStartSem() {
		return startSem;
	}

	public void setStartSem(int startSem) {
		this.startSem = startSem;
	}

	@Column(name = "endSem", length = 11)
	public int getEndSem() {
		return endSem;
	}

	public void setEndSem(int endSem) {
		this.endSem = endSem;
	}

    @ManyToOne
    @JoinColumn(name = "specialization_id")
	public Specialization getSpecialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	public Set<CurriculumCourse> getCourses() {
		return courses;
	}

	public void setCourses(Set<CurriculumCourse> courses) {
		this.courses = courses;
	}

	@OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
}
