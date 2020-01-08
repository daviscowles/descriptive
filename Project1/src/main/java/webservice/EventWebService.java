package webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.EventModel;
import model.ReimbModel;
import service.EventService;
import service.ReimbService;

public class EventWebService {

public static void getEvent(HttpServletRequest request, HttpServletResponse response) {
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		ReimbModel r = ReimbService.getReimb(r_id);
		
		EventModel ev = EventService.get_event(r);
		
		Gson gson = new Gson();
		System.out.println(gson);
		
		try {
			
			String reimbJSON = gson.toJson(ev);
			System.out.println(reimbJSON);
			response.getWriter().append(reimbJSON);
		 } catch (IOException e) {
			e.printStackTrace();
		}
	}
public static void getEventCount(HttpServletRequest request, HttpServletResponse response) {
	List<EventModel> ec = EventService.get_event_count();
	
	Gson gson = new Gson();
	System.out.println(gson);
	
	try {
		
		String reimbJSON = gson.toJson(ec);
		System.out.println(reimbJSON);
		response.getWriter().append(reimbJSON);
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}
