package tw.test.hi1;

import tw.test.dao.SCDao;
import tw.test.entity.Student;

public class Test13 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1 = new Student("Brad");
		Student s2 = new Student("Andy");
		Student s3 = new Student("Tony");
		Student s4 = new Student("Mark");
		Student s5 = new Student("John");
		Student s6 = new Student("Eric");
		
		dao.save(s1);
		dao.save(s2);
		dao.save(s3);
		dao.save(s4);
		dao.save(s5);
		dao.save(s6);
	}

}
