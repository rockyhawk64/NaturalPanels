package me.rockyhawk.naturalpanels.session.panel;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;

public class Panel {
    /*This is the Panel object*/

    private final YamlConfiguration panelConfig;
    private final String panelName;

    // Maps the button name in the dialog to its UUID
    private final HashMap<String,String> buttonIds;

    //make the object
    public Panel(String name, YamlConfiguration config) {
        this.panelName = name;
        this.panelConfig = config;
        this.buttonIds = new HashMap<>();
    }

    // Button setters and getters
    public void setButton(String id, String name){
        buttonIds.put(id, name);
    }
    public String getButton(String id){
        return buttonIds.get(id);
    }

    public YamlConfiguration getConfig(){
        return panelConfig;
    }

    public String getName(){
        return panelName;
    }
}
