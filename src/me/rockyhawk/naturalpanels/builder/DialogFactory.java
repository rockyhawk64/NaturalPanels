package me.rockyhawk.naturalpanels.builder;

import com.fancyinnovations.fancydialogs.api.Dialog;
import com.fancyinnovations.fancydialogs.api.FancyDialogs;
import com.fancyinnovations.fancydialogs.api.data.DialogBodyData;
import com.fancyinnovations.fancydialogs.api.data.DialogButton;
import com.fancyinnovations.fancydialogs.api.data.DialogData;
import com.fancyinnovations.fancydialogs.api.data.inputs.DialogInputs;
import com.fancyinnovations.fancydialogs.api.data.inputs.DialogTextField;
import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.panel.Panel;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DialogFactory {
    private final Context ctx;

    public DialogFactory(Context ctx) {
        this.ctx = ctx;
    }

    public Dialog constructDialog(Player player, Panel panel) {
        YamlConfiguration config = panel.getConfig();

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

        // Iterate input text fields for dialog
        List<DialogTextField> inputs = new ArrayList<>();
        int order = 1;
        for(String entry : inputOrder){
            if(!config.contains("inputs." + entry)) continue;
            ConfigurationSection inputSection = config.getConfigurationSection("inputs." + entry);

            String inputKey = inputSection.getString("key");
            String inputLabel = inputSection.getString("label");
            String placeholder = inputSection.getString("placeholder");
            int maxLength = inputSection.getInt("max-length");
            int maxLines = inputSection.getInt("max-lines");

            DialogTextField textField = new DialogTextField(
                    ctx.text.parseText(player, inputKey),
                    ctx.text.parseText(player, inputLabel),
                    order,
                    ctx.text.parseText(player, placeholder),
                    maxLength,
                    maxLines
            );

            inputs.add(textField);
            order++;
        }

        // Iterate buttons for dialog
        List<DialogButton> buttons = new ArrayList<>();
        for(String entry : buttonOrder){
            if(!config.contains("buttons." + entry)) continue;
            ConfigurationSection buttonSection = config.getConfigurationSection("buttons." + entry);
            String buttonLabel = buttonSection.getString("label");
            String buttonTooltip = buttonSection.getString("tooltip");

            // Create actions for dialog buttons
            List<DialogButton.DialogAction> actions = new ArrayList<>();
            DialogButton.DialogAction action = new DialogButton.DialogAction("run_command", "say hello");
            actions.add(action);

            // Add button into dialog
            DialogButton button = new DialogButton(
                    ctx.text.parseText(player, buttonLabel),
                    ctx.text.parseText(player, buttonTooltip), actions);
            buttons.add(button);
        }

        // Build the dialog
        DialogData dialogData = new DialogData(
                panel.getName(),
                title,
                closable,
                body,
                new DialogInputs(inputs),
                buttons
        );

        return FancyDialogs.get().createDialog(dialogData);
    }
}