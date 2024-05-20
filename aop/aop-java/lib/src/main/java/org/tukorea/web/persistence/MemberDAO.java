package org.tukorea.web.persistence;

import org.tukorea.web.domain.StudentVO;

public interface MemberDAO {
	public StudentVO read(String id);

	public void add(StudentVO student);
}
