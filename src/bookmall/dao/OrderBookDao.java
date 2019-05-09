package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.util.Connect;
import bookmall.vo.OrderBookVo;

public class OrderBookDao {
	
	public Boolean insert(OrderBookVo vo) {
		Connect dbConnect = new Connect();
		Boolean result = false;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		try {
			conn = dbConnect.getConnection();
			
			String sql = "insert into order_book values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getBookNo());
			pstmt.setInt(2, vo.getOrderNo());
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
	
	
	public List<OrderBookVo> getList(int orderNo){
		Connect dbConnect = new Connect();
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbConnect.getConnection();
			String sql = "SELECT b.title, a.count, b.price FROM order_book a, book b WHERE a.book_no = b.no AND a.order_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orderNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String title = rs.getString(1);
				int count = rs.getInt(2);
				int price = rs.getInt(3);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setTitle(title);
				vo.setCount(count);
				vo.setPrice(price);
				
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
