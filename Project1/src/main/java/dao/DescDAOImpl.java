package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DescModel;
import model.ReimbModel;
import model.UserModel;
import util.JDBCConnection;

public class DescDAOImpl implements DescDAO{

	public static Connection conn = JDBCConnection.getConnection();
	
	
		public DescModel get_msg(ReimbModel r) {
			String sql = "select * from r_desc where r_id = ?";
			
			try {
				PreparedStatement ps = conn.prepareCall(sql);
				
				ps.setInt(1, r.getR_id());
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) 
					return new DescModel(rs.getInt("r_id"),
										(rs.getString("r_msg")));
										 
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	

		public boolean add_msg(ReimbModel r, UserModel u, String message) {
			String sql = "call add_msg(?, ?, ?)";
			
			try {
				CallableStatement ps = conn.prepareCall(sql);
				
				ps.setInt(1, r.getR_id());
				ps.setString(2, message);
				ps.setInt(3, u.getU_id());
				ps.executeQuery();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return true;
		}


}
