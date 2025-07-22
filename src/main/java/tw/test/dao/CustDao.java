package tw.test.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.test.entity.Cust;
import tw.test.entity.Order;
import tw.test.hi1.HibernateUtil;

public class CustDao {
	public void save(Cust cust) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.persist(cust);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void delete(Cust cust) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.remove(cust);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public void update(Cust cust) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			session.merge(cust);
			
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
	
	public Cust getById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Cust.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Order getOrderById(int id) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Order.class, id);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void removeOrderFromCust(long custId, long orderId) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Order delOrder = null;
			Cust cust = session.get(Cust.class, custId);
			for (Order order : cust.getOrders()) {
				if (order.getId() == orderId) {
					delOrder = order;
					break;
				}
			}
			
			if (delOrder != null) {
				cust.delOrder(delOrder);
			}	
			
			session.merge(cust);
			
			transaction.commit();
		} 
		catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} 
	}
}
