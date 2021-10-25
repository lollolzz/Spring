package kr.co.sboard1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sboard1.dao.MemberDao;
import kr.co.sboard1.vo.MemberVo;
import kr.co.sboard1.vo.TermsVo;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;

	public void insertMember(MemberVo vo) {
		dao.insertMember(vo);
	}
	public MemberVo selectMember(String uid, String pass) {
		return dao.selectMember(uid, pass);
	}
	public List<MemberVo> selectMembers() {
		return dao.selectMembers();
	}
	
	public TermsVo selectTerms() {
		
		return dao.selectTerms();
	}
	
	public int selectCountUid(String uid) {
		return dao.selectCountUid(uid);
	}
	
	public int selectCoundNick(String nick) {
		return dao.selectCountNick(nick);
	}
	public int selectCountEmail(String email) {
		return dao.selectCountEmail(email);
	}
	public int selectCountHp(String hp) {
		return dao.selectCountHp(hp);
	}
	
	
	public void updateMember() {}
	public void deleteMember() {}
	
}
