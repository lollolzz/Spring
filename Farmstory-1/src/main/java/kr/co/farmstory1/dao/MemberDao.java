package kr.co.farmstory1.dao;

import org.springframework.stereotype.Repository;

import kr.co.farmstory1.vo.MemberVo;
import kr.co.farmstory1.vo.TermsVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	public MemberVo selectMember(String uid, String pass);
	public void selectMembers();
	
	public TermsVo selectTerms();
	
	public void updateMember();
	public void deleteMember();
	
	public int selectCountUid(String uid);
	public int selectCountNick(String nick);
	public int selectCountEmail(String email);
	public int selectCountHp(String hp);
}
