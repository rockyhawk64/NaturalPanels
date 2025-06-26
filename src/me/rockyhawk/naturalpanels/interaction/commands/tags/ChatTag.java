package me.rockyhawk.naturalpanels.interaction.commands.tags;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.interaction.commands.CommandTagResolver;
import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatTag implements CommandTagResolver {

    @Override
    public boolean isCorrectTag(String tag) {
        return tag.startsWith("[chat]");
    }

    @Override
    public void handle(Context ctx, Panel panel, Player player, String command) {
        Bukkit.getScheduler().runTask(ctx.plugin, () -> {
            player.chat(command);
        });
    }
}

