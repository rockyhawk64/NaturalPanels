package me.rockyhawk.naturalpanels.formatter;

import me.rockyhawk.naturalpanels.Context;
import org.bukkit.OfflinePlayer;

public interface PlaceholderResolver {
    String resolve(OfflinePlayer p, String identifier, Context ctx);
}
