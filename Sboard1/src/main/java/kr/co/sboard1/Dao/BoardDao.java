package kr.co.sboard1.Dao;

import java.util.List;

import kr.co.sboard1.vo.ArticleVo;
import kr.co.sboard1.vo.FileVo;

public interface BoardDao {
	

	public int insertArticle(ArticleVo vo);
	
	public void insertFile(FileVo vo);
	
	public ArticleVo selectArticle(int seq);
	
	public List<ArticleVo> selectArticles(int start);
	
	public int selectCountTotal();
	
	public FileVo selectFile(int fseq);
	
	public List<ArticleVo> selectComments(int seq);
	
	
	public int updateArticle(ArticleVo vo);	 //int seq 글번호로 삭제 및 업데이트
	
	public void updateFileDownload(int fseq);
	
	public void deleteArticle(int seq);
	
	public void insertComment(ArticleVo vo);
	

}
