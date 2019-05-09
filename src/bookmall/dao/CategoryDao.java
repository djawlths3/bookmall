package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.util.Connect;
import bookmall.vo.CategoryVo;

public class CategoryDao {
	
	public Boolean insert(CategoryVo vo) {
		Connect dbConnect = new Connect();
		Boolean result = false;		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbConnect.getConnection();
			
			String sql = "insert into category values(null, ?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAbbrName());
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
	
	
	public List<CategoryVo> getList(){
		Connect dbConnect = new Connect();
		List<CategoryVo> result = new ArrayList<CategoryVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbConnect.getConnection();
			String sql = "select name,abbr_name,no from category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString(1);
				String abbrName = rs.getString(2);
				int no = rs.getInt(3);
				CategoryVo vo = new CategoryVo();
				vo.setName(name);
				vo.setAbbrName(abbrName);
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
