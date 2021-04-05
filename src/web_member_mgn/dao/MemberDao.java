package web_member_mgn.dao;

import web_member_mgn.dto.Member;

public interface MemberDao {
	Member selectMemberById(Member member);
}
