package me.rockyhawk.dialogpanels;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class NaturalPanels extends JavaPlugin {
    public Context ctx;

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