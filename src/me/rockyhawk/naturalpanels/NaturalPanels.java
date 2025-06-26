package me.rockyhawk.naturalpanels;

import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public class NaturalPanels extends JavaPlugin {
    public Context ctx;
    public File folder = new File(this.getDataFolder() + File.separator + "panels");
    public HashMap<String, YamlConfiguration> panels = new HashMap<>(); // String to index by panel name

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

    public static boolean openPanel(Player player, String panelName){
        NaturalPanels plugin = JavaPlugin.getPlugin(NaturalPanels.class);

        if (plugin.ctx.plugin.panels.get(panelName) == null) {
            return false;
        }
        Panel panel = new Panel(
                panelName,
                plugin.ctx.plugin.panels.get(panelName)
        );

        plugin.ctx.builder.openPanel(player, panel);
        return true;
    }
}