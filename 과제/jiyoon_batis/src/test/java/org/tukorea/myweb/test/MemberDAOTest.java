package org.tukorea.myweb.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.tukorea.myweb.domain.StudentVO;
import org.tukorea.myweb.persistence.MemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MemberDAOTest {

	@Autowired
	private MemberDAO dao;
	private static Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	@Test
	public void testReadByid() throws Exception {
		StudentVO vo;
		vo = dao.read("hansol");

		logger.info(vo.toString());
	}
	
	@Test
	public void testReadList() throws Exception {
		List<StudentVO> voList;
		voList = dao.readList();

		for(StudentVO svo : voList) {
			logger.info(svo.toString());
		}
	}
	
	@Test
	public void testAddStudent() throws Exception {
		StudentVO vo = new StudentVO();
		vo.setId("asdf");
		vo.setSnum("1234");
		vo.setUsername("frame");
		vo.setPasswd("1234");
		dao.add(vo);
		
		logger.info(dao.read(vo.getId()).toString());
	}
	
	@Test
	public void testModifyStudent() throws Exception {
		StudentVO vo = new StudentVO();
		vo.setId("work");
		vo.setSnum("123");
		vo.setUsername("work");
		vo.setPasswd("123");
		dao.add(vo);
		
		logger.info(dao.read(vo.getId()).toString());
		vo.setSnum("2020312009");
		logger.info(dao.read(vo.getId()).toString());
	}
}
