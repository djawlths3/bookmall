package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.util.Connect;
import bookmall.vo.BookVo;


public class BookDao {

	
	public Boolean insert(BookVo vo) {
		Connect dbConnect = new Connect();
		Boolean result = false;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConnect.getConnection();
			
			String sql = "insert into book values(null, ?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setInt(3, vo.getCategoryNo());
			int count = pstmt.executeUpdate();
			result = (count == 1);
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return result;
	}
	
	
	public List<BookVo> getList(){
		Connect dbConnect = new Connect();
		List<BookVo> result = new ArrayList<BookVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbConnect.getConnection();
			String sql = "select a.no, a.title, a.price, b.name from book a, category b where a.category_no = b.no";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String title = rs.getString(2);
				int price = rs.getInt(3);
				String categoryName = rs.getString(4);
				BookVo vo = new BookVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategoryName(categoryName);
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					rs.close();
					pstmt.close();
					conn.close();	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
}
