package tw.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.test.enyity.Member;
import tw.test.hi1.HibernateUtil;

public class MemberDao {
	public void save(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.persist(member);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void delete(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.remove(member);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void update(Member member) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.merge(member);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public Member getById(int id) {
		return null;
	}
	
	public List<Member> getAll() {
		return null;
	}
}
