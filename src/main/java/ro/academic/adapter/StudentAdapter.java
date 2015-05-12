package ro.academic.adapter;

import ro.academic.dto.StudentDTO;
import ro.academic.model.Curriculum;
import ro.academic.model.Department;
import ro.academic.model.Group;
import ro.academic.model.Specialization;
import ro.academic.model.Student;

/**
 * Student Adapter
 * @author Alexandru
 *
 */
public class StudentAdapter {

	/**
	 * Adapts student to student DTOs
	 * @param student
	 * @return
	 */
	public static StudentDTO adaptStudentToStudentDTO(Student student){
		StudentDTO studentDto = new StudentDTO();
		Group group = student.getGroup();
		Curriculum curriculum = group.getCurriculum();
		Specialization specialization = curriculum.getSpecialization();
		Department department = specialization.getDepartment();
		studentDto.setName(student.getName());
		studentDto.setGroup(group.getName());
		studentDto.setCurriculum(curriculum.getStartYear()+"-"+curriculum.getEndYear());
		studentDto.setSpecialization(specialization.getName());
		studentDto.setDepartment(department.getTitle());
		studentDto.setUser(student.getUser());
		return studentDto;
	}
}
