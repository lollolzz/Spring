package kr.co.farmstory1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class BoardController {
	

	@GetMapping("/board/list")
	public String list(String group, String cate, Model model) {
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "/board/list";
	}
	
	@GetMapping("/board/view")
	public String view() {
		return "/board/view";
	}
	@GetMapping("/board/write")
	public String write() {
		return "/board/write";
	}
	@GetMapping("/board/modify")
	public String modify() {
		return "/board/modify";
	}

}
