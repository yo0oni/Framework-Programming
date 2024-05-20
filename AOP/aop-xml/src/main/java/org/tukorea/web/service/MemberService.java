package org.tukorea.web.service;

import org.tukorea.web.domain.StudentVO;

public interface MemberService {
	public StudentVO readMember(String userid) throws Exception;

	public void addMember(StudentVO student) throws Exception;
}
