package census.query.dto.internal;

import census.anatomy.Collection;
import census.query.dto.CensusCollectionImpl;

public class GameServerStatus extends CensusCollectionImpl {

    private String name;
    private String game_code;
    private String game_name;
    private String region_code;
    private String region_name;
    private String last_reported_state;
    private String last_reported_date;
    private String last_reported_time;

    public GameServerStatus() {
        super(Collection.GAME_SERVER_STATUS);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGame_code() {
        return game_code;
    }

    public void setGame_code(String game_code) {
        this.game_code = game_code;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getRegion_code() {
        return region_code;
    }

    public void setRegion_code(String region_code) {
        this.region_code = region_code;
    }

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    public String getLast_reported_state() {
        return last_reported_state;
    }

    public void setLast_reported_state(String last_reported_state) {
        this.last_reported_state = last_reported_state;
    }

    public String getLast_reported_date() {
        return last_reported_date;
    }

    public void setLast_reported_date(String last_reported_date) {
        this.last_reported_date = last_reported_date;
    }

    public String getLast_reported_time() {
        return last_reported_time;
    }

    public void setLast_reported_time(String last_reported_time) {
        this.last_reported_time = last_reported_time;
    }

    @Override
    public String toString() {
        return "GameServerStatus{" +
                "nestedCollections=" + nestedCollections +
                ", collection=" + collection +
                ", name='" + name + '\'' +
                ", game_code='" + game_code + '\'' +
                ", game_name='" + game_name + '\'' +
                ", region_code='" + region_code + '\'' +
                ", region_name='" + region_name + '\'' +
                ", last_reported_state='" + last_reported_state + '\'' +
                ", last_reported_date='" + last_reported_date + '\'' +
                ", last_reported_time='" + last_reported_time + '\'' +
                '}';
    }
}
