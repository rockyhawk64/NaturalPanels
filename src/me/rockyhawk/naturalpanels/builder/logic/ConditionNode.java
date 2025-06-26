package me.rockyhawk.naturalpanels.builder.logic;

import me.rockyhawk.naturalpanels.Context;
import org.bukkit.entity.Player;

public interface ConditionNode {
    boolean evaluate(Player player, Context ctx);
}
