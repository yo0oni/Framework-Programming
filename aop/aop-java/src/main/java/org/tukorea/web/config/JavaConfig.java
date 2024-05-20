package org.tukorea.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.tukorea.web.aop.MemberAspect;
import org.tukorea.web.persistence.MemberDAO;
import org.tukorea.web.persistence.MemberDAOImpl;
import org.tukorea.web.service.MemberService;
import org.tukorea.web.service.MemberServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class JavaConfig {
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAOImpl();
	}

	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberDAO());
	}

	@Bean
	public MemberAspect memberAspect() {
		return new MemberAspect();
	}
}