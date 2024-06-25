package org.tukorea.free.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.free.domain.ScheduleVO;
import org.tukorea.free.domain.UserVO;
import org.tukorea.free.dto.GptScheduleRequest;
import org.tukorea.free.service.ScheduleService;

@Controller
@RequestMapping("schedules")
public class ScheduleController {

	@Autowired
	private ScheduleService service;

	@PostMapping("/create")
	public String sendQuestion(Model model, GptScheduleRequest gptScheduleRequest, HttpSession session) {

		ScheduleVO schedule = service.askQuestion(gptScheduleRequest);
		UserVO user = (UserVO) session.getAttribute("user");
		schedule.setUserId(user.getId());
		service.saveSchedule(schedule);
		model.addAttribute("schedule", schedule);
		return "schedule";

	}

	@GetMapping("/home")
	public String home() {
		return "create";
	}

	@GetMapping("/list")
	public String list(Model model, HttpSession session) {
		List<ScheduleVO> schedules = service.readAll();
		UserVO user = (UserVO) session.getAttribute("user");

		model.addAttribute("schedules", schedules);
		model.addAttribute("userId", user.getId());
		return "list";
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable("id") int id, Model model, HttpSession session) {
		ScheduleVO schedule = service.readById(id);
		UserVO user = (UserVO) session.getAttribute("user");
		model.addAttribute("userId", user.getId());
		model.addAttribute("schedule", schedule);
		return "detail";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		service.delete(id);
		return "redirect:/schedules/list";
	}

	@GetMapping("/edit/{id}")
	public String modifyMemberGet(@PathVariable("id") int id, Model model) throws Exception {
		ScheduleVO schedule = service.readById(id);
		model.addAttribute("schedule", schedule);
		return "modify";
	}

	@PostMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, @ModelAttribute ScheduleVO schedule,
			@RequestParam List<String> detailList) {
		schedule.setDetailList(detailList);
		service.update(schedule);

		return "redirect:/schedules/detail/" + schedule.getId();
	}
}
