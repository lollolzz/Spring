package kr.co.sboard.Dao;

import java.util.List;

import kr.co.sboard.vo.ArticleVo;
import kr.co.sboard.vo.FileVo;

public interface BoardDao {
	

	public int insertArticle(ArticleVo vo);
	public void insertFile(FileVo vo);
	public void selectArticle();
	public List<ArticleVo> selectArticles(int start);
	public int selectCountTotal();
	
	public FileVo selectFile(int fseq);
	
	public void updateFileDownload(int fseq);

	public void updateArticle();
	public void deleteArticle();
	

}
