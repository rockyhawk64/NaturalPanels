package me.rockyhawk.naturalpanels.formatter;

import me.rockyhawk.naturalpanels.Context;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;

public class TextFormatter {
    private final Context ctx;
    private final TextComponent tag;

    public TextFormatter(Context ctx) {
        this.ctx = ctx;
        this.tag = Component.text("[NaturalPanels] ", NamedTextColor.GREEN);
    }

    // Basic formatters

    public void sendError(Audience audience, String msg) {
        audience.sendMessage(tag.append(Component.text(msg, NamedTextColor.RED)));
    }

    public void sendInfo(Audience audience, String msg) {
        audience.sendMessage(tag.append(Component.text(msg, NamedTextColor.WHITE)));
    }

    public void sendWarn(Audience audience, String msg) {
        audience.sendMessage(tag.append(Component.text(msg, NamedTextColor.YELLOW)));
    }

    // Access to tag
    public TextComponent getTag() {
        return tag;
    }
}