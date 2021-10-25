package kr.co.sboard1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.MemberVo;
import kr.co.sboard1.vo.TermsVo;

@Repository
public interface MemberDao {

	public void insertMember(MemberVo vo);
	public MemberVo selectMember(String uid, String pass);
	
	public List<MemberVo> selectMembers();
	
	public TermsVo selectTerms();
	
	public int selectCountUid(String uid);
	
	public int selectCountNick(String nick);
	
	public int selectCountEmail(String email);
	
	public int selectCountHp(String hp);
	
	public void updateMember();
	public void deleteMember();
	
}
