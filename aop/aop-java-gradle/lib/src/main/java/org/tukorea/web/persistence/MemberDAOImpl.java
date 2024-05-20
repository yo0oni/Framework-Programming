package org.tukorea.web.persistence;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.tukorea.web.domain.StudentVO;

@Component
public class MemberDAOImpl implements MemberDAO {
	private Map<String, StudentVO> storage = new HashMap<String, StudentVO>();

	public StudentVO read(String id) {
		return storage.get(id);
	}

	public void add(StudentVO student) {
		storage.put(student.getId(), student);
	}
}
