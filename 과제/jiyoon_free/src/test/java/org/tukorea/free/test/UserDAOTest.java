package org.tukorea.free.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.tukorea.free.config.JavaConfig;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.persistence.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JavaConfig.class})
public class UserDAOTest {

	@Autowired
	private UserDAO dao;
	private static Logger logger = LoggerFactory.getLogger(UserDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		UserVO vo;
		vo = dao.readById("1");

		logger.info(vo.toString());
	}
}
