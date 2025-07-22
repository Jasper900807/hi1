package tw.test.hi1;

import java.util.List;

import tw.test.apis.BCrypt;
import tw.test.dao.MemberDao;
import tw.test.entity.Member;

public class Test05 {

	public static void main(String[] args) {
		Member member = new Member();
		member.setAccount("eric");
		member.setPasswd(BCrypt.hashpw("123456", BCrypt.gensalt()));
		member.setName("艾瑞克123");
		
		MemberDao dao = new MemberDao();
		//dao.save(member);
		//dao.update(member);
		
//		Member m3 = dao.getById(4);
//		System.out.println(m3.getId() + ":" + m3.getAccount() + ":" + m3.getName());
//		m3.setName("艾米");
//		dao.update(m3);
		
		// ----------
		
//		List<Member> members = dao.getAll();
//		for (Member mb : members) {
//			System.out.println(mb.getAccount());
//		}
		
		// ----------
		
		List<Member> ms = dao.getByKey("a");
		for (Member mb : ms) {
			System.out.println(mb.getAccount() + ":" + mb.getName());
		}
		
	}

}
