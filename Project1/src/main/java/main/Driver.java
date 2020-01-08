package main;
import service.DescService;
import service.EventService;
import service.ReimbService;
import service.UserService;
import model.EventModel;
import model.ReimbModel;
import model.UserModel;

public class Driver {

	public static void main(String[] args) {
		
//		ReimbModel r = new ReimbModel(2, 2, 2, 3, 800, "123 Fake St", 500, "test desc", 70);
//		ReimbModel r1 = new ReimbModel(2, 2, 3, 3, 800, "123 Fake St", 500, "test desc", 70);
//		
//		System.out.println(r);
//		ReimbService.add_reimb(r, "test justify");
//		ReimbService.add_reimb(r1, "test justify");
//		
//		System.out.println(UserService.get_over_funds());
//		
//		ReimbService.move_reimb(ReimbService.getReimb(49), UserService.getUser(3));
		System.out.println(ReimbService.getReimb(49));
//		
//		ReimbService.increment_reimb(ReimbService.getReimb(49), UserService.getUser(14));
		
//		DescService.add_msg(ReimbService.getReimb(47), UserService.getUser(14), "so we some kinda suicide squad?");
//		System.out.println(DescService.get_msg(ReimbService.getReimb(47)));

//		for(EventModel r:EventService.get_event_count()) {
//		System.out.println(r);}
		
//		System.out.println(EventService.get_event(ReimbService.getReimb(47)));
		
//		ReimbService.reject_reimb(ReimbService.getReimb(37), UserService.getUser(3), "not this time jimbo");
//		
//		ReimbService.approve_reimb(ReimbService.getReimb(53));
//		ReimbService.approve_reimb(ReimbService.getReimb(54));
//		ReimbService.approve_reimb(ReimbService.getReimb(55));
//		ReimbService.approve_reimb(ReimbService.getReimb(56));
//		
//		for(UserModel u:UserService.users_over_funds()) {
//			System.out.println(u);
//		}
//		System.out.println(UserService.get_over_funds());
//		
//		
//		
//		ReimbService.alter_reimb(ReimbService.getReimb(35), 200);
//		
//		ReimbService.del_reimb(ReimbService.getReimb(48));
//		
//		System.out.println(UserService.getUser(1));
//		
//		for (UserModel u: UserService.showDunder()) {
//			System.out.println(u);
//		}
//		
//		for(ReimbModel u : UserService.showReimb()) {
//			System.out.println(u);
//		}
//		
//		for(ReimbModel r2: UserService.userReimb(UserService.getUser(8))) {
//		System.out.println(r2);
//		}
//		
//		ReimbService.approve_reimb(ReimbService.getReimb(49));
//		
	}
}
