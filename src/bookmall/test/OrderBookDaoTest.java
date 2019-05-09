package bookmall.test;

import java.util.List;

import bookmall.dao.OrderBookDao;
import bookmall.vo.OrderBookVo;








public class OrderBookDaoTest {

	public static void main(String[] args) {
		// insert test
//		insertTest(1,1,1);
//		insertTest(2,1,1);
				
		//getlist test
		getListTest(1);

	}
	
	public static void getListTest(int orderNo) {
		OrderBookDao dao = new OrderBookDao();
		List<OrderBookVo> list = dao.getList(orderNo);
		System.out.println("------------주문 도서 리스트-----------");
		for(OrderBookVo vo : list) {
			System.out.println("책 제목 : "+vo.getTitle()+", 수량 : "+ vo.getCount() + ", 가격 : "+ vo.getPrice());
		}
	}
	
	public static void insertTest(int bookNo, int orderNo, int count) {
		OrderBookVo vo = new OrderBookVo();
		vo.setBookNo(bookNo);
		vo.setOrderNo(orderNo);
		vo.setCount(count);
		new OrderBookDao().insert(vo);
	}

}
