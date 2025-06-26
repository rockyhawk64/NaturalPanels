package me.rockyhawk.naturalpanels.commands.subcommands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.commands.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.CommandSender;

public class VersionCommand implements SubCommand {

    @Override
    public String getName() {
        return "version";
    }

    @Override
    public String getPermission() {
        return "naturalpanels.command.version";
    }

    @Override
    public boolean execute(Context ctx, CommandSender sender, String[] args) {
        ctx.text.sendInfo(sender, "");
        sender.sendMessage(Component.text("Version ", NamedTextColor.DARK_GREEN)
                    .append(Component.text(ctx.plugin.getDescription().getVersion(), NamedTextColor.WHITE)));
        return true;
    }
}
