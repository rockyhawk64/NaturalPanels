package me.rockyhawk.naturalpanels.commands;

import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.commands.subcommands.HelpCommand;
import me.rockyhawk.naturalpanels.commands.subcommands.OpenCommand;
import me.rockyhawk.naturalpanels.commands.subcommands.ReloadCommand;
import me.rockyhawk.naturalpanels.commands.subcommands.VersionCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class MainCommand implements CommandExecutor {
    private final Context ctx;
    private final Map<String, SubCommand> subCommands = new HashMap<>();

    public MainCommand(Context ctx) {
        this.ctx = ctx;
        registerSubCommands();
    }

    private void registerSubCommands() {
        register(new ReloadCommand());
        register(new OpenCommand());
        register(new HelpCommand());
        register(new VersionCommand());
    }

    private void register(SubCommand subCommand) {
        subCommands.put(subCommand.getName().toLowerCase(), subCommand);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!sender.hasPermission("naturalpanels.command")) {
            ctx.text.sendError(sender, "No permission.");
            return true;
        }

        if (args.length == 0) {
            ctx.text.sendError(sender, "Use /np help for a list of subcommands.");
            return true;
        }

        SubCommand subCommand = subCommands.get(args[0].toLowerCase());
        if (subCommand == null) {
            ctx.text.sendError(sender, "Unknown subcommand. Use /np help.");
            return true;
        }

        if (subCommand.getPermission() != null && !subCommand.getPermission().isEmpty() && !sender.hasPermission(subCommand.getPermission())) {
            ctx.text.sendError(sender, "No permission.");
            return true;
        }

        // Pass the remaining args after the subcommand name
        String[] subArgs = args.length > 1 ? java.util.Arrays.copyOfRange(args, 1, args.length) : new String[0];

        return subCommand.execute(ctx, sender, subArgs);
    }
}