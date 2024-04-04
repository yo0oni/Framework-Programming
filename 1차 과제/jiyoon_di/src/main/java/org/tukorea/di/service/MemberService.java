package org.tukorea.di.service;

import java.util.List;

import org.tukorea.di.domain.StudentVO;

public interface MemberService {
	StudentVO readMember(String id);

	void addMember(StudentVO student);
	
	int deleteMember(String id);

	List<StudentVO> readMemberList();

	void modifyMember(StudentVO vo);
}
