package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class ProjectileFlightType extends CensusCollectionImpl {

	private String projectile_flight_type_id;
	private String description;
	
	public ProjectileFlightType() {
		super(Collection.PROJECTILE_FLIGHT_TYPE);
		// TODO Auto-generated constructor stub
	}

	public String getProjectile_flight_type_id() {
		return projectile_flight_type_id;
	}

	public void setProjectile_flight_type_id(String projectile_flight_type_id) {
		this.projectile_flight_type_id = projectile_flight_type_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProjectileFlightType [projectile_flight_type_id=" + projectile_flight_type_id + ", description="
				+ description + ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}

	
}
