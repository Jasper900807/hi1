package tw.test.hi1;

//import java.lang.reflect.Member;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Configuration config = new Configuration();
			config.configure("hibernate.cfg.xml");
			
			//config.addAnnotatedClass(Member.class);
			
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;			
	}
}
