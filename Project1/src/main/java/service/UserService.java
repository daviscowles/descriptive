package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.ReimbModel;
import model.UserModel;
import util.JDBCConnection;

public class UserService {

	public static Connection conn = JDBCConnection.getConnection();
	
	public static List<UserModel> users_over_funds() {
		String sql = "select * from users where reimb_avail < 0"; 
		List<UserModel> users = new ArrayList<UserModel>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 

			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new UserModel(rs.getInt("u_id"), 
									 rs.getInt("d_id"),
									 rs.getString("fname"),
									 rs.getString("lname"),
									 rs.getString("pass"),
									 rs.getInt("reimb_avail"),
									 rs.getInt("reimb_pend"),
									 rs.getInt("reports_to"),
									 rs.getInt("reimb_award")));

			}
			return users;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;	
		
		
		
	}

	public static int get_over_funds() {
		String sql = "select sum(0 - reimb_avail)\"total funds exceeding\" from users where reimb_avail < 0";
		int sum;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return sum = rs.getInt("total funds exceeding");
			}
		}catch (SQLException e) {
		e.printStackTrace();
	} return 0;}

	public static UserModel getUser(int u_id) {
		String sql = "select * from users where u_id = ?"; 
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 

			ps.setInt(1, u_id); 

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new UserModel(rs.getInt("u_id"), 
									 rs.getInt("d_id"),
									 rs.getString("fname"),
									 rs.getString("lname"),
									 rs.getString("pass"),
									 rs.getInt("reimb_avail"),
									 rs.getInt("reimb_pend"),
									 rs.getInt("reports_to"),
									 rs.getInt("reimb_award"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;	
		
		
		
	}
	
	public static List<ReimbModel> showReimb() {
		String sql = "select * from reimbursement";
		List<ReimbModel> reimb = new ArrayList<ReimbModel>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimb.add(new ReimbModel(
						rs.getInt("r_id"),
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
			return reimb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<ReimbModel> userReimb(UserModel u) {
		String sql = "select * from reimbursement where u_id = ?";
		List<ReimbModel> reimb = new ArrayList<ReimbModel>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getU_id());
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				reimb.add(new ReimbModel(
						rs.getInt("r_id"),
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
			return reimb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static List<UserModel> showDunder() {
		String sql = "select * from users";
		List<UserModel> user = new ArrayList<UserModel>();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.add(new UserModel(
						rs.getInt("u_id"),
						rs.getInt("d_id"),
						rs.getString("fname"),
						rs.getString("lname"),
						rs.getString("pass"),
						rs.getInt("reimb_avail"),
						rs.getInt("reimb_pend"),
						rs.getInt("reports_to"),
						rs.getInt("reimb_award")));
			
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
