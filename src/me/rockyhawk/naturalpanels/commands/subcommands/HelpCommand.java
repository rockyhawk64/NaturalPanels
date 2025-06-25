package me.rockyhawk.naturalpanels.commands.subcommands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.commands.SubCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements SubCommand {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getPermission() {
        return "naturalpanels.command.help";
    }

    @Override
    public boolean execute(Context ctx, CommandSender sender, String[] args) {
        ctx.text.sendInfo(sender, "Plugin Commands:");

        if (sender.hasPermission("naturalpanels.command.open")) {
            sender.sendMessage(Component.text("/np open <panel> [player] ", NamedTextColor.GOLD)
                    .append(Component.text("Opens a panel", NamedTextColor.WHITE)));
        }

        if (sender.hasPermission("naturalpanels.command.reload")) {
            sender.sendMessage(Component.text("/np reload ", NamedTextColor.GOLD)
                    .append(Component.text("Reloads all config and panel files", NamedTextColor.WHITE)));
        }

        if (sender.hasPermission("naturalpanels.command.help")) {
            sender.sendMessage(Component.text("/np help ", NamedTextColor.GOLD)
                    .append(Component.text("Shows this help menu", NamedTextColor.WHITE)));
        }

        return true;
    }
}
