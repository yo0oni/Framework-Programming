package org.tukorea.myweb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.myweb.domain.StudentVO;
import org.tukorea.myweb.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired(required = true)
	private MemberService memberService;

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public String listMember(Model model) throws Exception {
		List<StudentVO> students = memberService.readMemberList();
		logger.info(" /member/list URL called. then listMemebr method executed.");
		model.addAttribute("students", students);
		return "member/member_list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readMember(@RequestParam("id") String id, Model model) throws Exception {
		StudentVO student = memberService.readMember(id);
		logger.info(" /read?id=kang URL called. then readMemebr method executed.");
		model.addAttribute("student", student);
		return "member/member_read";
	}
}