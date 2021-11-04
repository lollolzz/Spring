package kr.co.kmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kmarket.dao.MainDao;
import kr.co.kmarket.vo.CategoriesVo;

@Service
public class MainService {
	
	@Autowired
	private MainDao dao;
	
	// CategoriesVo를 List화 한 객체를 selectCategoreis에 담고 이것을 dao로 리턴
	public List<CategoriesVo> selectCategories() {
		return dao.selectCategories();
		
	}

}
