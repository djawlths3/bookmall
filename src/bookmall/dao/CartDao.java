package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.util.Connect;
import bookmall.vo.CartVo;


public class CartDao {

	public Boolean insert(CartVo vo) {
		Connect dbConnect = new Connect();
		Boolean result = false;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			conn = dbConnect.getConnection();
			
			String sql = "insert into cart values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getBookNo());
			pstmt.setInt(2, vo.getCustomerNo());
			pstmt.setInt(3, vo.getCount());
			//stmt.executeQuery("select last_insert_id()");
			int count = pstmt.executeUpdate();
			result = (count == 1);
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( stmt != null ) {
					stmt.close();
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
	
	
	public List<CartVo> getList(int customorNo){
		Connect dbConnect = new Connect();
		List<CartVo> result = new ArrayList<CartVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbConnect.getConnection();
			String sql = "SELECT b.title, b.price, a.count FROM cart a, book b, member c WHERE a.book_no = b.no AND a.customer_no = c.no AND customer_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, customorNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				int price = rs.getInt(2);
				int count = rs.getInt(3);
				CartVo vo = new CartVo();
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCount(count);
				
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
