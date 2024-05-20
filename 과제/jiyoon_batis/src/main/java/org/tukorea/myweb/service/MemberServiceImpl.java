package org.tukorea.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tukorea.myweb.domain.StudentVO;
import org.tukorea.myweb.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public StudentVO readMember(String id) throws Exception {
		return memberDAO.read(id);
	}

	@Override
	public void addMember(StudentVO student) throws Exception {
		memberDAO.add(student);	}

	@Override
	public List<StudentVO> readMemberList() throws Exception {
		return memberDAO.readList();
	}

	@Override
	public void updateMember(StudentVO student) throws Exception {
		memberDAO.update(student);
	}

	@Override
	public void deleteMember(String id) throws Exception {
		memberDAO.delete(id);
	}
}
