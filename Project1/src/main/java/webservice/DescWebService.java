package webservice;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.DescModel;
import model.ReimbModel;
import model.UserModel;
import service.DescService;
import service.ReimbService;
import service.UserService;

public class DescWebService {

	
	public static void getMsg(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		
		ReimbModel r = ReimbService.getReimb(r_id);
		DescModel d = DescService.get_msg(r);
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			String reimbJSON = gson.toJson(d);
			System.out.println(reimbJSON);
			response.getWriter().append(d.getR_msg());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void addMsg(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		int u_id = Integer.parseInt(request.getParameter("u_id")); //current user's id
		String message = request.getParameter("message");
		
		ReimbModel r = ReimbService.getReimb(r_id);
		UserModel u = UserService.getUser(u_id);
		
		DescService.add_msg(r, u, message);
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			String reimbJSON = gson.toJson(DescService.get_msg(r));
			System.out.println(reimbJSON);
			response.getWriter().append(reimbJSON);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
