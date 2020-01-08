package serf;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.DescWebService;
import webservice.EventWebService;
import webservice.ReimbWebService;
import webservice.UserWebService;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) {
				
		String uri = request.getRequestURI();
		
		System.out.println(uri);
		
		switch(uri) {
			
		case "/Project1/MasterServlet.do": {
			System.out.println("In this case.");
			break;
		}
		
		case "/Project1/getReimb.do": {
			ReimbWebService.getReimb(request, response);
			break;
		}

		case "/Project1/addReimb.do": {
			System.out.println("reached addReimb.do case, before calling webservice");
			ReimbWebService.add_reimb(request, response);
			break;
		}
		
		case "/Project1/getMsg.do": {
			System.out.println("reached getMsg.do case, before calling webservice");
			DescWebService.getMsg(request, response);
			break;
		}
		case "/Project1/moveReimb.do":{
			System.out.println("reached movereimb.do case, before calling webservice");
			ReimbWebService.moveReimb(request, response);
			break;
		}
		case "/Project1/incrementReimb.do":{
			System.out.println("reached incrementreimb.do case, before calling webservice");
			ReimbWebService.incrementReimb(request, response);
			break;
		}
		case "/Project1/rejectReimb.do":{
			System.out.println("reached rejectreimb.do case, before calling webservice");
			ReimbWebService.rejectReimb(request, response);
			break;
		}
		case "/Project1/approveReimb.do":{
			System.out.println("reached approvereimb.do case, before calling webservice");
			ReimbWebService.approveReimb(request, response);
			break;
		}
		case "/Project1/alterReimb.do":{
			System.out.println("reached alterreimb.do case, before calling webservice");
			ReimbWebService.alterReimb(request, response);
			break;
		}
		case "/Project1/delReimb.do":{
			System.out.println("reached alterreimb.do case, before calling webservice");
			ReimbWebService.delReimb(request, response);
			break;
		}
		case "/Project1/addMsg.do":{
			System.out.println("reached addmsg.do case, before calling webservice");
			DescWebService.addMsg(request, response);
			break;
		}
		case "/Project1/usersOverFunds.do":{
			System.out.println("reached usersoverfunds.do case, before calling webservice");
			UserWebService.usersOverFunds(request, response);
			break;
		}
		case "/Project1/getOverFunds.do":{
			System.out.println("reached getsoverfunds.do case, before calling webservice");
			UserWebService.getOverFunds(request, response);
			break;
		}
		case "/Project1/getUser.do":{
			System.out.println("reached getuser.do case, before calling webservice");
			UserWebService.getUser(request, response);
			break;
		}
		case "/Project1/showReimb.do":{
			System.out.println("reached showreimb.do case, before calling webservice");
			UserWebService.showReimb(request, response);
			break;
		}
		case "/Project1/userReimb.do":{
			System.out.println("reached showreimb.do case, before calling webservice");
			UserWebService.userReimb(request, response);
			break;
		}
		case "/Project1/showDunder.do":{
			System.out.println("reached showdunder.do case, before calling webservice");
			UserWebService.showDunder(request, response);
			break;
		}
		case "/Project1/getEvent.do":{
			System.out.println("reached getEvent.do case, before calling webservice");
			EventWebService.getEvent(request, response);
			break;
		}
		case "/Project1/getEventCount.do":{
			System.out.println("reached getEventcount.do case, before calling webservice");
			EventWebService.getEventCount(request, response);
			break;
		}
		case "/Project1/createSession.do":{
			System.out.println("reached createsession.do case, before calling webservice");
			break;
		}
		case "/Project1/getCurr.do":{
			System.out.println("reached getcurr.do case, before calling webservice");
			ReimbWebService.getCurr(request, response);
			break;
		}
		case "/Project1/getSeshUser.do":{
			System.out.println("reached getseshuser.do case, before calling webservice");
			UserWebService.getSeshUser(request, response);
			break;
		}
				
		
		
		
				
		default: {
			try {
				response.sendError(451, "Get off my lawn!");
			} catch (IOException e) {
				e.printStackTrace();
			}break;
		}
		
		}
		
	}
	
}
