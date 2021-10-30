package kr.co.farmstory.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.farmstory.dao.BoardDao;
import kr.co.farmstory.vo.ArticleVo;
import kr.co.farmstory.vo.FileVo;


@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	// dao 구현 메서드 
	public int insertArticle(ArticleVo vo) {
		dao.insertArticle(vo);
		return vo.getSeq();
	}
	
	public void insertFile(FileVo vo) {
		dao.insertFile(vo);
	}
	
	public void insertComment(ArticleVo vo) {
		dao.insertComment(vo);
	}
	
	public List<ArticleVo> selectComments(int seq) {
		return dao.selectComments(seq);
	}
	public ArticleVo selectComment(int seq) {
		return dao.selectComment(seq);
	}
	
	public ArticleVo selectArticle(int seq) {
		return dao.selectArticle(seq);
	}
	
	public List<ArticleVo> selectArticles(String cate, int start) {
		return dao.selectArticles(cate, start);
	}
	
	public FileVo selectFile(int fseq) {
		return dao.selectFile(fseq);
	}
	
	public int selectCountTotal(String cate) {
		return dao.selectCountTotal(cate);
	}
	
	public void updateArticle(ArticleVo vo) {
		dao.updateArticle(vo);
		}
	
	public void updateFileDownload(int fseq) {
		dao.updateFileDownload(fseq);
	}
	public void updateComment(int seq) {
		dao.updateComment(seq);
	}
	
	public void deleteArticle(int seq) {
		dao.deleteArticle(seq);
	}
	
	public void deleteComment(int seq) {
		dao.deleteComment(seq);
	}
	
	public int completeComment(int seq) {
		return dao.completeComment(seq);
	}

	// 비지니스 처리 로직 구현 메서드//
	
	// 파일 업로드
	public FileVo fileUpload(MultipartFile fname, int seq ) {
		
		File file = new File("src/main/resources/static/file");
	    String path = file.getAbsolutePath();

	    /* 여러 클라이언트가 같은 이름으로 파일을 업로드 할 수 있기 때문에
	     * 중복되는것을 막기위하여 구분해주기 위한것*/
	    String name = fname.getOriginalFilename();
	    String ext = name.substring(name.lastIndexOf("."));

		
	    /* 절대로 겹칠 수 없는 난수를 만들어서 중복 이름 파일들을 구분하여 준다*/
	    String uName = UUID.randomUUID().toString()+ext;
	    
	    FileVo fvo = null;

	    try{
	    	// 첨부파일 저장
		    fname.transferTo(new File(path+"/"+uName));
		    
			// 첨부파일 정보객체 생성
 			fvo = new FileVo();
 			fvo.setParent(seq);
 			fvo.setOriName(name);
 			fvo.setNewName(uName);

		    
	    }catch (Exception e) {
			e.printStackTrace();
		}
	    
	    return fvo;
	}

	// 파일 다운로드
	public void fileDownload(HttpServletResponse resp, FileVo fileVo) {
			File file = new File("src/main/resources/static/file/");
			String path = file.getAbsolutePath()+"/"+fileVo.getNewName();
			
			try {
				byte[] fileByte = FileUtils.readFileToByteArray(new File(path));
				
				// 파일 다운로드 response 헤더수정
				resp.setContentType("application/octet-stream");
				resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileVo.getOriName(), "utf-8"));
				resp.setHeader("Content-Transfer-Encoding", "binary");
				resp.setHeader("Pragma", "no-cache");
				resp.setHeader("Cache-Control", "private");
				
				resp.getOutputStream().write(fileByte);
				resp.getOutputStream().flush();
				resp.getOutputStream().close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	// 페이지 리스트 시작번호
	public int getPageStartNum(int total, int start) {
		return total - start;
	}
	
	// 페이지 현재 그룹번호
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		int groupCurrent = (int)Math.ceil(currentPage / 10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1 ;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		int[]groups = {groupStart, groupEnd};
		
		return groups;
	}
	
	// 현재 리스트 페이지 번호
	public int getPageCurrentPage(String pg) {
		int currentPage = 1;
		
		if(pg != null) {
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
	}
	
	// 현재 리스트 SQL start번호
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
		
	}
	
	// 리스트 마지막 페이지 번호
	public int getLastPageNum(int total) {
		int lastPageNum = 0;
		if(total % 10 == 0) {
				lastPageNum = total / 10;
		}else {
			lastPageNum = total / 10 +1;
		}
		return lastPageNum;
	}
	
}
	
