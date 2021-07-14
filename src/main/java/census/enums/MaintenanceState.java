package census.enums;

public enum MaintenanceState {
    LIVE("live"),
    LOCKED("locked"),
    OFFLINE("offline");

    private String name;

    private MaintenanceState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
