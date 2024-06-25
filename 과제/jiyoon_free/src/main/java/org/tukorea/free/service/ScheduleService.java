package org.tukorea.free.service;

import java.util.List;

import org.tukorea.free.domain.ScheduleVO;
import org.tukorea.free.dto.GptScheduleRequest;

public interface ScheduleService {

	void saveSchedule(ScheduleVO schedule);

	List<ScheduleVO> readAll();

	ScheduleVO readById(int id);

	List<ScheduleVO> readMySchedule(String userId);

	void delete(int id);

	void update(ScheduleVO schedule);

	ScheduleVO askQuestion(GptScheduleRequest questionRequestDTO);
}
