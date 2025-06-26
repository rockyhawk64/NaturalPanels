package me.rockyhawk.naturalpanels.session;

import java.util.HashMap;

public class DialogSession {
    // Data stored in the panel session the player has open
    // If a panel opens another panel the data will automatically follow the player until the panel is closed
    private final HashMap<String,String> data;

    // Maps the button name in the dialog to its UUID
    private final HashMap<String,String> buttonIds;
    private final String dialogName;

    public DialogSession(String name){
        data = new HashMap<>();
        buttonIds = new HashMap<>();
        dialogName = name;
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

    // Button setters and getters
    public void setButton(String id, String name){
        buttonIds.put(id, name);
    }
    public String getButton(String id){
        return buttonIds.get(id);
    }

    // Get dialog name
    public String getName(){
        return dialogName;
    }
}