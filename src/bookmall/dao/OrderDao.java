package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.util.Connect;
import bookmall.vo.OrderVo;


public class OrderDao {
	
	public int insert(OrderVo vo) {
		Connect dbConnect = new Connect();
		Boolean result = false;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		int ordersNo = -1;
		try {
			conn = dbConnect.getConnection();
			
			String sql = "insert into orders values(null,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setInt(3, vo.getPrice());
			pstmt.setString(4, vo.getAddress());
			pstmt.setInt(5, vo.getCusomorNo());
			pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ResultSet rs = pstmt.getGeneratedKeys();
	         if(rs.next()) ordersNo = rs.getInt(1);
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
		
		return ordersNo;
	}
	
	
	public List<OrderVo> getList(int num){
		Connect dbConnect = new Connect();
		List<OrderVo> result = new ArrayList<OrderVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbConnect.getConnection();
			String sql = "select no, name, email, price, address, customor_no from orders where customor_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				int price = rs.getInt(4);
				String address = rs.getString(5);
				int customorNo = rs.getInt(6);
				OrderVo vo = new OrderVo();
				vo.setName(name);
				vo.setNo(no);
				vo.setEmail(email);
				vo.setPrice(price);
				vo.setAddress(address);
				vo.setCusomorNo(customorNo);
				
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
