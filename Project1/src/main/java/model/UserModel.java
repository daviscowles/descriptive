package model;

public class UserModel {

		private int u_id;
		private int d_id;
		private String fname;
		private String lname;
		private String pass;
		private int reimb_avail;
		private int reimb_pend;
		private int reports_to;
		private int reimb_award;
		
		
		
		
		public UserModel() {
			super();
		}
		public UserModel(int d_id, String fname, String lname, String pass, int reimb_avail, int reimb_pend,
				int reports_to, int reimb_award) {
			super();
			this.d_id = d_id;
			this.fname = fname;
			this.lname = lname;
			this.pass = pass;
			this.reimb_avail = reimb_avail;
			this.reimb_pend = reimb_pend;
			this.reports_to = reports_to;
			this.reimb_award = reimb_award;
		}
		public UserModel(int u_id, int d_id, String fname, String lname, String pass, int reimb_avail, int reimb_pend,
				int reports_to, int reimb_award) {
			super();
			this.u_id = u_id;
			this.d_id = d_id;
			this.fname = fname;
			this.lname = lname;
			this.pass = pass;
			this.reimb_avail = reimb_avail;
			this.reimb_pend = reimb_pend;
			this.reports_to = reports_to;
			this.reimb_award = reimb_award;
		}
		@Override
		public String toString() {
			return "UserModel [u_id=" + u_id + ", d_id=" + d_id + ", fname=" + fname + ", lname=" + lname + ", pass="
					+ pass + ", reimb_avail=" + reimb_avail + ", reimb_pend=" + reimb_pend + ", reports_to="
					+ reports_to + ", reimb_award=" + reimb_award + "]";
		}
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
		public int getD_id() {
			return d_id;
		}
		public void setD_id(int d_id) {
			this.d_id = d_id;
		}
		public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public int getReimb_avail() {
			return reimb_avail;
		}
		public void setReimb_avail(int reimb_avail) {
			this.reimb_avail = reimb_avail;
		}
		public int getReimb_pend() {
			return reimb_pend;
		}
		public void setReimb_pend(int reimb_pend) {
			this.reimb_pend = reimb_pend;
		}
		public int getReports_to() {
			return reports_to;
		}
		public void setReports_to(int reports_to) {
			this.reports_to = reports_to;
		}
		public int getReimb_award() {
			return reimb_award;
		}
		public void setReimb_award(int reimb_award) {
			this.reimb_award = reimb_award;
		}
		
		
}
