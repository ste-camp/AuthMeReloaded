package fr.xephi.authme.datasource;

import java.sql.SQLException;
import java.util.List;

import fr.xephi.authme.cache.auth.PlayerAuth;

public interface DataSource {

    enum DataSourceType {
        MYSQL,
        FILE,
        SQLITE,
        SQLITEHIKARI
    }

    boolean isAuthAvailable(String user);

    PlayerAuth getAuth(String user);

    boolean saveAuth(PlayerAuth auth);

    boolean updateSession(PlayerAuth auth);

    boolean updatePassword(PlayerAuth auth);

    int purgeDatabase(long until);

    List<String> autoPurgeDatabase(long until);

    boolean removeAuth(String user);

    boolean updateQuitLoc(PlayerAuth auth);

    int getIps(String ip);

    List<String> getAllAuthsByName(PlayerAuth auth);

    List<String> getAllAuthsByIp(String ip) throws Exception;

    List<String> getAllAuthsByEmail(String email) throws Exception;

    boolean updateEmail(PlayerAuth auth);

    boolean updateSalt(PlayerAuth auth);

    void close();

    void reload();

    void purgeBanned(List<String> banned);

    DataSourceType getType();

    boolean isLogged(String user);

    void setLogged(String user);

    void setUnlogged(String user);

    void purgeLogged();

    int getAccountsRegistered();

    void updateName(String oldone, String newone);

    List<PlayerAuth> getAllAuths();

    List<PlayerAuth> getLoggedPlayers();

}
