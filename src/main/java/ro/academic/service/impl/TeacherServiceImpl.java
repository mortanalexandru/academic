package ro.academic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.academic.access.StudentDAO;
import ro.academic.access.TeacherDAO;
import ro.academic.adapter.TeacherAdapter;
import ro.academic.dto.TeacherDTO;
import ro.academic.model.ContractCourse;
import ro.academic.model.Student;
import ro.academic.model.Teacher;
import ro.academic.model.User;
import ro.academic.service.TeacherService;

/**
 * Teacher Service implementation
 * @author Alexandru
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDAO teacherDao;
	@Autowired
	private StudentDAO studDao;
	

	@Override
	public TeacherDTO getTeacherByUser(User user) {
		Teacher Teacher = teacherDao.getTeacherByUser(user);
		return TeacherAdapter.adaptTeacherToTeacherDTO(Teacher);
	}
	@Override
	public void saveGrades(Map<String, String> gradesAndUser)
	{
		String code = "";
		//List<Student> listStud = new ArrayList<Student>();
		List<ContractCourse> listCc = new ArrayList<ContractCourse>();
		
		for (String key : gradesAndUser.keySet()) 
		{
			if(key.equals("courseCode")){
				code = gradesAndUser.get(key);
			}else{
			Student stud = studDao.getStudentByUsername(key);
			for(ContractCourse course : stud.getSelectedCourses()){
				if(course.getCourse().getCourse().getCode().equals(code)){
					course.setGrade(Integer.parseInt(gradesAndUser.get(key)));
					listCc.add(course);
				}
			}
			//listStud.add(stud);
			}
			
		}
		studDao.saveGrades(listCc);
		
		
	}
	

}
