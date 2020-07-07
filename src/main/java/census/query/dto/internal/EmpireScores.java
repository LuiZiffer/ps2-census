package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.util.LanguageObject;

public class EmpireScores extends CensusCollectionImpl {

	private String tracker_name;
	private String tracker_description;
	private String start_date;
	private String start_time;
	private String end_date;
	private String end_time;
	private LanguageObject name;
	
	public EmpireScores() {
		super(Collection.EMPIRE_SCORES);
		// TODO Auto-generated constructor stub
	}

	public String getTracker_name() {
		return tracker_name;
	}

	public void setTracker_name(String tracker_name) {
		this.tracker_name = tracker_name;
	}

	public String getTracker_description() {
		return tracker_description;
	}

	public void setTracker_description(String tracker_description) {
		this.tracker_description = tracker_description;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public LanguageObject getName() {
		return name;
	}

	public void setName(LanguageObject name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmpireScores [tracker_name=" + tracker_name + ", tracker_description=" + tracker_description
				+ ", start_date=" + start_date + ", start_time=" + start_time + ", end_date=" + end_date + ", end_time="
				+ end_time + ", name=" + name + ", nestedCollections=" + nestedCollections + ", collection="
				+ collection + "]";
	}

}
