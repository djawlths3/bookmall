package bookmall.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;



public class MemberDaoTest {

	public static void main(String[] args) {
		// insert test
		insertTest("엄기윤", "01095590484", "djawlths4@naver.com", "1234");
		insertTest("강아지", "01012345678", "dog@naver.com", "4321");
				
		//getlist test
		getListTest();

	}
	
	public static void getListTest() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		System.out.println("------------회원리스트-----------");
		for(MemberVo vo : list) {
			System.out.println("이름 : "+vo.getName()+" 전화번호 : "+ vo.getPhone() + " 이메일 : "+ vo.getEmail());
		}
	}
	
	public static void insertTest(String name, String phone, String email, String passwd) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPasswd(passwd);
		
		new MemberDao().insert(vo);
	}

}
