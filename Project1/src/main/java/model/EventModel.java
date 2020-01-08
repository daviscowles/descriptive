package model;

public class EventModel {
	
	private int e_id;
	private int coverage;
	
	
	
	
	public EventModel() {
		super();
	}
	public EventModel(int e_id, int coverage) {
		super();
		this.e_id = e_id;
		this.coverage = coverage;
	}
	
	
	@Override
	public String toString() {
		return "EventModel [e_id=" + e_id + ", coverage=" + coverage + "]";
	}
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public int getCoverage() {
		return coverage;
	}
	public void setCoverage(int coverage) {
		this.coverage = coverage;
	}
	
	
}
