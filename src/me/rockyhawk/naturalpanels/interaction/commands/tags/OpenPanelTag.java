package me.rockyhawk.naturalpanels.interaction.commands.tags;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.interaction.commands.CommandTagResolver;
import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.entity.Player;

public class OpenPanelTag implements CommandTagResolver {

    @Override
    public boolean isCorrectTag(String tag) {
        return tag.startsWith("[open]");
    }

    @Override
    public void handle(Context ctx, Panel panel, Player player, String command) {
        if (ctx.plugin.panels.get(command) == null) {
            return;
        }
        Panel newPanel = new Panel(
                command,
                ctx.plugin.panels.get(command)
        );
        ctx.builder.openPanel(player, newPanel);
    }
}

