package tw.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tw.test.entity.Member;
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
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Member.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Member> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// SQL(DB) -> HQL(entity)
			String hql = "FROM Member";
			return session.createQuery(hql, Member.class).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Member> getByKey(String keyword) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// SQL(DB) -> HQL(entity)
			String hql = "FROM Member m WHERE m.account LIKE :key OR m.name LIKE :key";
			Query<Member> query = session.createQuery(hql, Member.class);
			query.setParameter("key", "%" + keyword + "%");
			
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
