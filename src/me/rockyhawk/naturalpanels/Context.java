package me.rockyhawk.naturalpanels;

import me.rockyhawk.naturalpanels.commands.MainCommand;
import me.rockyhawk.naturalpanels.formatter.TextFormatter;

public class Context {
    public NaturalPanels plugin;
    public TextFormatter text;

    public Context(NaturalPanels pl) {
        plugin = pl;
        init();
    }

    private void init(){
        text = new TextFormatter(this);
        plugin.getCommand("naturalpanels").setExecutor(new MainCommand(this));
    }
}
