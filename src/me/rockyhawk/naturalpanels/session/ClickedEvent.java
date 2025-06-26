package me.rockyhawk.naturalpanels.session;

import com.fancyinnovations.fancydialogs.api.events.DialogButtonClickedEvent;
import me.rockyhawk.naturalpanels.Context;
import org.bukkit.Bukkit;
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
        if(dialog == null || !e.getDialogId().equals(dialog.getName())) return;

        YamlConfiguration config = ctx.plugin.panels.get(dialog.getName()).getConfig();
        ConfigurationSection buttonSection = config.getConfigurationSection("buttons." + dialog.getButton(e.getButtonId()));

        List<String> commands = buttonSection.getStringList("commands");
        for(String command : commands){
            Bukkit.getScheduler().runTask(ctx.plugin, () -> {
                Bukkit.dispatchCommand(e.getPlayer(), command);
            });
            if(command.startsWith("[open]")){
                ctx.builder.openPanel(e.getPlayer(), ctx.plugin.panels.get(command.substring(6).trim()));
            }
        }
    }
}
