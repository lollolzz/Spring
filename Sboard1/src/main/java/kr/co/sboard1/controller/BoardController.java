package kr.co.sboard1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sboard1.service.BoardService;
import kr.co.sboard1.vo.MemberVo;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping(value= {"/", "/index"})
	public String index(HttpSession sess) {
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo == null) {
			return "forward:/member/login";
			
		}else {
			return "forward:/list";
		}
	}
	
	@GetMapping("list")
	public String list(String pg, Model model) {
		
		int currentPage 	=service.getPageCurrentPage(pg);
		int start 			=service.getLimitStart(currentPage);
		int total			=service.selectCountTotal();
		int pageStartNum	=service.getPageStartNum(total, start);
		int lastPageNum		=service.getLastPageNum(total);
		int groups[]		=service.getPageGroup(currentPage, lastPageNum);
		
		List<AritcleVo> articles = service.selectArticles(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("groups", groups);
		
		return "/list";
	};
	
	@GetMapping("modify")
	public void modify() {};
	
	@GetMapping("write")
	public void write() {};
	
	@GetMapping("veiw")
	public void view() {};
	
}
