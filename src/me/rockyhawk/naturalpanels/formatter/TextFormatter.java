package me.rockyhawk.naturalpanels.formatter;

import me.clip.placeholderapi.PlaceholderAPI;
import me.rockyhawk.naturalpanels.Context;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

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

    public String parseText(Player player, String input) {
        if (input == null || input.isEmpty()) return input;

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            OfflinePlayer offp = Bukkit.getOfflinePlayer(player.getUniqueId());
            input = PlaceholderAPI.setPlaceholders(offp, input);
        }

        try {
            Component component = MiniMessage.miniMessage().deserialize(input);
            return MiniMessage.miniMessage().serialize(component);
        } catch (Exception e) {
            return input; // just return raw if parsing fails
        }
    }

    // Access to tag
    public TextComponent getTag() {
        return tag;
    }
}