package me.meedo.arcadetotalwins;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TotalWinsPlaceholder extends PlaceholderExpansion {

    @Override
    public @NotNull String getIdentifier() {
        return "arcadetotal"; // Replace with your unique identifier
    }

    @Override
    public @NotNull String getAuthor() {
        return "Meedo"; // Replace with your name or identifier
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0"; // Replace with your version
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        if (identifier.equalsIgnoreCase("wins")) {
            int totalWins = 0;
            totalWins += getTotalWins(p, "arcade_blockparty_wins");
            totalWins += getTotalWins(p, "arcade_bomblobbers_wins");
            totalWins += getTotalWins(p, "arcade_miniwalls_wins");
            totalWins += getTotalWins(p, "arcade_partygames_wins");
            totalWins += getTotalWins(p, "arcade_prophunt_wins");
            totalWins += getTotalWins(p, "arcade_quake_wins");
            totalWins += getTotalWins(p, "arcade_splegg_wins");
            totalWins += getTotalWins(p, "arcade_templerun_wins");
            totalWins += getTotalWins(p, "arcade_tntrun_wins");
            totalWins += getTotalWins(p, "arcade_tnttag_wins");

            return String.valueOf(totalWins);
        }
        return null;
    }

    private int getTotalWins(Player player, String placeholder) {
        String wins = PlaceholderAPI.setPlaceholders(player, "%" + placeholder + "%");
        try {
            return Integer.parseInt(wins);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
