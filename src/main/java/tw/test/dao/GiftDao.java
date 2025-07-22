package tw.test.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tw.test.entity.Cust;
import tw.test.entity.Gift;
import tw.test.entity.Order;
import tw.test.hi1.HibernateUtil;

public class GiftDao {
	public void save(Gift gift) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.persist(gift);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void delete(Gift gift) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.remove(gift);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void update(Gift gift) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.merge(gift);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public Gift getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Gift.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Gift> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// SQL(DB) -> HQL(entity)
			String hql = "FROM Gift";
			return session.createQuery(hql, Gift.class).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Gift> getBySQL(String sql) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createNativeQuery(sql, Gift.class).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Gift> getByHQL(String hql) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery(hql, Gift.class).getResultList();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
