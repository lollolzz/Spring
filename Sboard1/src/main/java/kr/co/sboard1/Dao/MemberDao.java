package kr.co.sboard1.dao;

import org.springframework.stereotype.Repository;

import kr.co.sboard1.vo.MemberVo;
import kr.co.sboard1.vo.TermsVo;

@Repository
public interface MemberDao {

	public void insertMember(MemberVo vo);
	public MemberVo selectMember(String uid, String pass);
	
	public void selectMembers();
	
	public TermsVo selectTerms();
	
	public void updateMember();
	public void deleteMember();
	
}
