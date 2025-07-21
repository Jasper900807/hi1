package tw.test.hi1;

import tw.test.apis.BCrypt;
import tw.test.dao.MemberDao;
import tw.test.enyity.Member;

public class Test05 {

	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("eric");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setName("艾瑞克");
		
		MemberDao dao = new MemberDao();
		dao.save(member);
	}

}
