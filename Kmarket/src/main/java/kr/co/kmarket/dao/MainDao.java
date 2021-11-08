package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Repository
public interface MainDao {
	
	// service페이지에서 return 받은 값을 mapping 시켜주기 위하여 mappers에서 resultType으로 설정해주는 것이다
	public List<CategoriesVo>selectCategories();
	public List<ProductVo> selectMainProduct(String order);
	// order은 mapper의 조건문에서 사용된다!

}
