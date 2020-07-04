package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;
import census.query.dto.util.ImageObject;

public class ExperienceRank extends CensusCollectionImpl {

	private String rank;
	private String xp_max;
	private ImageObject vs;
	private String vs_image_path;
	private ImageObject nc;
	private String nc_image_path;
	private ImageObject tr;
	private String tr_image_path;
	
	public ExperienceRank() {
		super(Collection.EXPERIENCE_RANK);
		// TODO Auto-generated constructor stub
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getXp_max() {
		return xp_max;
	}

	public void setXp_max(String xp_max) {
		this.xp_max = xp_max;
	}

	public ImageObject getVs() {
		return vs;
	}

	public void setVs(ImageObject vs) {
		this.vs = vs;
	}

	public String getVs_image_path() {
		return vs_image_path;
	}

	public void setVs_image_path(String vs_image_path) {
		this.vs_image_path = vs_image_path;
	}

	public ImageObject getNc() {
		return nc;
	}

	public void setNc(ImageObject nc) {
		this.nc = nc;
	}

	public String getNc_image_path() {
		return nc_image_path;
	}

	public void setNc_image_path(String nc_image_path) {
		this.nc_image_path = nc_image_path;
	}

	public ImageObject getTr() {
		return tr;
	}

	public void setTr(ImageObject tr) {
		this.tr = tr;
	}

	public String getTr_image_path() {
		return tr_image_path;
	}

	public void setTr_image_path(String tr_image_path) {
		this.tr_image_path = tr_image_path;
	}

	@Override
	public String toString() {
		return "ExperienceRank [rank=" + rank + ", xp_max=" + xp_max + ", vs=" + vs + ", vs_image_path=" + vs_image_path
				+ ", nc=" + nc + ", nc_image_path=" + nc_image_path + ", tr=" + tr + ", tr_image_path=" + tr_image_path
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
