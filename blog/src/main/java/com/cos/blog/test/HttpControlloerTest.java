package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
// 사용자가 요청 -> 응답 (Data)

//  사용자가 요청 -> 응답 (HTML 파일 ) -> @Controller 
public class HttpControlloerTest {
	
	private static final String TAG = "HttpControlloerTest :";
	// mac에 lombok이 안되는 건가 그냥 내가 못 하는건가....
	//localhost:8000/blog/http/lombok
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = new Member(1, "lychland", "1234", "email" );
		System.out.println(TAG+"getter :" + m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG+"setter : "+m.getUsername());
		return "lombok test완료";
	}
	
	
	// http://localhost:8080/http/get(select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		// id=1&username=ssar&password=1234&email=ssar@nate.com 이 값을 Member에 넣어준다  // MessageConverter (스프링부트)
		//return type은 문자열이다 
		
		return "get 요청: " + m.getId()+" , "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
		
	}
	
	// 인터넷 브라우저 요청은 무조건 get요청 뿐이 되지 않는다!!!
	// 나머지는postman을 사용해서 확인해보자 
	// http://localhost:8080/http/post(insert) / 데이터를 추가 해라 
	@PostMapping("/http/post") // text/plain, application/json 
	public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)
		return "post 요청 :  " + m.getId()+" , "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 :" + m.getId()+" , "+m.getUsername()+", "+m.getPassword()+", "+m.getEmail();
	}
	
	// http://localhost:8080/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}

}
