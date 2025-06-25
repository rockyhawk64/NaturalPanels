package me.rockyhawk.naturalpanels.formatter.placeholders;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.formatter.PlaceholderResolver;
import me.rockyhawk.naturalpanels.panel.SessionData;
import org.bukkit.OfflinePlayer;

public class DataPlaceholder implements PlaceholderResolver {
    @Override
    public String resolve(OfflinePlayer player, String identifier, Context ctx) {
        if (!identifier.startsWith("data_")) return null;

        // Check if identifier starts with "data_"
        String key = identifier.substring("data_".length());

        // TODO: Get the SessionData object for the player from your plugin
        // For now just a placeholder to avoid errors
        SessionData sessionData = null;

        if (sessionData == null) {
            return ""; // no data found, or session not active
        }

        String value = sessionData.keys.get(key);
        return value != null ? value : "";
    }
}
