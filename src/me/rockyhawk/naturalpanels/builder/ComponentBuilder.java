package me.rockyhawk.naturalpanels.builder;

import com.fancyinnovations.fancydialogs.api.data.DialogButton;
import com.fancyinnovations.fancydialogs.api.data.inputs.DialogInputs;
import com.fancyinnovations.fancydialogs.api.data.inputs.DialogTextField;
import com.fancyinnovations.fancydialogs.api.events.DialogButtonClickedEvent;
import me.rockyhawk.naturalpanels.Context;
import me.rockyhawk.naturalpanels.session.DialogSession;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ComponentBuilder {
    private final Context ctx;

    public ComponentBuilder(Context ctx) {
        this.ctx = ctx;
    }

    public List<DialogButton> buttonBuilder(
            Player player,
            YamlConfiguration config,
            List<String> buttonOrder,
            DialogSession dialog){
        List<DialogButton> buttons = new ArrayList<>();
        // Iterate buttons for dialog
        for(String entry : buttonOrder){
            if(!config.contains("buttons." + entry)) continue;
            ConfigurationSection buttonSection = config.getConfigurationSection("buttons." + entry);
            String buttonLabel = buttonSection.getString("label");
            String buttonTooltip = buttonSection.getString("tooltip");

            // Create actions for dialog buttons
            List<DialogButton.DialogAction> actions = new ArrayList<>();
            String actionType = buttonSection.getString("action.type");
            String actionData = buttonSection.getString("action.data");
            DialogButton.DialogAction action = new DialogButton.DialogAction(
                    ctx.text.parseText(player, actionType),
                    ctx.text.parseText(player, actionData));
            actions.add(action);

            // Add button into dialog
            DialogButton button = new DialogButton(
                    ctx.text.parseText(player, buttonLabel),
                    ctx.text.parseText(player, buttonTooltip), actions);
            buttons.add(button);
            dialog.setButton(button.id(), entry);
        }
        return buttons;
    }

    public DialogInputs inputBuilder(Player player, YamlConfiguration config, List<String> inputOrder){
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
        return new DialogInputs(inputs);
    }
}
