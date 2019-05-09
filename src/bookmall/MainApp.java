package bookmall;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderBookDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class MainApp {

	public static void main(String[] args) {
		getListMember();
		getListCategory();
		getListBook();
		getListCart(1);
		getListOrder(1);
		getListOrderBook(1);
	}

	
	//멤버 리스트
	public static void getListMember() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		System.out.println("------------회원리스트-----------");
		for(MemberVo vo : list) {
			System.out.println("이름 : "+vo.getName()+", 전화번호 : "+ vo.getPhone() + ", 이메일 : "+ vo.getEmail());
		}
	}
	//카테고리리스트
	public static void getListCategory() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		System.out.println("------------카테고리 리스트-----------");
		for(CategoryVo vo : list) {
			System.out.println("장르 : "+vo.getName()+", 약어 : "+ vo.getAbbrName());
		}
	}
	// 책 리스트
	public static void getListBook() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		System.out.println("------------상품리스트-----------");
		for(BookVo vo : list) {
			System.out.println("제목 : "+vo.getTitle()+", 가격 : "+ vo.getPrice() + ", 카테고리 : "+ vo.getCategoryName());
		}
	}
	
	// 카트 리스트
	public static void getListCart(int customorNo) {
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList(customorNo);
		System.out.println("------------카트리스트-----------");
		for(CartVo vo : list) {
			System.out.println("제목 : "+vo.getTitle()+", 가격 : "+ vo.getPrice() + ", 수량 : "+ vo.getCount());
		}
	}
	//주문리스트
	public static void getListOrder(int customorNo) {
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getList(customorNo);
		System.out.println("------------주문 리스트-----------");
		for(OrderVo vo : list) {
			System.out.println("이름 : "+vo.getName()+", 가격 : "+ vo.getPrice() + ", 이메일 : "+ vo.getEmail()+", 주소 : "+vo.getAddress());
		}
	}
	// 주문 도서리스트
	public static void getListOrderBook(int orderNo) {
		OrderBookDao dao = new OrderBookDao();
		List<OrderBookVo> list = dao.getList(orderNo);
		System.out.println("------------주문 도서 리스트-----------");
		for(OrderBookVo vo : list) {
			System.out.println("책 제목 : "+vo.getTitle()+", 수량 : "+ vo.getCount() + ", 가격 : "+ vo.getPrice());
		}
	}
}
