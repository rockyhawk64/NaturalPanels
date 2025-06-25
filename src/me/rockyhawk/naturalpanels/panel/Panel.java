package me.rockyhawk.naturalpanels.panel;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Panel {
    /*This is the Panel object*/

    private final YamlConfiguration panelConfig;
    private final String panelName;

    //make the object
    public Panel(File panelFile) {
        String fileName = panelFile.getName();
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex > 0) {
            fileName = fileName.substring(0, dotIndex);
        }
        this.panelName = fileName;
        this.panelConfig = YamlConfiguration.loadConfiguration(panelFile);
    }

    public YamlConfiguration getConfig(){
        return panelConfig;
    }

    public String getName(){
        return panelName;
    }
}
