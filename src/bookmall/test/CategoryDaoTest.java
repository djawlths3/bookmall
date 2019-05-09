package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;



public class CategoryDaoTest {

	public static void main(String[] args) {
		// insert test
		insertTest("소설", "nobel");
		insertTest("수필", "essay");
		insertTest("참고서", "ref");
				
		//getlist test
		getListTest();

	}
	
	public static void getListTest() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		System.out.println("------------카테고리 리스트-----------");
		for(CategoryVo vo : list) {
			System.out.println("장르 : "+vo.getName()+", 약어 : "+ vo.getAbbrName());
		}
	}
	
	public static void insertTest(String name, String abbrName) {
		CategoryVo vo = new CategoryVo();
		vo.setName(name);
		vo.setAbbrName(abbrName);
		
		new CategoryDao().insert(vo);
	}

}
