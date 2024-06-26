package org.tukorea.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tukorea.web.domain.StudentVO;
import org.tukorea.web.service.MemberService;

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

	@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
	public String createMemberGet() throws Exception {
		logger.info(" /register URL GET method called. then forward member_register.jsp.");
		return "member/member_register";
	}

	@RequestMapping(value = { "/register" }, method = RequestMethod.POST)
	public String createMemberPost(@ModelAttribute("student") StudentVO vo) throws Exception {
		memberService.addMember(vo);
		logger.info(vo.toString());
		logger.info(" /register URL POST method called. then createMember method executed.");
		return "redirect:/member/list";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyMemberGet(@RequestParam("id") String id, Model model) throws Exception {
		StudentVO student = memberService.readMember(id);
		logger.info(" /modify?id=kang URL GET method called. then forward member_modify.jsp.");
		model.addAttribute("student", student);
		return "member/member_modify";
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyMemberPost(@ModelAttribute("student") StudentVO vo) throws Exception {
		memberService.updateMember(vo);
		logger.info(vo.toString());
		logger.info(" /modify?id=kang URL POST method called. then modifyMemberPost executed.");
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String modifyMemberPost(@RequestParam("id") String id) throws Exception {
		memberService.deleteMember(id);
		logger.info(id);
		return "redirect:/member/list";
	}
	
}