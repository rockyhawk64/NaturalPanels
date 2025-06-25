package me.rockyhawk.naturalpanels.builder;

import com.fancyinnovations.fancydialogs.api.Dialog;
import com.fancyinnovations.fancydialogs.api.FancyDialogs;
import com.fancyinnovations.fancydialogs.api.data.DialogBodyData;
import com.fancyinnovations.fancydialogs.api.data.DialogButton;
import com.fancyinnovations.fancydialogs.api.data.DialogData;
import com.fancyinnovations.fancydialogs.api.data.inputs.DialogInputs;
import com.fancyinnovations.fancydialogs.api.data.inputs.DialogTextField;
import me.rockyhawk.naturalpanels.Context;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class REFERENCE {
    private final Context ctx;

    public REFERENCE(Context ctx) {
        this.ctx = ctx;
    }

    public Dialog constructDialog(Player player, String name, YamlConfiguration config) {
        // Create body components
        List<DialogBodyData> components = new ArrayList<>();
        DialogBodyData textComponent1 = new DialogBodyData("test body data 1");
        DialogBodyData textComponent2 = new DialogBodyData("test body data 2");
        components.add(textComponent1);
        components.add(textComponent2);

        // Create input fields
        List<DialogTextField> inputs = new ArrayList<>();
        DialogTextField textField = new DialogTextField(
                "key",
                "label",
                1,
                "placeholder",
                1,
                1);
        inputs.add(textField);

        DialogInputs dialogInputs = new DialogInputs(inputs);

        // Create buttons
        List<DialogButton.DialogAction> actions = new ArrayList<>();
        DialogButton.DialogAction action = new DialogButton.DialogAction("open_url", "https://google.com.au");
        actions.add(action);

        DialogButton submitButton = new DialogButton("Click me", "hover text tooltip", actions);

        // Assemble DialogData
//        DialogData dialogData = new DialogData(
//                "welcome_dialog",
//                "Welcome!",
//                true,
//                components,
//                dialogInputs,
//                List.of(submitButton)
//        );

        DialogTextField textField1 = new DialogTextField(
                "k", "l", 1, "p", 1, 1
        );

        DialogData dialogData = new DialogData(
                "test_id",
                "T",
                true,
                List.of(new DialogBodyData("x")),
                new DialogInputs(List.of(textField1)),
                List.of(new DialogButton("Ok", "", List.of()))
        );

        // Create and return the dialog
        return FancyDialogs.get().createDialog(dialogData);
    }
}