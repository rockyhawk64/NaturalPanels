package me.rockyhawk.naturalpanels.commands.subcommands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.commands.SubCommand;
import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenCommand implements SubCommand {

    @Override
    public String getName() {
        return "open";
    }

    @Override
    public String getPermission() {
        return "naturalpanels.command.open";
    }

    @Override
    public boolean execute(Context ctx, CommandSender sender, String[] args) {
        if (args.length < 1 || args.length > 2) {
            ctx.text.sendError(sender, "Usage: /np open <panelName> [playerName]");
            return true;
        }

        Panel panel = ctx.plugin.panels.get(args[0]);
        if (panel == null) {
            ctx.text.sendError(sender, "Panel '" + args[0] + "' not found.");
            return true;
        }

        Player target;

        if (args.length == 1) {
            if (!(sender instanceof Player)) {
                ctx.text.sendError(sender, "You must be a player to open a panel for yourself.");
                return true;
            }
            target = (Player) sender;
        } else {
            target = Bukkit.getPlayerExact(args[1]);
            if (target == null) {
                ctx.text.sendError(sender, "Player '" + args[1] + "' is not online.");
                return true;
            }
        }

        ctx.builder.openPanel(target, panel);
        return true;
    }
}
