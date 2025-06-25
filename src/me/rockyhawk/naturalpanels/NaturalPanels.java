package me.rockyhawk.naturalpanels;

import me.rockyhawk.naturalpanels.panel.Panel;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class NaturalPanels extends JavaPlugin {
    public Context ctx;
    HashMap<String, Panel> panels = new HashMap<>(); // String to index by panel name

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("[NaturalPanels] RockyHawk's NaturalPanels v" + this.getDescription().getVersion() + " Plugin Loading...");
        ctx = new Context(this);
    }

    public void onDisable() {
        //If the plugin was unable to initialise
        if (ctx == null) {
            Bukkit.getConsoleSender().sendMessage("[NaturalPanels] RockyHawk's NaturalPanels Plugin Disabled.");
            return;
        }


    }
}