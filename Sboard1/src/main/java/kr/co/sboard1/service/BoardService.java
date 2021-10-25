package kr.co.sboard1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard1.dao.BoardDao;
import kr.co.sboard1.vo.ArticleVo;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public void insertArticle() {}
	public void selectArticle() {}
	public List<ArticleVo> selectAriticles(int start) {
		return dao.selectArticles(start);
	}
	public void updateArticle() {}
	public void deleteArticle() {}
}
