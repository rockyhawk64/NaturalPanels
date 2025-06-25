package me.rockyhawk.naturalpanels.commands.subcommands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.commands.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements SubCommand {
    private final Context ctx;

    public ReloadCommand(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getPermission() {
        return "naturalpanels.command.reload";
    }

    @Override
    public boolean execute(CommandSender sender, String[] args) {
        ctx.text.sendInfo(sender, "Plugin Reloaded.");
        return true;
    }
}
