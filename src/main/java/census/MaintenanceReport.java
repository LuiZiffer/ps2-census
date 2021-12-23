package census;

import census.anatomy.Collection;
import census.anatomy.Constants;
import census.anatomy.Namespace;
import census.exception.CensusException;
import census.logging.LoggingConstants;
import census.query.dto.ICensusCollection;
import census.query.dto.internal.GameServerStatus;
import census.query.dto.internal.World;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.ErrorManager;
import java.util.stream.Collectors;

public class MaintenanceReport {

    private static final Logger logger = LoggerFactory.getLogger(MaintenanceReport.class);
    private final List<World> worldStatusList;
    private final List<GameServerStatus> serverStatusList;
    private final boolean gameMaintenanceFlag;
    private final boolean launcherMaintenanceFlag;

    protected MaintenanceReport(List<World> worldStatusList, List<GameServerStatus> serverStatusList,
                                boolean gameMaintenanceFlag, boolean launcherMaintenanceFlag) {
        this.worldStatusList = worldStatusList;
        this.serverStatusList = serverStatusList;
        this.gameMaintenanceFlag = gameMaintenanceFlag;
        this.launcherMaintenanceFlag = launcherMaintenanceFlag;
    }

    private static List<World> getWorldStatus(String serviceId) throws CensusException, IOException {
        Query worldStatus = new Query(Collection.WORLD, serviceId).show("state", "world_id").limit(100);
        worldStatus.maintenanceCheck = true;
        List<ICensusCollection> list = worldStatus.getAndParse();
        if (list != null) return list.stream().map(world -> (World) world).collect(Collectors.toList());
        return null;
    }

    private static List<GameServerStatus> getGameServerStatus(String serviceId) throws CensusException, IOException {
        Query servStatus = new Query(Collection.GAME_SERVER_STATUS, serviceId,
                Constants.CENSUS_ENDPOINT.toString(), Namespace.GLOBAL)
                .filter("game_code", "ps2")
                .limit(10);
        servStatus.maintenanceCheck = true;
        List<ICensusCollection> list = servStatus.getAndParse();
        if (list != null) return list.stream().map(status -> (GameServerStatus) status).collect(Collectors.toList());
        return null;
    }

    private static boolean getGameMaintenanceFlag() throws IOException {
        Response response = CensusHttpClient.getHttpClient().newCall(new Request.Builder()
                .url("https://www.daybreakgames.com/status")
                .build()).execute();

        InputStream is = response.body().byteStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String maintenanceGames = reader.lines()
                .filter(line -> line.contains("window.SOE.maintenanceGames"))
                .findFirst().orElse(null);
        response.close();
        return maintenanceGames != null && maintenanceGames.contains("ps2");
    }

    private static boolean getLauncherMaintenanceFlag() throws IOException {
        Response response = CensusHttpClient.getHttpClient().newCall(new Request.Builder()
                .url("http://lpj.daybreakgames.com/ps2/live/")
                .build()).execute();
        InputStream is = response.body().byteStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String str1 = "maintenanceOverride", str2 = "in_maintenance";

        List<String> check = reader.lines()
                .filter(line -> line.contains(str1) || line.contains(str2))
                .map(line -> line.contains(str1) && line.contains(str2) ?
                        str1 + str2 : line.contains(str1) ? str1 : str2)
                .collect(Collectors.toList());

        response.close();
        return check.contains(str1 + str2) || check.containsAll(Arrays.asList(str1, str2));
    }

    public static MaintenanceReport createReport(String serviceId) {
        List<World> worldStatus = null;
        List<GameServerStatus> gameServerStatus = null;
        boolean isGameMaintenance = false;
        boolean isLauncherMaintenance = false;
        try {
            worldStatus = getWorldStatus(serviceId);
        } catch (Exception e) {
            //ignore
        }
        try {
            gameServerStatus = getGameServerStatus(serviceId);
        } catch (Exception e) {
            //ignore
        }
        try {
            isGameMaintenance = getGameMaintenanceFlag();
        } catch (Exception e) {
            //ignore
        }
        try {
            isLauncherMaintenance = getLauncherMaintenanceFlag();
        } catch (Exception e) {
            //ignore
        }

        return new MaintenanceReport(worldStatus, gameServerStatus,
                isGameMaintenance, isLauncherMaintenance);
    }

    public List<World> getWorldStatusList() {
        return Collections.unmodifiableList(worldStatusList);
    }

    public List<GameServerStatus> getServerStatusList() {
        return Collections.unmodifiableList(serverStatusList);
    }

    public boolean isGameMaintenanceFlag() {
        return gameMaintenanceFlag;
    }

    public boolean isLauncherMaintenanceFlag() {
        return launcherMaintenanceFlag;
    }

    @Override
    public String toString() {
        return "MaintenanceReport{" +
                "worldStatusList=" + worldStatusList +
                ", serverStatusList=" + serverStatusList +
                ", gameMaintenanceFlag=" + gameMaintenanceFlag +
                ", launcherMaintenanceFlag=" + launcherMaintenanceFlag +
                '}';
    }
}
