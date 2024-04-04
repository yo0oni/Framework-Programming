package org.tukorea.di.service;

import java.util.List;

import org.tukorea.di.domain.StudentVO;

public interface MemberService {
	public StudentVO readMember(String id) throws Exception;

	public void addMember(StudentVO student) throws Exception;
	
	public int deleteMember(String id) throws Exception;

	public List<StudentVO> readMemberList() throws Exception;

	public void modifyMember(StudentVO vo) throws Exception;
}
