package tw.test.hi1;

import java.util.Date;

import tw.test.dao.CustDao;
import tw.test.entity.Cust;
import tw.test.entity.Order;

public class Test10 {
	public static void main(String[] args) {
		CustDao dao = new CustDao();
		
		Cust cust = new Cust();
		cust.setCname("ispan");
		cust.setBirthday("1999-09-09");
		cust.setTel("1234567");
		
		Order order1 = new Order();
		order1.setOrderDate(new Date());
		
		Order order2 = new Order();
		order2.setOrderDate(new Date());
		
		cust.addOrder(order1);
		cust.addOrder(order2);
		
		dao.update(cust);
	}
}
