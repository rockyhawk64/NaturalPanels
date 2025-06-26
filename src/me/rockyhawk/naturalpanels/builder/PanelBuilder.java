package me.rockyhawk.naturalpanels.builder;

import com.fancyinnovations.fancydialogs.api.Dialog;
import com.fancyinnovations.fancydialogs.api.FancyDialogs;
import com.fancyinnovations.fancydialogs.api.data.DialogBodyData;
import com.fancyinnovations.fancydialogs.api.data.DialogData;
import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.panel.Panel;
import me.rockyhawk.naturalpanels.session.DialogSession;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PanelBuilder {
    private final Context ctx;
    private final ComponentBuilder componentsBuilder;

    public PanelBuilder(Context ctx) {
        this.ctx = ctx;
        componentsBuilder = new ComponentBuilder(ctx);
    }

    public void openPanel(Player p, Panel panel){
        Dialog dialog = constructDialog(p, panel);
        dialog.open(p);
    }

    private Dialog constructDialog(Player player, Panel panel) {
        YamlConfiguration config = panel.getConfig();
        DialogSession dialog = new DialogSession(panel.getName());

        String title = ctx.text.parseText(player, config.getString("title"));
        boolean closable = config.getBoolean("closable");
        List<String> text = config.getStringList("text");
        List<String> inputOrder = config.getStringList("input-order");
        List<String> buttonOrder = config.getStringList("button-order");

        // Create body components
        List<DialogBodyData> body = new ArrayList<>();
        for(String entry : text){
            DialogBodyData temp = new DialogBodyData(ctx.text.parseText(player, entry));
            body.add(temp);
        }

        // Build the dialog
        DialogData dialogData = new DialogData(
                panel.getName(),
                title,
                closable,
                body,
                componentsBuilder.inputBuilder(player, config, inputOrder),
                componentsBuilder.buttonBuilder(player, config, buttonOrder, dialog)
        );
        ctx.session.createSession(player, dialog);

        return FancyDialogs.get().createDialog(dialogData);
    }
}