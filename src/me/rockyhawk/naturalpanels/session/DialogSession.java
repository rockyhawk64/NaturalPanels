package me.rockyhawk.naturalpanels.session;

import me.rockyhawk.naturalpanels.session.panel.Panel;
import me.rockyhawk.naturalpanels.session.panel.PanelData;

public class DialogSession {
    private Panel panel;
    private final PanelData data;

    public DialogSession(Panel panel){
        this.data = new PanelData();
        this.panel = panel;
    }

    // Basic getters and setters
    public PanelData getData(){
        return data;
    }
    public Panel getPanel(){
        return panel;
    }
    public void setPanel(Panel newPanel){
        panel = newPanel;
    }
}