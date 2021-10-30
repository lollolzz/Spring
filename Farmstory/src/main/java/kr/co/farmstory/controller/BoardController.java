package kr.co.farmstory.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.farmstory.service.BoardService;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;


@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board/list")
	
	public String list(Model model, String group, String cate, String pg) {
		
		int currentPage  = service.getPageCurrentPage(pg);
		int start 	     = service.getLimitStart(currentPage);
		int total 		 = service.selectCountTotal(cate);
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum  = service.getLastPageNum(total);
		int groups[] 	 = service.getPageGroup(currentPage, lastPageNum);

		List<ArticleVo> articles = service.selectArticles(cate, start);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		model.addAttribute("articles", articles);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("groups", groups);

		return "/board/list";
	}
	
	@GetMapping("/board/write")
	public String write(String group, String cate, Model model) {
		
		model.addAttribute("group", group);
		model.addAttribute("cate",cate);
		
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String write(HttpServletRequest req, ArticleVo vo, String group, String cate, Model model) {
		
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		
		// 작성글 insert
		
		int seq = 0;
		
		if(vo.getFname().isEmpty()) {
			
			// 파일을 첨부안했을때
			vo.setFile(0);
			seq = service.insertArticle(vo);
			System.out.println("파일 첨부 안함");
		}else {
			
			// 파일을 첨부했을 때
			vo.setFile(1);
			seq = service.insertArticle(vo);
			FileVo fvo = service.fileUpload(vo.getFname(), seq);
			service.insertFile(fvo);
		}

		model.addAttribute("group", group);
		model.addAttribute("cate",cate);
		
		return "redirect:/board/list?group="+group+"&cate="+cate;
	}
	
	@GetMapping("/fileDownload")
	public void fileDownload(int fseq, HttpServletResponse resp) {
		
		// 다운로드 카운트 +1
		service.updateFileDownload(fseq);
		// 파일 정보 가져오기
		FileVo fileVo = service.selectFile(fseq);
		// 파일 다운로드 수행
		service.fileDownload(resp, fileVo);
		
	}

	@GetMapping("/board/view")
	public String view(Model model, String group, String cate, int seq) {

		ArticleVo vo = service.selectArticle(seq);
		List<ArticleVo> comments = service.selectComments(seq);
		
		model.addAttribute(vo);
		model.addAttribute("comments", comments);
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);

		return "/board/view";
	}
	
	@GetMapping("/board/modify")
	public String modify(Model model, String group, String cate, int seq) {
		
		ArticleVo vo = service.selectArticle(seq);
		model.addAttribute(vo);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);

		return "/board/modify";
	}
	@PostMapping("/board/modify")
	public String modify(ArticleVo vo, String group, String cate, Model model) {
		
		
		int seq = vo.getSeq();
		service.updateArticle(vo);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		if(vo.getFname().isEmpty()) {
			// 파일 첨부 안했을 때
			vo.setFile(0);
			service.insertArticle(vo);
			System.out.println("파일 첨부안함");
		}else {
			// 파일 첨부 했을 때
			vo.setFile(1);
			seq = service.insertArticle(vo);
			FileVo fvo = service.fileUpload(vo.getFname(), seq);
			service.insertFile(fvo);
		}
		
		return "redirect:/board/view?group="+group+"&cate="+cate+"&seq="+vo.getSeq();
		
	}
	
	@GetMapping("/board/delete")
	public String delete(int seq,String group,String cate, Model model) {
		
		service.deleteArticle(seq);
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "redirect:/board/list?group="+group+"&cate="+cate;
	}
	
	@PostMapping("/board/insertComment")
	public String insertComment(ArticleVo vo, String group, String cate, Model model) {
		
		service.insertComment(vo);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "redirect:/board/view?group="+group+"&cate="+cate+"&seq="+vo.getParent();
		
	}
	
	@GetMapping("/board/deleteComment")
	public String deleteComment(Model model, String cate, String group, int seq, ArticleVo vo) {
		
		service.deleteComment(seq);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
	
		
		return "redirect:/board/view?group="+group+"&cate="+cate+"&seq="+vo.getParent();
	}
	@GetMapping("/board/modifyComment")
	public String updateComment(String group, String cate, Model model, int seq) {
		
		ArticleVo vo = service.selectComment(seq);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "/board/view";
		
	}
	@PostMapping("/board/modifyComment")
	public String modifyComment(ArticleVo vo, String group, String cate, Model model, int seq) {
		
		service.updateComment(seq);
		
		model.addAttribute("group", group);
		model.addAttribute("cate", cate);
		
		return "redirect:/board/view?group="+group+"&cate="+cate+"&seq="+vo.getParent();
		
	}

}	
	
