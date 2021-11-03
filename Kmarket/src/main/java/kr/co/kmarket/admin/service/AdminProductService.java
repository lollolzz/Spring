package kr.co.kmarket.admin.service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kmarket.admin.dao.AdminProductDao;
import kr.co.kmarket.vo.ProductCate1Vo;
import kr.co.kmarket.vo.ProductCate2Vo;
import kr.co.kmarket.vo.ProductVo;


@Service
public class AdminProductService {
	
	@Autowired
	private AdminProductDao dao;
	
	public void insertProduct(ProductVo vo) {
		dao.insertProduct(vo);
	}
	public void selectProduct() {}
	public void selectProducts() {}
	public void updateProduct() {}
	public void deleteProduct() {}
	
	public List<ProductCate1Vo> selectCate1() {
		return dao.selectCate1();
	}
	public List<ProductCate2Vo> selectCate2(int cate1) {
		return dao.selectCate2(cate1);
	}
	
	// 비지니스 처리 로직 구현 메서드//
	
		// 파일 업로드
		public ProductVo fileUpload(ProductVo vo) {
			
			File file = new File("src/main/resources/static/thumb");
		    String path = file.getAbsolutePath();

		    int i = 0;
		    
		    // 썸네일을 하나만 혹은 두개만 이런 식으로 출력할 수 있기 때문에 for문을 사용하여 준다
		    for(MultipartFile mf : vo.getFiles()) {
		    	
		    	if(!mf.isEmpty()) {
		    		// 썸네일 이미지 파일을 첨부했을 경우
		    		
		    		 /* 여러 클라이언트가 같은 이름으로 파일을 업로드 할 수 있기 때문에
				        중복되는것을 막기위하여 구분해주기 위한것*/
				    String name = mf.getOriginalFilename();
				    String ext = name.substring(name.lastIndexOf("."));

				    /* 절대로 겹칠 수 없는 난수를 만들어서 중복 이름 파일들을 구분하여 준다*/
				    String uName = UUID.randomUUID().toString()+ext;
				    String fullPath = path+"/"+vo.getCate1()+"/"+vo.getCate2()+"/";

		    	try{
		    		// 디렉터리 생성 
		    		Path root = Paths.get(fullPath);
		    		Files.createDirectories(root);
			    	
		    		// 첨부파일 저장
				    mf.transferTo(new File(fullPath+uName));
				    
				    // 새로운 이름 
				    if(i==0) vo.setThumb1(uName);
				    if(i==1) vo.setThumb2(uName);
				    if(i==2) vo.setThumb3(uName);
				    if(i==3) vo.setDetail(uName);
				    
			    }catch (Exception e) {
					e.printStackTrace();
				}
		    } // if end
		   
		    i++;
		    
	    } // for end
		    
		return vo;
		
	}// fileUpload end

}
