package kr.co.ajax.vo;

import lombok.Data;

@Data
public class SearchVo {
	private String keyword;
	private int chk1 = 1;
	private int chk2;
	
	//추가필드 I
	private int start;
	private int total;
	private int count;
	private int order = 1;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getChk1() {
		return chk1;
	}
	public void setChk1(int chk1) {
		this.chk1 = chk1;
	}
	public int getChk2() {
		return chk2;
	}
	public void setChk2(int chk2) {
		this.chk2 = chk2;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	
}
