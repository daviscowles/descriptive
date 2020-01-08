package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ReimbModel;
import model.UserModel;
import util.JDBCConnection;

public class ReimbService {

	public static Connection conn = JDBCConnection.getConnection();
	
	public static boolean add_reimb(ReimbModel r, String justify) {
		String sql = "call add_reimb(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
		try {
			CallableStatement ps = conn.prepareCall(sql); 
			
			ps.setInt(1, r.getU_id());
			ps.setInt(2, r.getG_id());
			ps.setInt(3, r.getE_id());
			ps.setInt(4, r.getR_date());
			ps.setInt(5, r.getR_time());
			ps.setString(6, r.getR_address());
			ps.setInt(7, r.getR_cost());
			ps.setString(8, r.getR_desc());
			ps.setInt(9, r.getCutoff());
			ps.setString(10, justify);
			ps.executeQuery();
			
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				return new CustomerModel(rs.getInt("u_id"), 
//										rs.getString("name"), 
//										rs.getString("password"));
			
//			}
//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}

	public static boolean move_reimb(ReimbModel r, UserModel u) {
		String sql = "call move_reimb(?, ?)";
		
		try {
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, r.getR_id());
			ps.setInt(2, u.getU_id());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public static boolean increment_reimb(ReimbModel r, UserModel u) {
		String sql = "call increment_reimb(?, ?)";
		
		try {
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, r.getR_id());
			ps.setInt(2, u.getU_id());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	
	
	

	public static boolean reject_reimb(ReimbModel r, UserModel u, String message) {
	String sql = "call reject_reimb(?, ?, ?)";
		
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

	public static boolean approve_reimb(ReimbModel r) {
			String sql = "call approve_reimb(?)";
		
		try {
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, r.getR_id());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public static boolean alter_reimb(ReimbModel r, int new_reimb) { //new_reimb is adjustment to pending
		String sql = "call alter_reimb(?, ?)";
		
		try {
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, r.getR_id());
			ps.setInt(2, new_reimb);
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public static boolean del_reimb(ReimbModel r) {
		String sql = "call del_reimb(?)";
		
		try {
			CallableStatement ps = conn.prepareCall(sql);
			
			ps.setInt(1, r.getR_id());
			ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public static List<ReimbModel> getCurr(int u_id) {
		List<ReimbModel> curr = new ArrayList<ReimbModel>(); 
		String sql = "select * from reimbursement where curr_user = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 

			ps.setInt(1, u_id); 

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				curr.add(new ReimbModel(rs.getInt("r_id"), 
									 rs.getInt("u_id"),
									 rs.getInt("g_id"),
									 rs.getInt("e_id"),
									 rs.getInt("r_date"),
									 rs.getInt("r_time"),
									 rs.getString("r_address"),
									 rs.getInt("r_cost"),
									 rs.getString("r_desc"),
									 rs.getInt("cutoff"),
									 rs.getInt("curr_user"),
									 rs.getInt("pending")));

			}
			return curr;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public static ReimbModel getReimb(int r_id) {
		String sql = "select * from reimbursement where r_id = ?"; 
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 

			ps.setInt(1, r_id); 

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new ReimbModel(rs.getInt("r_id"), 
									 rs.getInt("u_id"),
									 rs.getInt("g_id"),
									 rs.getInt("e_id"),
									 rs.getInt("r_date"),
									 rs.getInt("r_time"),
									 rs.getString("r_address"),
									 rs.getInt("r_cost"),
									 rs.getString("r_desc"),
									 rs.getInt("cutoff"),
									 rs.getInt("curr_user"),
									 rs.getInt("pending"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
//	public static int get_grade(ReimbModel r) {
//		String sql = "select *";
//		int sum;
//		
//		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//			
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				return sum = rs.getInt("total funds exceeding");
//			}
//		}catch (SQLException e) {
//		e.printStackTrace();
//	} 
//		return 0;
//	}
}
