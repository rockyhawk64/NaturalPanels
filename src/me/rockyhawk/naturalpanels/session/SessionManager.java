package me.rockyhawk.naturalpanels.session;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.session.panel.Panel;
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
    public void createSession(Player player, Panel panel){
        if(openDialogs.get(player) == null){
            DialogSession newSession = new DialogSession(panel);
            openDialogs.put(player, newSession);
        }else{
            openDialogs.get(player).setPanel(panel);
        }
    }

    public void removeSession(Player player){
        openDialogs.remove(player);
    }
}
