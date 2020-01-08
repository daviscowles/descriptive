package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.ReimbModel;
import model.UserModel;
import service.UserService;

public class UserWebService {

	public static void getSeshUser(HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession session = request.getSession();

		String username = (String)session.getAttribute("name");
		System.out.println(session.getId());
		try {
			System.out.println(username);
			response.getWriter().append(username);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void usersOverFunds(HttpServletRequest request, HttpServletResponse response) {
		
		List<UserModel> u = UserService.users_over_funds(); 
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			
			String reimbJSON = gson.toJson(u);
			System.out.println(reimbJSON);
			response.getWriter().append(reimbJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public static void getOverFunds(HttpServletRequest request, HttpServletResponse response) {
		int u = UserService.get_over_funds();
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			String reimbJSON = gson.toJson(u);
			System.out.println(u);
			response.getWriter().append(reimbJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getUser(HttpServletRequest request, HttpServletResponse response) {
	int u_id = Integer.parseInt(request.getParameter("u_id"));
	
	UserModel u = UserService.getUser(u_id);
	
	Gson gson = new Gson();
	System.out.println(gson);
	
	try {
		String reimbJSON = gson.toJson(u);
		System.out.println(reimbJSON);
		response.getWriter().append(reimbJSON);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	public static void showReimb(HttpServletRequest request, HttpServletResponse response) {
		List<ReimbModel> u = UserService.showReimb();
		
		
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			
			String reimbJSON = gson.toJson(u);
			System.out.println(reimbJSON);
			response.getWriter().append(reimbJSON);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void userReimb(HttpServletRequest request, HttpServletResponse response) {
		int u_id = Integer.parseInt(request.getParameter("u_id"));
		UserModel u = UserService.getUser(u_id);
		
		List<ReimbModel> r = UserService.userReimb(u);
		
		Gson gson = new Gson();
		for (ReimbModel r1:r) {
		System.out.println(r1);
		}
		try {
			
				String reimbJSON = gson.toJson(r);
				System.out.println(reimbJSON);
				response.getWriter().append(reimbJSON);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public static void showDunder(HttpServletRequest request, HttpServletResponse response) {
		List<UserModel> u = UserService.showDunder();
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			
				String reimbJSON = gson.toJson(u);
				System.out.println(reimbJSON);
				response.getWriter().append(reimbJSON);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	


}
