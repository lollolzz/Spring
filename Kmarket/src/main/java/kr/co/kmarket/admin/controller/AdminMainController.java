package kr.co.kmarket.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminMainController {

	@GetMapping(value = {"/admin", "/admin/index"})
	public String index(Model model) {
		
		return "/admin/index";
	}
}
