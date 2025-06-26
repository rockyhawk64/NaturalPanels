package me.rockyhawk.naturalpanels.formatter.placeholders;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.formatter.PlaceholderResolver;
import me.rockyhawk.naturalpanels.session.DialogSession;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class DataPlaceholder implements PlaceholderResolver {
    @Override
    public String resolve(OfflinePlayer player, String identifier, Context ctx) {
        if (!identifier.startsWith("data_")) return null;
        if(!player.isOnline()) return null;

        // Check if identifier starts with "data_"
        String key = identifier.substring("data_".length());

        // Get session if it exists
        DialogSession session = ctx.session.getPlayerSession((Player) player);
        if(session == null) return null;

        // Get the data from session
        String data = session.getData(ctx.text.parseText((Player) player, key));

        String value = ctx.text.parseText((Player) player, data);
        return value != null ? value : "";
    }
}
