package census.query.dto.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import census.query.dto.RowDataListDeserializer;

public class Regions {
	private String isList;
	
	@JsonDeserialize(using = RowDataListDeserializer.class)
	private List<RowData> row = new ArrayList<>();
	
	public String getIsList() {
		return isList;
	}
	public void setIsList(String isList) {
		this.isList = isList;
	}
	public List<RowData> getRow() {
		return row;
	}
	public void setRow(List<RowData> row) {
		this.row = row;
	}
	@Override
	public String toString() {
		return "Regions [IsList=" + isList + ", Row=" + row + "]";
	}
	
	
}
