package kr.co.sboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.sboard.service.MemberService;
import kr.co.sboard.vo.MemberVo;
import kr.co.sboard.vo.TermsVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;
	
	
	@GetMapping("/member/login")
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
		  // 회원이 맞을경우
		  sess.setAttribute("sessMember", vo);
		  return "redirect:/list";
		  
	  }
	}
	
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		// 현재 사용자 정보객체 세션 삭제
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
		/*rdate도 vo에서 getter, setter하고 
		 * mapping에서 쿼리 는 써주지만 왜 컨트롤러에서 
		 * regip처럼 아무것도 해주지 않는거지 ?
		 * 그건 쿼리에서 now를 써서 자동으로 받아와주기 때문이라고 생각*/
		service.insertMember(vo);
		
		return "redirect:/member/login?success=101";
	}
	
	@ResponseBody /* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송 */
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) {
		//System.out.println("uid : "+uid);
		int result = service.selectCountUid(uid);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
	@ResponseBody /* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송 */
	@GetMapping("/member/checkNick")
	public String checKNick(String nick) {
		
		int result = service.selectCountNick(nick);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	@ResponseBody /* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송 */
	@GetMapping("/member/checkEmail")
	public String checKEmail(String email) {
		
		int result = service.selectCountEmail(email);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	@ResponseBody /* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송 */
	@GetMapping("/member/checkHp")
	public String checkHp(String hp) {
		
		int result = service.selectCountHp(hp);
		
		// Json 객체 생성 후 클라이언트 전송
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	

	
}
