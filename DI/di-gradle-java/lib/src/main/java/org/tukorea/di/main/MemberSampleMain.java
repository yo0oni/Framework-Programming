package org.tukorea.di.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.tukorea.di.config.JavaConfig;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

public class MemberSampleMain {
	private static ConfigurableApplicationContext ctx = null;

	public static void main(String[] args) throws Exception {
		System.out.println("안녕하세요 DI-JavaConfig");
		ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		MemberService memberService = ctx.getBean(MemberService.class);
		StudentVO vo = new StudentVO();
		vo.setId("kanadara");
		memberService.addMember(vo);
		StudentVO member = memberService.readMember("kanadara");
		System.out.println(member);
		
		ctx.close();
	}
}