package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EventModel;
import model.ReimbModel;
import util.JDBCConnection;

public class EventDAOImpl implements EventDAO{
	public static Connection conn = JDBCConnection.getConnection();
	
	public EventModel get_event(ReimbModel r) {
		String sql = "select * from event where e_id = ?"; 
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 

			ps.setInt(1, r.getE_id()); 
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new EventModel(rs.getInt("e_id"), 
									 rs.getInt("coverage"));
									 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
		

	public List<EventModel> get_event_count() {
		String sql = "select e_id, count(e_id)\"total events\" from reimbursement where pending = 1 group by e_id;"; 
		List<EventModel> funds = new ArrayList<EventModel>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 

			
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				funds.add(new EventModel(rs.getInt("e_id"), 
									 rs.getInt("coverage")));
									 
			}
				return funds;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
