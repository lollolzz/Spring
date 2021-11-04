package kr.co.farmstory1.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.farmstory1.dao.MemberDao;
import kr.co.farmstory1.vo.MemberVo;
import kr.co.farmstory1.vo.TermsVo;


@Service
public class MemberService {

	@Autowired
	private MemberDao dao;

	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	public MemberVo selectMember(String uid, String pass) {
		 return dao.selectMember(uid,pass);
	}
	public void selectMembers() {}
	
	public TermsVo selectTerms() {
		return dao.selectTerms();
	}
	
	public void updateMember() {}
	public void deleteMember() {}
	
	public int selectCountUid(String uid) {
		
		return dao.selectCountUid(uid);
	}
	
	public int selectCountNick(String nick) {
		
		return dao.selectCountNick(nick);
	}
	
	public int selectCountEmail(String email) {
		
		return dao.selectCountEmail(email);
	}
	
	public int selectCountHp(String hp) {
		
		return dao.selectCountHp(hp);
	}


}
