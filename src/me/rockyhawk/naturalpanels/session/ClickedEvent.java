package me.rockyhawk.naturalpanels.session;

import com.fancyinnovations.fancydialogs.api.events.DialogButtonClickedEvent;
import me.rockyhawk.naturalpanels.Context;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class ClickedEvent implements Listener {

    private final Context ctx;

    public ClickedEvent(Context pl) {
        this.ctx = pl;
    }

    @EventHandler
    public void onDialogClicked(DialogButtonClickedEvent e){
        DialogSession dialog = ctx.session.getPlayerSession(e.getPlayer());
        if(dialog.getPanel() == null || !e.getDialogId().equals(dialog.getPanel().getName())) return;

        YamlConfiguration config = dialog.getPanel().getConfig();
        ConfigurationSection buttonSection = config.getConfigurationSection("buttons." + dialog.getPanel().getButton(e.getButtonId()));

        List<String> commands = buttonSection.getStringList("commands");
        ctx.commands.runCommands(ctx, dialog.getPanel(), e.getPlayer(), commands);
    }
}
