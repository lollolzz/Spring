package kr.co.farmstory1.dao;

import org.springframework.stereotype.Repository;

import kr.co.farmstory1.vo.MemberVo;
import kr.co.farmstory1.vo.TermsVo;

@Repository
public interface MemberDao {
	
	public void insertMember(MemberVo vo);
	public void selectMember();
	public void selectMembers();
	
	public TermsVo selectTerms();
	
	public void updateMember();
	public void deleteMember();

}
