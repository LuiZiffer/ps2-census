package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;
import census.query.dto.ICensusCollection;

public class Projectile extends CensusCollectionImpl {

	private String projectile_id;
	private String projectile_flight_type_id;
	private String speed;
	private String lifespan;
	private String drag;
	private String gravity;
	
	public Projectile() {
		super(Collection.PROJECTILE);
		// TODO Auto-generated constructor stub
	}

	public String getProjectile_id() {
		return projectile_id;
	}

	public void setProjectile_id(String projectile_id) {
		this.projectile_id = projectile_id;
	}

	public String getProjectile_flight_type_id() {
		return projectile_flight_type_id;
	}

	public void setProjectile_flight_type_id(String projectile_flight_type_id) {
		this.projectile_flight_type_id = projectile_flight_type_id;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getLifespan() {
		return lifespan;
	}

	public void setLifespan(String lifespan) {
		this.lifespan = lifespan;
	}

	public String getDrag() {
		return drag;
	}

	public void setDrag(String drag) {
		this.drag = drag;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}

	@Override
	public String toString() {
		return "Projectile [projectile_id=" + projectile_id + ", projectile_flight_type_id=" + projectile_flight_type_id
				+ ", speed=" + speed + ", lifespan=" + lifespan + ", drag=" + drag + ", gravity=" + gravity
				+ ", nestedCollections=" + nestedCollections + ", collection=" + collection + "]";
	}


}
