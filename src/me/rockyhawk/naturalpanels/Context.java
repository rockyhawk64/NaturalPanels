package me.rockyhawk.naturalpanels;

import me.rockyhawk.naturalpanels.builder.PanelBuilder;
import me.rockyhawk.naturalpanels.commands.MainCommand;
import me.rockyhawk.naturalpanels.commands.TabComplete;
import me.rockyhawk.naturalpanels.formatter.Placeholders;
import me.rockyhawk.naturalpanels.formatter.TextFormatter;
import me.rockyhawk.naturalpanels.panel.Panel;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.Objects;

public class Context {
    public NaturalPanels plugin;
    public TextFormatter text;
    public PanelBuilder builder;
    public FileHandler fileHandler;

    public Context(NaturalPanels pl) {
        plugin = pl;
        init();
    }

    private void init(){
        text = new TextFormatter(this);

        plugin.getCommand("naturalpanels").setExecutor(new MainCommand(this));
        plugin.getCommand("naturalpanels").setTabCompleter(new TabComplete(this));

        if (Bukkit.getServer().getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            new Placeholders(this).register();
        }

        builder = new PanelBuilder(this);
        fileHandler = new FileHandler(this);
    }
}
