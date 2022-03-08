package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
// 사용자가 요청 -> 응답 (Data)

//  사용자가 요청 -> 응답 (HTML 파일 ) -> @Controller 
public class HttpControlloerTest {
	
	
	// http://localhost:8080/http/get(select)
	@GetMapping("/http/get")
	public String getTest() {
//		return type은 문자열이다 
		return "get 요청";
	}
	// 인터넷 브라우저 요청은 무조건 get요청 뿐이 되지 않는다!!!
	// 나머지는postman을 사용해서 확인해보자 
	// http://localhost:8080/http/post(insert)
	@PostMapping("/http/post")
	public String postTest() {
		return "post 요청";
	}
	
	// http://localhost:8080/http/put(update)
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	
	// http://localhost:8080/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
