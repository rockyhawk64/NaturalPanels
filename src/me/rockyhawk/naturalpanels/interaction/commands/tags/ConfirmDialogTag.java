package me.rockyhawk.naturalpanels.interaction.commands.tags;

import com.fancyinnovations.fancydialogs.api.ConfirmationDialog;
import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.interaction.commands.CommandTagResolver;
import me.rockyhawk.naturalpanels.session.panel.Panel;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ConfirmDialogTag implements CommandTagResolver {

    @Override
    public boolean isCorrectTag(String tag) {
        return tag.startsWith("[confirm]");
    }

    @Override
    public void handle(Context ctx, Panel panel, Player player, String command) {
        Bukkit.getScheduler().runTask(ctx.plugin, () -> {
            ConfirmationDialog dialog = new ConfirmationDialog("Please confirm to continue.")
                    .withTitle("Confirmation")
                    .withOnConfirm(() -> ctx.commands.runCommand(ctx, panel, player, command))
                    .withOnCancel(() -> ctx.builder.openPanel(player, panel));

            dialog.ask(player);
        });
    }
}

