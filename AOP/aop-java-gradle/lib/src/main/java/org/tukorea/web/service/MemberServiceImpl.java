package org.tukorea.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tukorea.web.domain.StudentVO;
import org.tukorea.web.persistence.MemberDAO;

@Component
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO memberDAO;

	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public StudentVO readMember(String userid) throws Exception {
		return memberDAO.read(userid);
	}

	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);
	}
}