package org.tukorea.free.persistence;

import java.util.List;

import org.tukorea.free.domain.ScheduleVO;

public interface ScheduleDAO {

	void saveSchedule(ScheduleVO schedule);

	List<ScheduleVO> readList();

	ScheduleVO selectById(int id);

	List<ScheduleVO> selectByUserId(String userId);

	void delete(int id);

	void update(ScheduleVO schedule);
}
