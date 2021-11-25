package kr.co.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.ajax.service.ProductCartService;
import kr.co.ajax.vo.MemberVo;
import kr.co.ajax.vo.ProductCartVo;
import kr.co.ajax.vo.ProductVo;


@Controller
public class ProductController {	
	
	
	@Autowired
	private ProductCartService cartService;

	@GetMapping("/product/cart")
	public String cart(HttpSession sess, String uid, Model model) {
		
		// 로그인 여부확인
		MemberVo vo = (MemberVo) sess.getAttribute("sessMember");
		
		if(vo != null) {
			
			List<ProductVo> cartProducts = cartService.selectCarts(uid);
					
			model.addAttribute("cartProducts", cartProducts);
			
			return "/product/cart";
			
		}else {
			
			return "redirect:/member/login";
		}

	}

	@ResponseBody
	@PostMapping("/product/cart")
	public String cart(ProductCartVo vo) {
		
		int result = cartService.selectCountCart(vo);
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		
		return new Gson().toJson(json);
	}
	
//	@ResponseBody
//	@GetMapping("/product/cartDelete")
//	public String cartDelete(int[] cartIds) {
//		
//		int result = cartService.deleteCart(cartIds);
//		
//		JsonObject json = new JsonObject();
//		json.addProperty("result", result);
//		
//		return new Gson().toJson(json);
//	}
	
	@GetMapping("/product/list")
	public String list() {
		return "/product/list";
	}
	
	@GetMapping("/product/payment")
	public String payment() {
		return "/product/payment";
	}
	
	@GetMapping("/product/view")
	public String view() {
		return "/product/view";
	}
	
	@GetMapping("/product/delivery")
	public String delivery() {
		return "/product/delivery";
	}
	
	
	
	
}
