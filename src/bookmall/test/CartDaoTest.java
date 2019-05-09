package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;





public class CartDaoTest {

	public static void main(String[] args) {
		// insert test
		insertTest(1, 1, 2);
		insertTest(3, 1, 1);
				
		//getlist test
		getListTest(1);

	}
	
	public static void getListTest(int customorNo) {
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList(customorNo);
		System.out.println("------------카트리스트-----------");
		for(CartVo vo : list) {
			System.out.println("제목 : "+vo.getTitle()+", 가격 : "+ vo.getPrice() + ", 수량 : "+ vo.getCount());
		}
	}
	
	public static void insertTest(int bookNo, int customerNo, int count) {
		CartVo vo = new CartVo();
		vo.setBookNo(bookNo);
		vo.setCustomerNo(customerNo);
		vo.setCount(count);
		
		new CartDao().insert(vo);
	}

}
