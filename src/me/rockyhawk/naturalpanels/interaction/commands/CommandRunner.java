package me.rockyhawk.naturalpanels.interaction.commands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.interaction.commands.tags.*;
import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandRunner {
    private final Context ctx;
    private final List<CommandTagResolver> resolvers = new ArrayList<>();

    public CommandRunner(Context pl) {
        this.ctx = pl;
        registerResolvers();
    }

    private void registerResolvers() {
        resolvers.add(new OpenPanelTag());
        resolvers.add(new ConsoleCmdTag());
        resolvers.add(new ChatTag());
        resolvers.add(new MessageTag());
        resolvers.add(new ConfirmDialogTag());
    }

    public void runCommands(Context ctx, Panel panel, Player player, List<String> commands){
        for(String command : commands){
            runCommand(ctx, panel, player, command);
        }
    }

    public void runCommand(Context ctx, Panel panel, Player player, String command) {
        for (CommandTagResolver resolver : resolvers) {
            command = ctx.text.parseText(player, command.trim());
            if (command.isEmpty()) return;

            String[] parts = command.split("\\s+", 2); // Split into 2 parts: tag and rest

            String tag = parts[0];
            String args = (parts.length > 1) ? parts[1].trim() : "";

            if (resolver.isCorrectTag(tag)) {
                resolver.handle(ctx, panel, player, args);
                return;
            }
        }
    }
}