package me.rockyhawk.naturalpanels.commands.subcommands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.commands.SubCommand;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements SubCommand {

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getPermission() {
        return "naturalpanels.command.reload";
    }

    @Override
    public boolean execute(Context ctx, CommandSender sender, String[] args) {
        ctx.fileHandler.reloadPanels();
        ctx.text.sendInfo(sender, "Plugin Reloaded.");
        return true;
    }
}
