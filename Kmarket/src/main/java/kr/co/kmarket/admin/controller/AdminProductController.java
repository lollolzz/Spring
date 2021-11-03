package kr.co.kmarket.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.admin.service.AdminProductService;
import kr.co.kmarket.vo.ProductCate1Vo;
import kr.co.kmarket.vo.ProductCate2Vo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	@GetMapping("/admin/product/list")
	public String list() {
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
	@PostMapping("/admin/product/register")
	public String register(ProductVo vo, HttpServletRequest req) {
		
		vo.setIp(req.getRemoteAddr());
		
		//썸네일 이미지 업로드 
		// vo에 thum시리즈가 유니버셜 아이디로 저장 되어있는것이 controller로 가져와져서
		// 실행되어진다
		vo = service.fileUpload(vo);
		
		// 상품정보 Insert
		service.insertProduct(vo);
		
		return "/admin/product/register";
	}
	
	@ResponseBody
	@GetMapping("/admin/product/getCate1")
	public List<ProductCate1Vo> getCate1() {
		
		List<ProductCate1Vo> cate1s = service.selectCate1();
		
		return cate1s;
	}
	/* /admin/product/register 페이지에서 ajax통신을 사용했지만 왜 controller에서 
	 json방식으로 다시 register페이지로 넘겨주지 않고 return cate1s 이렇게 넘겨 주었을까 >?
	 -> List객체는 구체(?)이기 때문에 key와 value값이 이미 내부적으로 설정되어져 있기 때문에,,, 
	 @ResponseBody를 사용해서 json을 통해 넘겨주지 않고도 정상적으로 값이 return 되어진다
	 
	 만약 List객체가 아니라 int형(값이 0과 1로 받아지는 것)일때는 원레아는 방식인 json을 사용하여 return 리턴 시켜 준다 
	*/
	@ResponseBody
	@GetMapping("/admin/product/getCate2")
	public List<ProductCate2Vo> getCate2(int cate1) {
		
		List<ProductCate2Vo> cate2s = service.selectCate2(cate1);
		
		return cate2s;
		
	}

}
