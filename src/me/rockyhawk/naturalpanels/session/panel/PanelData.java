package me.rockyhawk.naturalpanels.session.panel;

import java.util.HashMap;

public class PanelData {
    // Data stored in the panel session the player has open
    // If a panel opens another panel the data will automatically follow the player until the panel is closed
    private final HashMap<String,String> data;

    public PanelData(){
        data = new HashMap<>();
    }

    // Data setters and getters
    public void setData(String placeholder, String value){
        data.put(placeholder,value);
    }
    public String getData(String placeholder){
        return data.get(placeholder);
    }
    public void removeData(String placeholder){
        data.remove(placeholder);
    }
}
