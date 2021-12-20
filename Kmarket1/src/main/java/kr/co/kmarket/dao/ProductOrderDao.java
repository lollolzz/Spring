package kr.co.kmarket.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.ProductOrderVo;

@Repository
public interface ProductOrderDao {

	public void insertOrder(ProductOrderVo vo);
	// insert에서 맵핑한 값이 int로 받아져 오는 
	public void insertOrderDetail(int orderId, int productCode, int count);
	
	public List<ProductOrderVo> selectOrders(int orderId);
	public void selectOrder();
	public int updateOrder(ProductOrderVo vo);
	public void deleteOrder();
}
