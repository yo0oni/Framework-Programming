package org.tukorea.free.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.service.UserService;

public class TransactionMain {

	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws Exception {
		
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext_annotation.xml");
		UserService service = ctx.getBean(UserService.class);
		
		UserVO user1 = new UserVO();
		user1.setId("jiyoon");
		user1.password("jiyoon");

		UserVO user2 = new UserVO();
		user2.setId("jiyoon");
		user2.password("jiyoon");
		
		try {
			service.saveUsers(user1, user2);
			System.out.println("TRANSACTION 처리 완료");
		} catch (Exception e) {
			System.out.println("예외 발생! " + e);
		}
	}

}
