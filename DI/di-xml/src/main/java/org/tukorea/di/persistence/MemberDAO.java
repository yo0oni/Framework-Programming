package org.tukorea.di.persistence;

import org.tukorea.di.domain.StudentVO;

public interface MemberDAO {
	public StudentVO read(String id) throws Exception;
	public void add(StudentVO student) throws Exception;
}
