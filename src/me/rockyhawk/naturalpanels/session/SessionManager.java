package me.rockyhawk.naturalpanels.session;

import me.rockyhawk.naturalpanels.Context;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private final Context ctx;

    public SessionManager(Context pl) {
        this.ctx = pl;
    }

    private final Map<Player, DialogSession> openDialogs = new HashMap<>();

    public DialogSession getPlayerSession(Player player){
        return openDialogs.get(player);
    }
    public void createSession(Player player, DialogSession session){
        openDialogs.put(player, session);
    }
}
