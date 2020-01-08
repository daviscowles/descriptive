package dao;
import java.util.List;

import model.ReimbModel;
import model.UserModel;
public interface UserDAO {

		public int event_count(ReimbModel r, UserModel u);
		
		public int over_funds(ReimbModel r, UserModel u);
		
		public List<ReimbModel> showReimb();
		
		public List<ReimbModel> userReimb(UserModel u);
		
		public List<UserModel> showDunder();
}
