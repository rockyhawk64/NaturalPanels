package me.rockyhawk.naturalpanels.formatter;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.rockyhawk.naturalpanels.Context;
import org.bukkit.OfflinePlayer;

import java.util.ArrayList;
import java.util.List;

public class Placeholders extends PlaceholderExpansion {
    private final Context ctx;
    private final List<PlaceholderResolver> resolvers = new ArrayList<>();

    public Placeholders(Context pl) {
        this.ctx = pl;
        loadPlaceholders();
    }

    private void loadPlaceholders(){
        //resolvers.add(new CheckInventoryPlaceholder());
    }

    @Override
    public String getAuthor() {
        return "RockyHawk";
    }

    @Override
    public String getIdentifier() {
        return "naturalpanels";
    }

    @Override
    public String getVersion() {
        return ctx.plugin.getDescription().getVersion();
    }

    @Override
    public String onRequest(OfflinePlayer player, String params) {
        if (player == null) return "";

        for (PlaceholderResolver resolver : resolvers) {
            try {
                String value = resolver.resolve(player, params, ctx);
                if(value != null){
                    return value;
                }
            } catch (Exception e) {
                return "";
            }
        }
        return "";
    }

}
