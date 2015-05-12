package ro.academic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.academic.access.TeacherDAO;
import ro.academic.adapter.TeacherAdapter;
import ro.academic.dto.TeacherDTO;
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
	

	@Override
	public TeacherDTO getTeacherByUser(User user) {
		Teacher Teacher = teacherDao.getTeacherByUser(user);
		return TeacherAdapter.adaptTeacherToTeacherDTO(Teacher);
	}
	

}
