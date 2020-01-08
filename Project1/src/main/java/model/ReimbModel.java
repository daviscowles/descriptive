package model;



public class ReimbModel {

		private int r_id;
		private int u_id;
		private int g_id;
		private int e_id;
		private int r_date; 
		private int r_time;
		private String r_address;
		private int r_cost;
		private String r_desc;
		private int cutoff;
		private int curr_user;
		private int pending;
		private String justify;
		
		
		
		public ReimbModel() {
			super();
		}
		
		
		public String getJustify() {
			return justify;
		}


		public void setJustify(String justify) {
			this.justify = justify;
		}

		public ReimbModel(int r_id, int u_id, int g_id, int e_id, int r_date, int r_time, String r_address, int r_cost,
				String r_desc, int cutoff, String justify) {
			super();
			this.r_id = r_id;
			this.u_id = u_id;
			this.g_id = g_id;
			this.e_id = e_id;
			this.r_date = r_date;
			this.r_time = r_time;
			this.r_address = r_address;
			this.r_cost = r_cost;
			this.r_desc = r_desc;
			this.cutoff = cutoff;
			this.justify = justify;
			
		}
		
		public ReimbModel(int u_id, int g_id, int e_id, int r_date, int r_time, String r_address, int r_cost,
				String r_desc, int cutoff, String justify) {
			super();
			this.u_id = u_id;
			this.g_id = g_id;
			this.e_id = e_id;
			this.r_date = r_date;
			this.r_time = r_time;
			this.r_address = r_address;
			this.r_cost = r_cost;
			this.r_desc = r_desc;
			this.cutoff = cutoff;
			this.justify = justify;
			
		}
		public ReimbModel(int r_id, int u_id, int g_id, int e_id, int r_date, int r_time, String r_address,
				int r_cost, String r_desc, int cutoff, int curr_user, int pending) {
			super();
			this.r_id = r_id;
			this.u_id = u_id;
			this.g_id = g_id;
			this.e_id = e_id;
			this.r_date = r_date;
			this.r_time = r_time;
			this.r_address = r_address;
			this.r_cost = r_cost;
			this.r_desc = r_desc;
			this.cutoff = cutoff;
			this.curr_user = curr_user;
			this.pending = pending;
		}
		
		public ReimbModel(int u_id, int g_id, int e_id, int r_date, int r_time, String r_address,
				int r_cost, String r_desc, int cutoff, int curr_user, int pending) {
			super();
			
			this.u_id = u_id;
			this.g_id = g_id;
			this.e_id = e_id;
			this.r_date = r_date;
			this.r_time = r_time;
			this.r_address = r_address;
			this.r_cost = r_cost;
			this.r_desc = r_desc;
			this.cutoff = cutoff;
			this.curr_user = curr_user;
			this.pending = pending;
		}
		public ReimbModel(int u_id, int g_id, int e_id, int r_date, int r_time, String r_address,
				int r_cost, String r_desc, int cutoff) {
			super();
			
			this.u_id = u_id;
			this.g_id = g_id;
			this.e_id = e_id;
			this.r_date = r_date;
			this.r_time = r_time;
			this.r_address = r_address;
			this.r_cost = r_cost;
			this.r_desc = r_desc;
			this.cutoff = cutoff;
			
		}


		@Override
		public String toString() {
			return "ReimbursementModel [r_id=" + r_id + ", u_id=" + u_id + ", g_id=" + g_id + ", e_id=" + e_id
					+ ", r_date=" + r_date + ", r_time=" + r_time + ", r_address=" + r_address + ", r_cost=" + r_cost
					+ ", r_desc=" + r_desc + ", cutoff=" + cutoff + ", curr_user=" + curr_user + ", pending=" + pending
					+ "]";
		}
		public int getR_id() {
			return r_id;
		}
		public void setR_id(int r_id) {
			this.r_id = r_id;
		}
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
		public int getG_id() {
			return g_id;
		}
		public void setG_id(int g_id) {
			this.g_id = g_id;
		}
		public int getE_id() {
			return e_id;
		}
		public void setE_id(int e_id) {
			this.e_id = e_id;
		}
		public int getR_date() {
			return r_date;
		}
		public void setR_date(int r_date) {
			this.r_date = r_date;
		}
		public int getR_time() {
			return r_time;
		}
		public void setR_time(int r_time) {
			this.r_time = r_time;
		}
		public String getR_address() {
			return r_address;
		}
		public void setR_address(String r_address) {
			this.r_address = r_address;
		}
		public int getR_cost() {
			return r_cost;
		}
		public void setR_cost(int r_cost) {
			this.r_cost = r_cost;
		}
		public String getR_desc() {
			return r_desc;
		}
		public void setR_desc(String r_desc) {
			this.r_desc = r_desc;
		}
		public int getCutoff() {
			return cutoff;
		}
		public void setCutoff(int cutoff) {
			this.cutoff = cutoff;
		}
		public int getCurr_user() {
			return curr_user;
		}
		public void setCurr_user(int curr_user) {
			this.curr_user = curr_user;
		}
		public int getPending() {
			return pending;
		}
		public void setPending(int pending) {
			this.pending = pending;
		}
		
		
}
