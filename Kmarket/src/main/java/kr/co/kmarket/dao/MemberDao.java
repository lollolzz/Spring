package kr.co.kmarket.dao;

import org.springframework.stereotype.Repository;

import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	
	public MemberVo selectMember(String uid, String pass);
	
	public int selectCountUid(String uid);
	
	public int selectCountEmail(String email);
	
	public int selectCountHp(String hp);
	
	public MemberTermsVo selectSignup();

}
