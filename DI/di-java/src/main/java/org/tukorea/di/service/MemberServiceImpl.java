package org.tukorea.di.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.persistence.MemberDAO;

@Component
public class MemberServiceImpl implements MemberService, InitializingBean, DisposableBean  {
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
	
	public void afterPropertiesSet() throws Exception {
	System.out.println("Init MemberServiceImple");
	}
	
	public void destroy() throws Exception {
	System.out.println("Destroy MemberServiceImple");
	}
}