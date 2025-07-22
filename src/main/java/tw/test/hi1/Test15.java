package tw.test.hi1;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import tw.test.dao.SCDao;
import tw.test.entity.Course;
import tw.test.entity.Student;

public class Test15 {

	public static void main(String[] args) {
		SCDao dao = new SCDao();
		Student s1;
//		
//		if (s1 != null) {
//			System.out.printf("Welcome, %s\n", s1.getSname());
			
			Scanner scanner = new Scanner(System.in);
			
			while (true) {
				// 再撈一次
				s1 = dao.getById((long)4);
				List<Course> courses = dao.getAllCourse();
				for (Course course : courses) {
					if (!isExist(s1, course.getStudents())) {
						System.out.printf("%d. %s\n", course.getId(), course.getCname());						
					}
				}
				
				
				System.out.print("Choose course:");
				long cid = scanner.nextLong();
				if (cid == 0) break;
				s1.addCourse(dao.getCourseById(cid));
				
				// update完要再撈一次dao
				dao.update(s1);
			}
			
			scanner.close();
			
			
//		}
//		else {
//			System.out.println("NOT FOUND");
//		}
	}
	private static boolean isExist(Student s, Set<Student> students) {
		boolean repeated = false;
		for (Student student : students) {
			if (student.getId() == s.getId()) {
				repeated = true;
				break;
			}
		}
		return repeated;
	}

}

