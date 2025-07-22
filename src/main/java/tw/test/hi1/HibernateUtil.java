package tw.test.hi1;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.test.entity.Cust;
import tw.test.entity.Gift;
import tw.test.entity.Member;
import tw.test.entity.MemberInfo;
import tw.test.entity.Order;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			config.addAnnotatedClass(Member.class);
			config.addAnnotatedClass(Gift.class);
			config.addAnnotatedClass(MemberInfo.class);
			config.addAnnotatedClass(Cust.class);
			config.addAnnotatedClass(Order.class);
			
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;			
	}
}
