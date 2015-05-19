package ro.academic.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ro.academic.dto.CurriculumCoursesDTO;
import ro.academic.dto.StudentDTO;
import ro.academic.model.ContractCourse;
import ro.academic.model.Course;
import ro.academic.model.Curriculum;
import ro.academic.model.CurriculumCourse;
import ro.academic.model.Student;
import ro.academic.model.Teacher;

public class CurriculumCoursesAdapter {
	/**
	AdaptCurriculumCoursesToCurriculumCoursesDTO
	**/
	
	
	
	public static CurriculumCoursesDTO adaptCCtoCCDTO(CurriculumCourse cc)
	{
		CurriculumCoursesDTO curriculumDto = new CurriculumCoursesDTO();
		Course course = cc.getCourse();
		
		curriculumDto.setCourseCode(course.getCode());
		curriculumDto.setCredits(course.getCredits());
		curriculumDto.setName(course.getName());
		curriculumDto.setSemester(cc.getSemester());
		curriculumDto.setOptional(cc.getCourse().isIsOptional());
		return curriculumDto;
	}
	
	public static List<CurriculumCoursesDTO> adaptCurriculumCourseListToDTO(List<CurriculumCourse> courses){
		ArrayList< CurriculumCoursesDTO> coursesDto = new ArrayList<CurriculumCoursesDTO>();
		for(CurriculumCourse course : courses){
			coursesDto.add(adaptCCtoCCDTO(course));
		}
		return coursesDto;
	};
	
	public static List<StudentDTO> adaptCurriculumCourseListToStudentDTO(List<CurriculumCourse> courses)
	{
		StudentAdapter studentAdapter = new StudentAdapter();
		ArrayList<StudentDTO> studentsDTO = new ArrayList<StudentDTO>();
		
		for(CurriculumCourse course : courses)
		{
			for(ContractCourse contract : course.getContractedCourses())
			{
				
				studentsDTO.add(studentAdapter.adaptStudentToStudentDTO(contract.getStudent()));
			}
		}
		return studentsDTO;
	}
	
}
