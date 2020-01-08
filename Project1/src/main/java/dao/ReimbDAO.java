package dao;
import model.ReimbModel;
import model.UserModel;
public interface ReimbDAO {

	public boolean add_reimb(ReimbModel r);
	
	public boolean move_reimb(ReimbModel r, UserModel u);
	
	public boolean increment_reimb(ReimbModel r, UserModel u);
	
	public boolean add_msg(ReimbModel r, UserModel u, String message);
	
	public boolean reject_reimb(ReimbModel r, UserModel u, String message);
	
	public boolean approve_reimb(ReimbModel r);
	
	public boolean alter_reimb(ReimbModel r, int new_reimb);
	
	public boolean del_reimb(ReimbModel r);
	
	
}
