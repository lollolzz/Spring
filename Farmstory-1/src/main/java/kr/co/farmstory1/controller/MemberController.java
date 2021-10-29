package kr.co.farmstory1.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.farmstory1.service.MemberService;
import kr.co.farmstory1.vo.MemberVo;
import kr.co.farmstory1.vo.TermsVo;


@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@GetMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVo vo =service.selectTerms();
		model.addAttribute(vo);
		
		return "/member/terms";
	}
	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}
	
	@PostMapping("/member/register")
	public String register(MemberVo vo, HttpServletRequest req) {
	
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		service.insertMember(vo);
		
		return "redirect:/member/login";
	}
	
	
}
