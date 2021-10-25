package kr.co.sboard1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.ArticleVo;

@Repository
public interface BoardDao {
	
	public void insertArticle();
	public void selectArticle();
	public List<ArticleVo> selectArticles(int start);
	public void updateArticle();
	public void deleteArticle();
	
}
