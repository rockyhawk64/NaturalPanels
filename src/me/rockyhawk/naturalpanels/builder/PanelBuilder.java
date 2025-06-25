package me.rockyhawk.naturalpanels.builder;

import com.fancyinnovations.fancydialogs.api.Dialog;
import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.panel.Panel;
import org.bukkit.entity.Player;

public class PanelBuilder {
    private final Context ctx;
    private final DialogFactory factory;

    public PanelBuilder(Context ctx) {
        this.ctx = ctx;
        factory = new DialogFactory(ctx);
    }

    public void openPanel(Player p, Panel panel){
        Dialog dialog = factory.constructDialog(p, panel);
        dialog.open(p);
    }
}