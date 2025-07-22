package tw.test.hi1;

import tw.test.apis.BCrypt;
import tw.test.dao.MemberDao;
import tw.test.entity.Member;
import tw.test.entity.MemberInfo;

public class Test07 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = new Member();
		member.setAccount("ok1");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setName("OK1");
		
		MemberInfo info = new MemberInfo();
		info.setBirthday("1999-01-02");
		info.setGender("male");
		
		member.setMemberInfo(info);
		
		
		dao.save(member);
	}

}
