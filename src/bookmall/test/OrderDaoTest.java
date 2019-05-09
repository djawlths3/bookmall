package bookmall.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;







public class OrderDaoTest {

	public static void main(String[] args) {
		OrderBookDaoTest obdt = new OrderBookDaoTest();
		// insert test
		//int ordersNo = insertTest("엄기윤","djawlths4@naver.com",30000, "왕십리", 1);
		int ordersNo = 1;
//		if(ordersNo > -1) {
//			obdt.insertTest(1, ordersNo, 1);
//			obdt.insertTest(2, ordersNo, 1);
//		}
		//getlist test
		getListTest(1);
		obdt.getListTest(ordersNo);

	}
	
	public static void getListTest(int customorNo) {
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getList(customorNo);
		System.out.println("------------주문 리스트-----------");
		for(OrderVo vo : list) {
			System.out.println("이름 : "+vo.getName()+", 가격 : "+ vo.getPrice() + ", 이메일 : "+ vo.getEmail()+", 주소 : "+vo.getAddress());
		}
	}
	
	public static int insertTest(String name, String email, int price, String address, int cusomorNo) {
		OrderVo vo = new OrderVo();
		vo.setName(name);
		vo.setEmail(email);
		vo.setPrice(price);
		vo.setAddress(address);
		vo.setCusomorNo(cusomorNo);
		int ordersNo = new OrderDao().insert(vo); 
		return ordersNo;
	}

}
