package ro.academic.service;

import ro.academic.dto.TeacherDTO;
import ro.academic.model.User;

public interface TeacherService {
	public TeacherDTO getTeacherByUser(User user);
}
