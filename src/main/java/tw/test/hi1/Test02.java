package tw.test.hi1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.test.entity.Member;
;

public class Test02 {

	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Transaction transaction = session.beginTransaction();
			
			String sql = "INSERT INTO member (account,passwd,name) " + 
						"VALUES (:account, :passwd, :name)";
			NativeQuery<Member> query = session.createNativeQuery(sql, Member.class);
			query.setParameter("account", "test111");
			query.setParameter("passwd", "test112");
			query.setParameter("name", "test113");
			
			int n = query.executeUpdate();
			transaction.commit();
			System.out.println(n);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
