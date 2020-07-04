package census.anatomy.event;

public enum CharacterEvent {
	ALL("all"),
	
    ACHIEVEMENT_EARNED("AchievementEarned"),
    BATTLE_RANK_UP("BattleRankUp"),
    DEATH("Death"),
    GAIN_EXPERIENCE("GainExperience"),
    ITEM_ADDED("ItemAdded"),
    PLAYER_FACILITY_CAPTURE("PlayerFacilityCapture"),
    PLAYER_FACILITY_DEFEND("PlayerFacilityDefend"),
    PLAYER_LOGIN("PlayerLogin"),
    PLAYER_LOGOUT("PlayerLogout"),
    SKILL_ADDED("SkillAdded"),
    VEHICLE_DESTROY("VehicleDestroy");
	
	private String value;
	
	private CharacterEvent(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
