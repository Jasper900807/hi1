package tw.test.hi1;

import java.util.List;

import tw.test.dao.CustDao;
import tw.test.entity.Cust;
import tw.test.entity.Order;

public class Test12 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		Cust cust = dao.getById(1);
		List<Order> os = cust.getOrders();
		for (Order order : os) {
			System.out.printf("%d, %s\n", order.getId(), order.getOrderDate());
		}
	}

}
