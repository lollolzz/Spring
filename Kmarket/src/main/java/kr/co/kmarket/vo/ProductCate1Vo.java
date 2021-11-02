package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class ProductCate1Vo {

	private String cate1;
	private String title;
	public String getCate1() {
		return cate1;
	}
	public void setCate1(String cate1) {
		this.cate1 = cate1;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
