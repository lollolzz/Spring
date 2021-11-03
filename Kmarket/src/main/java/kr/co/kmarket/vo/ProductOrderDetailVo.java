package kr.co.kmarket.vo;

import lombok.Data;

@Data
public class ProductOrderDetailVo {
	
	private int seq;
	private int orderId;
	private int productCode;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	
	

}
