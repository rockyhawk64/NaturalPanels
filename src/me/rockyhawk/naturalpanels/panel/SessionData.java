package me.rockyhawk.naturalpanels.panel;

import java.util.HashMap;

public class SessionData {
    // Data stored in the panel session the player has open
    // If a panel opens another panel the data will automatically follow the player until the panel is closed
    public HashMap<String,String> keys;

    public void addData(String placeholder, String value){
        keys.put(placeholder,value);
    }

    public SessionData(){
        keys = new HashMap<>();
    }
}
