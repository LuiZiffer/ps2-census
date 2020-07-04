package census.query.dto.util;

public class Times {

	private String creation;
	private String creation_date;
	private String last_save;
	private String last_save_date;
	private String last_login;
	private String last_login_date;
	private String login_count;
	private String minutes_played;
	public String getCreation() {
		return creation;
	}
	public void setCreation(String creation) {
		this.creation = creation;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getLast_save() {
		return last_save;
	}
	public void setLast_save(String last_save) {
		this.last_save = last_save;
	}
	public String getLast_save_date() {
		return last_save_date;
	}
	public void setLast_save_date(String last_save_date) {
		this.last_save_date = last_save_date;
	}
	public String getLast_login() {
		return last_login;
	}
	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}
	public String getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(String last_login_date) {
		this.last_login_date = last_login_date;
	}
	public String getLogin_count() {
		return login_count;
	}
	public void setLogin_count(String login_count) {
		this.login_count = login_count;
	}
	public String getMinutes_played() {
		return minutes_played;
	}
	public void setMinutes_played(String minutes_played) {
		this.minutes_played = minutes_played;
	}
	
	@Override
	public String toString() {
		return "Times [creation=" + creation + ", creation_date=" + creation_date + ", last_save=" + last_save
				+ ", last_save_date=" + last_save_date + ", last_login=" + last_login + ", last_login_date="
				+ last_login_date + ", login_count=" + login_count + ", minutes_played=" + minutes_played + "]";
	}
	
	

}
