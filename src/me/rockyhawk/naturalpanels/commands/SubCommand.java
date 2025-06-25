package me.rockyhawk.naturalpanels.commands;

import me.rockyhawk.naturalpanels.Context;
import org.bukkit.command.CommandSender;

public interface SubCommand {
    String getName();
    String getPermission();
    boolean execute(Context ctx, CommandSender sender, String[] args);

}