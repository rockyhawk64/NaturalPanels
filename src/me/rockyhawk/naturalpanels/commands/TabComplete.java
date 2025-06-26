package me.rockyhawk.naturalpanels.commands;

import me.rockyhawk.naturalpanels.Context;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TabComplete implements TabCompleter {
    private final Context ctx;

    public TabComplete(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if(!sender.hasPermission("naturalpanels.command")) return null;

        ArrayList<String> output = new ArrayList<>();
        if(args.length == 1){
            if(sender.hasPermission("naturalpanels.command.open")) {
                output.add("open");
            }
            if(sender.hasPermission("naturalpanels.command.reload")) {
                output.add("reload");
            }
            if(sender.hasPermission("naturalpanels.command.help")) {
                output.add("help");
            }
            if(sender.hasPermission("naturalpanels.command.version")) {
                output.add("version");
            }
        }
        if(args.length == 2){
            if(args[0].equals("open")){
                output.addAll(ctx.plugin.panels.keySet());
            }
        }
        if(args.length == 3){
            if(args[0].equals("open")){
                for(Player player : Bukkit.getOnlinePlayers()){
                    output.add(player.getName());
                }
            }
        }
        return output;
    }
}