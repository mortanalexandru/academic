package ro.academic.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ro.academic.dto.ContractCourseDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.model.ContractCourse;
import ro.academic.model.Course;
import ro.academic.model.Curriculum;
import ro.academic.model.CurriculumCourse;
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
		Set<ContractCourse> courses = student.getSelectedCourses();
		studentDto.setCourses(adaptContractCourseListToDTO(courses));
		studentDto.setName(student.getName());
		studentDto.setGroup(group.getName());
		studentDto.setCurriculum(curriculum.getStartSem()+"-"+curriculum.getEndSem());
		studentDto.setSpecialization(specialization.getName());
		studentDto.setDepartment(department.getTitle());
		studentDto.setUser(student.getUser());
		return studentDto;
	}
	
	public static List<ContractCourseDTO> adaptContractCourseListToDTO(Set<ContractCourse> courses){
		ArrayList< ContractCourseDTO> coursesDto = new ArrayList<ContractCourseDTO>();
		for(ContractCourse course : courses){
			coursesDto.add(adaptContractCourseToDTO(course));
		}
		return coursesDto;
	};
	
	public static ContractCourseDTO adaptContractCourseToDTO(ContractCourse course){
		ContractCourseDTO contractCourse = new ContractCourseDTO();
		Course courseInfo = course.getCourse().getCourse();
		contractCourse.setCode(courseInfo.getCode());
		contractCourse.setName(courseInfo.getName());
		contractCourse.setCredits(courseInfo.getCredits());
		contractCourse.setSemester(courseInfo.getSemester());
		int grade = course.getGrade();
		if(grade >= 5){
			contractCourse.setPassed(true);
		}
		contractCourse.setGrade(course.getGrade());
		contractCourse.setTeacher(courseInfo.getTeacher().getName());
		contractCourse.setOptional(courseInfo.isIsOptional());
		return contractCourse;
	};
	
}
