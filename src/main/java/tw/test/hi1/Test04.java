package tw.test.hi1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.test.enyity.Member;

public class Test04 {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			
			String sql = "SELECT id,account,passwd,name FROM member";
			NativeQuery<Member> query = session.createNativeQuery(sql, Member.class);
			List<Member> list = query.getResultList();
			for (Member member : list) {
				System.out.printf("%d : %s : %s\n", member.getId(), member.getAccount(), member.getName());
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
