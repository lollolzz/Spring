package kr.co.kmarket.vo;

import java.util.List;

public class CategoriesVo {
	
	private int cate1;
	private String tit1;
	private List<ProductCate2Vo> cate2List;
	
	
	public int getCate1() {
		return cate1;
	}
	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}
	public String getTit1() {
		return tit1;
	}
	public void setTit1(String tit1) {
		this.tit1 = tit1;
	}
	public List<ProductCate2Vo> getCate2List() {
		return cate2List;
	}
	public void setCate2List(List<ProductCate2Vo> cate2List) {
		this.cate2List = cate2List;
	}

}
