package kr.co.farmstory1.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
	
	@ResponseBody
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) {
		
		int result = service.selectCountUid(uid);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/member/checkNick")
	public String checkNick(String nick) {
		
		int result = service.selectCountNick(nick);
		
		//Json 객체 생성 후 클라이언트 전송 
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/member/checkEmail")
	public String checkEmail(String email) {
		
		int result = service.selectCountEmail(email);
		
		//Json 객체 생성 후 클라이언트 전송 
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/member/checkHp")
	public String checkHp(String hp) {
		
		int result = service.selectCountHp(hp);
		
		//Json 객체 생성 후 클라이언트 전송 
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
	
}
