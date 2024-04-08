package org.tukorea.di.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tukorea.di.domain.StudentVO;
import org.tukorea.di.service.MemberService;

public class MemberSampleMain {
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws Exception {
		System.out.println("안녕하세요 DB-SPRINGJDBC");
		ctx = new GenericXmlApplicationContext("applicationContext.xml");
		MemberService memberService = ctx.getBean(MemberService.class);
		String strID = "hansol";
		StudentVO vo = new StudentVO();
		vo.setId(strID);
		vo.setPasswd(strID);
		vo.setUsername(strID);
		vo.setSnum(strID);

		try {
			StudentVO member = memberService.readMember(strID);
			System.out.println(member);
			List<StudentVO> list = memberService.readMemberList();
			for (StudentVO svo : list) {
				System.out.println(svo);
			}
		} catch (DataAccessException e) {
			System.out.println(e);
		} finally {
			JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
			int count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM STUDENT", Integer.class);
			System.out.println(count);
		}
	}
}