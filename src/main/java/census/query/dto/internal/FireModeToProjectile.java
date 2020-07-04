package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class FireModeToProjectile extends CensusCollectionImpl {

	private String fire_mode_id;
	private String projectile_id;
	
	public FireModeToProjectile() {
		super(Collection.FIRE_MODE_TO_PROJECTILE);
		// TODO Auto-generated constructor stub
	}

	public String getFire_mode_id() {
		return fire_mode_id;
	}

	public void setFire_mode_id(String fire_mode_id) {
		this.fire_mode_id = fire_mode_id;
	}

	public String getProjectile_id() {
		return projectile_id;
	}

	public void setProjectile_id(String projectile_id) {
		this.projectile_id = projectile_id;
	}

	@Override
	public String toString() {
		return "FireModeToProjectile [fire_mode_id=" + fire_mode_id + ", projectile_id=" + projectile_id
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

}
