package dao;

import java.util.List;

import model.EventModel;
import model.ReimbModel;

public interface EventDAO {

	public EventModel get_event(ReimbModel r);
	
	public List<EventModel> get_event_count();
	
}
