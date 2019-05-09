package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;




public class BookDaoTest {

	public static void main(String[] args) {
		// insert test
		insertTest("퇴마록", 16000, 1);
		insertTest("안나의일기", 14000, 2);
		insertTest("자바완전정복", 28000, 3);
				
		//getlist test
		getListTest();

	}
	
	public static void getListTest() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		System.out.println("------------상품리스트-----------");
		for(BookVo vo : list) {
			System.out.println("제목 : "+vo.getTitle()+" 가격 : "+ vo.getPrice() + " 카테고리 : "+ vo.getCategoryName());
		}
	}
	
	public static void insertTest(String title, int price, int categoryNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);
		
		new BookDao().insert(vo);
	}

}
