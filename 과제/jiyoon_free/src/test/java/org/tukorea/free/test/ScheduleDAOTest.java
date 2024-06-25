package org.tukorea.free.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.free.config.JavaConfig;
import org.tukorea.free.domain.ScheduleVO;
import org.tukorea.free.persistence.ScheduleDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JavaConfig.class })
public class ScheduleDAOTest {

	@Autowired
	private ScheduleDAO dao;
	private static Logger logger = LoggerFactory.getLogger(UserDAOTest.class);

	@Test
	public void testReadList() throws Exception {
		List<ScheduleVO> schedules = new ArrayList<>();
		schedules = dao.readList();

		logger.info(String.valueOf(schedules.size()));
	}
}
