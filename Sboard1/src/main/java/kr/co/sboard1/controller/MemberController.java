package kr.co.sboard1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard1.service.MemberService;
import kr.co.sboard1.vo.MemberVo;
import kr.co.sboard1.vo.TermsVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	@GetMapping("/member/loign")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
		MemberVo vo = service.selectMember(uid, pass);
		
		if(vo == null) {
			// 회원이 아닐경우
			return "redirect:/member/login?success=100";
		}else {
			// 회원이 맞을 경우 
			sess.setAttribute("sessMember", vo);
			return "redirect:/list";
		}
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		// 현재 사용자 정보객체 세션 삭제 ,, 내장 객체 
		sess.invalidate();
		return "redirect:/member/login?success=102";
	}
	
	@GetMapping("/member/terms")
	public String terms(Model model) {
		
		TermsVo vo = service.selectTerms();
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
		
		return "redirect:/member/login?success=101";
	}
	

	
	
}
