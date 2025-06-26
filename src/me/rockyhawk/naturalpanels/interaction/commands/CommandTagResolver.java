package me.rockyhawk.naturalpanels.interaction.commands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.entity.Player;

public interface CommandTagResolver {
    /**
     * @return true if this tag handled the command and it shouldn't be dispatched further.
     */
    boolean handle(Context ctx, Panel panel, Player player, String command);
}