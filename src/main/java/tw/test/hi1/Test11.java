package tw.test.hi1;

import tw.test.dao.CustDao;

public class Test11 {

	public static void main(String[] args) {
		CustDao dao = new CustDao();
		dao.removeOrderFromCust(17, 8);

	}

}
