package ro.academic.service;

import java.util.HashMap;
import java.util.Map;

import ro.academic.dto.TeacherDTO;
import ro.academic.model.User;

public interface TeacherService {
	public TeacherDTO getTeacherByUser(User user);
	public void saveGrades(Map<String, String> gradesAndUser);
}
