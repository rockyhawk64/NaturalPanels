package me.rockyhawk.naturalpanels.commands;

import org.bukkit.command.CommandSender;

public interface SubCommand {
    String getName();
    String getPermission();
    boolean execute(CommandSender sender, String[] args);

}