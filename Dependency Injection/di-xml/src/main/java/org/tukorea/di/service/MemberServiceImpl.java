package org.tukorea.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.persistence.MemberDAO;

@Component
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public StudentVO readMember(String userid) throws Exception {
		return memberDAO.read(userid);
	}

	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}
}