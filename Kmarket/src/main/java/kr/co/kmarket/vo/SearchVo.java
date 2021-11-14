package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class SearchVo {
	private String keyword;
	private int chk1 = 1;
	private int chk2;
	private int chk3;
	private int min;
	private int max;
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
	public int getChk3() {
		return chk3;
	}
	public void setChk3(int chk3) {
		this.chk3 = chk3;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	
	
	
}
