package tw.test.hi1;

import tw.test.dao.SCDao;
import tw.test.entity.Course;

public class Test14 {

	public static void main(String[] args) {
		Course c1 = new Course("JAVA");
		Course c2 = new Course("JDBC");
		Course c3 = new Course("Servlet");
		Course c4 = new Course("C");
		Course c5 = new Course("Python");
		Course c6 = new Course("C++");
		
		SCDao dao = new SCDao();
		dao.save(c1);
		dao.save(c2);
		dao.save(c3);
		dao.save(c4);
		dao.save(c5);
		dao.save(c6);
		

	}

}
