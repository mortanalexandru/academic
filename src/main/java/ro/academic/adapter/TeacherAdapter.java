package ro.academic.adapter;

import ro.academic.dto.TeacherDTO;
import ro.academic.model.Department;
import ro.academic.model.Teacher;
import ro.academic.model.User;

public class TeacherAdapter {
	public static TeacherDTO adaptTeacherToTeacherDTO(Teacher teacher)
	{
		TeacherDTO teacherDto = new TeacherDTO();
		String name = teacher.getName();
		int degree = teacher.getDegree();
		Department dep = teacher.getDepartment();
		User user = teacher.getUser();
		
		teacherDto.setName(name);
		teacherDto.setDegree(degree);
		teacherDto.setDepartment(dep);
		teacherDto.setUser(user);
		return teacherDto;
		
	}
}
