package model;

public class DescModel {

	private int r_id;
	private String r_msg;
	
	
	
	public DescModel() {
		super();
	}

	public DescModel(int r_id, String r_msg) {
		super();
		this.r_id = r_id;
		this.r_msg = r_msg;
	}

	@Override
	public String toString() {
		return "DescModel [r_id=" + r_id + ", r_msg=" + r_msg + "]";
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getR_msg() {
		return r_msg;
	}

	public void setR_msg(String r_msg) {
		this.r_msg = r_msg;
	}
	
	
	
}
