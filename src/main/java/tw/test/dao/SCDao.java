package tw.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.test.entity.Course;
import tw.test.entity.Student;
import tw.test.hi1.HibernateUtil;

public class SCDao {
	public void save(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.persist(student);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void save(Course course) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.persist(course);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void delete(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.remove(student);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public Student update(Student student) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.merge(student);
			
			
			transaction.commit();
			return getById(student.getId());
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
		return null;
	}
	
	public Student getById(long studentId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Student.class, studentId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Course getCourseById(long courseId) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Course.class, courseId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Course> getAllCourse() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("FROM Course", Course.class).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
