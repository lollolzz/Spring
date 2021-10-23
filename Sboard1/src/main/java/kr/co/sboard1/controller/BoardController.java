package kr.co.sboard1.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sboard1.servicd.BoardService;
import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;
import kr.co.sboard1.vo.MemberVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping(value= {"/", "/index"})
	public String index(HttpSession sess) {
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo == null) {
			return "foward:/member/login";
			
		}else {
			return "foward:/list";
		}
		
	}
	
	@GetMapping("/list")
	public String list(String pg, Model model) {
		
		int currentPage = service.getPageCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal();
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<ArticleVo> articles = service.selectArticles(start);
		
		model.addAttribute("articles", articles);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("groups", groups);

		
		return "/list";
	}
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest req, ArticleVo vo) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		// 작성글 insert
		int seq = 0;
		
		if(vo.getFname().isEmpty()) {
			//파일 첨부안했을때
			vo.setFile(0);
			seq = service.insertArticle(vo);
			System.out.println("파일 첨부 안함");
		}else {
			//파일을 첨부했을때
			vo.setFile(1);
			seq = service.insertArticle(vo);
			FileVo fvo = service.fileUpload(vo.getFname(), seq);
			service.insertFile(fvo);
		}
		
		System.out.println("파일첨부 완료../...");
		
		return "redirect:/list";
	}
	
	@GetMapping("/fileDownload")
	public void fileDownload(int fseq, HttpServletResponse resp) {
		// 다운로드 카운트 + 1
		service.updateFileDownload(fseq);
		// 파일 정보가져오기
		FileVo fileVo = service.selectFile(fseq);
		// 파일 다운로드 수행
		service.fileDownload(resp, fileVo);
	}
	
	@GetMapping("/modify")
	public String modify (int seq, Model model) {
		
		ArticleVo vo = service.selectArticle(seq);
		model.addAttribute(vo); 
		
		return "/modify";
	}
	
	@PostMapping("/modify")
	public String modify(ArticleVo vo) {
		
		service.updateArticle(vo);
		if(vo.getFname().isEmpty()) {
			// 파일 첨부안했을 때
			vo.setFile(0);
			service.insertArticle(vo);
			System.out.println("파일 첨부 안함");
		}else {
			// 파일 첨부 했을 때
			vo.setFile(1);
			int seq = vo.getSeq();
			seq = service.insertArticle(vo);
			FileVo fvo = service.fileUpload(vo.getFname(), seq);
			service.insertFile(fvo);
		}
		return "redirect:/view?seq="+vo.getSeq();
	}
	
	@PostMapping("/comment")
	public String comment(ArticleVo vo) {
		service.insertComment(vo);
		return "redirect:/view?seq="+vo.getParent();
	}
	
	
	

}
