package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.ReimbModel;
import model.UserModel;
import service.DescService;
import service.ReimbService;
import service.UserService;

public class ReimbWebService {

	
	
	public static void moveReimb(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		
		ReimbModel r = ReimbService.getReimb(r_id);
		UserModel u = UserService.getUser(u_id);
		
		ReimbService.move_reimb(r, u);
		
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			String reimbJSON = gson.toJson(u.getFname());
			response.getWriter().append("Reimbursement form sent to " + reimbJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void incrementReimb(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		
		ReimbModel r = ReimbService.getReimb(r_id);
		UserModel u = UserService.getUser(u_id);
		
		ReimbService.increment_reimb(r, u);
		
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			
			response.getWriter().append(UserService.getUser(u_id).getFname() + "'s reimbursement form sent to " + 
			UserService.getUser(u.getReports_to()).getFname() + " " + UserService.getUser(u.getReports_to()).getLname());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void rejectReimb(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		String message = request.getParameter("message");
		
		ReimbModel r = ReimbService.getReimb(r_id);
		UserModel u = UserService.getUser(u_id);
		
		ReimbService.reject_reimb(r, u, message);
		
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			String s = DescService.get_msg(r).getR_msg();
			
			response.getWriter().append(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void approveReimb(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
			
		ReimbModel r = ReimbService.getReimb(r_id);
		
		ReimbService.approve_reimb(r);
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			
			response.getWriter().append("Reimbursement ID " + r_id + " approved for " +
			UserService.getUser(r.getU_id()).getFname() + " " + UserService.getUser(r.getU_id()).getLname());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void alterReimb(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		int new_reimb = Integer.parseInt(request.getParameter("new_reimb"));
			
		ReimbModel r = ReimbService.getReimb(r_id);
		
		ReimbService.alter_reimb(r, new_reimb);
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			
			response.getWriter().append("Reimbursement reward amount adjusted to " + new_reimb + " for " + 
			UserService.getUser(r.getU_id()).getFname() + " " + UserService.getUser(r.getU_id()).getLname());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void delReimb(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		
			
		ReimbModel r = ReimbService.getReimb(r_id);
		
		ReimbService.del_reimb(r);
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			response.getWriter().append("Deleted " + UserService.getUser(r.getU_id()).getFname() + "'s reimbursement form.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void getReimb(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		
		ReimbModel r = ReimbService.getReimb(r_id);
		
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			String reimbJSON = gson.toJson(r);
			System.out.println(reimbJSON);
			response.getWriter().append(reimbJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void getCurr(HttpServletRequest request, HttpServletResponse response) {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		
		List<ReimbModel> r = ReimbService.getCurr(u_id);
		
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			String reimbJSON = gson.toJson(r);
			System.out.println(reimbJSON);
			response.getWriter().append(reimbJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
		public static void add_reimb(HttpServletRequest request, HttpServletResponse response) {
		
		
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		System.out.println(u_id);
		int g_id = Integer.parseInt(request.getParameter("g_id"));
		System.out.println(g_id);
		int e_id = Integer.parseInt(request.getParameter("e_id"));
		System.out.println(e_id);
		int r_date = Integer.parseInt(request.getParameter("r_date"));
		System.out.println(r_date);
		int r_time = Integer.parseInt(request.getParameter("r_time"));
		System.out.println(r_time);
		String r_address = request.getParameter("r_address");
		System.out.println(r_address);
		int r_cost = Integer.parseInt(request.getParameter("r_cost"));
		System.out.println(r_cost);
		String r_desc = request.getParameter("r_desc");
		System.out.println(r_desc);
		int cutoff = Integer.parseInt(request.getParameter("cutoff"));
		System.out.println(cutoff);
		String justify = request.getParameter("justify");
		System.out.println(justify);
		
		System.out.println(u_id + " " + g_id + " " + e_id + " " +
		r_date + " " + r_time + " " + r_address + " " + r_cost + " " + r_desc +
		" " + cutoff + " " + justify);
		
		ReimbModel r = new ReimbModel(u_id, g_id, e_id, r_date, r_time, r_address,
				r_cost, r_desc, cutoff);
		
		
		ReimbService.add_reimb(r, justify);
		
		
		
		try {
			response.getWriter().append("Reimbursement request form submitted.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
