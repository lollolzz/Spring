package kr.co.sboard.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleVo {
	
	private int seq;
	private int parent;
	private int commnet;
	private String cate;
	private String title;
	private String content;
	private int file;
	private int hit;
	private String uid;
	private String regip;
	private String rdaet;
	
	// 추가필드
	private MultipartFile fname;
	private String nick;
	private FileVo fileVo;
	

}
