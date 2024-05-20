package org.tukorea.web.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.tukorea.web.domain.StudentVO;
import org.tukorea.web.service.MemberService;

public class MemberSampleMain {
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws Exception {
		System.out.println("안녕하세요 AOP-ANNOTATION");
		ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		
		StudentVO vo = new StudentVO();
		vo.setId("kanadara");
		memberService.addMember(vo);
		
		StudentVO member = memberService.readMember("kanadara");
		System.out.println(member);
	}
}
