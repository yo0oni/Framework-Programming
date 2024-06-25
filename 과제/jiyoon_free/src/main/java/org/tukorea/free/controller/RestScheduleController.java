package org.tukorea.free.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tukorea.free.domain.ScheduleVO;
import org.tukorea.free.dto.GptScheduleRequest;
import org.tukorea.free.service.ScheduleService;

@RestController
@RequestMapping("rest/schedules")
public class RestScheduleController {

	@Autowired
	private ScheduleService service;

	@GetMapping("list")
	public ResponseEntity<List<ScheduleVO>> getAllSchedules() {
		List<ScheduleVO> schedules = service.readAll();
		return ResponseEntity.ok(schedules);

	}
	
	@PostMapping("create")
	public ScheduleVO create(@RequestBody GptScheduleRequest request) {
		return service.askQuestion(request);

	}
}