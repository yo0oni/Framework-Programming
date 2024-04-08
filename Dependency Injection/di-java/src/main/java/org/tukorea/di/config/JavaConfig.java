package org.tukorea.di.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tukorea.di.persistence.MemberDAO;
import org.tukorea.di.persistence.MemberDAOImpl;
import org.tukorea.di.service.MemberService;
import org.tukorea.di.service.MemberServiceImpl;

@Configuration
public class JavaConfig {
	@Bean
	public MemberDAO memberDAO() {
		return new MemberDAOImpl();
	}

	@Bean(name = "service")
	public MemberService memberService() {
		return new MemberServiceImpl(memberDAO());
	}
}