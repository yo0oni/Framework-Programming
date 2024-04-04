package org.tukorea.di.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.persistence.MemberDAO;

@Component
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	public void modifyMember(StudentVO vo) {
		memberDAO.modify(vo);
	}

	public StudentVO readMember(String id) {
		return memberDAO.read(id);
	}

	public void addMember(StudentVO student) {
		memberDAO.add(student);
	}

	public List<StudentVO> readMemberList() {
		return memberDAO.readList();
	}

	public int deleteMember(String id) {
		return memberDAO.delete(id);
	}
}