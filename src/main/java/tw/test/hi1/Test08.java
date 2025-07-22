package tw.test.hi1;

import java.io.FileInputStream;

import tw.test.dao.MemberDao;
import tw.test.entity.Member;

public class Test08 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		
		Member member = dao.getById(2);
		try {
			FileInputStream fin = 
					new FileInputStream("C:\\Users\\User\\eclipse-workspace\\hi1\\dir1\\ball.png");
			byte[] ball = fin.readAllBytes();
			member.setMyicon(ball);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		dao.update(member);
	}

}
