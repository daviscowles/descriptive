package dao;

import model.DescModel;
import model.ReimbModel;
import model.UserModel;

public interface DescDAO {

		public DescModel get_msg(ReimbModel r);
		
		public boolean add_msg(ReimbModel r, UserModel u, String message);
		
		
}
