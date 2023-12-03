package me.meedo.arcadetotalwins;

import org.bukkit.plugin.java.JavaPlugin;

public final class ArcadeTotalWins extends JavaPlugin{

    @Override
    public void onEnable() {
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            new TotalWinsPlaceholder().register();
        } else {
            getLogger().severe("PlaceholderAPI not found! ArcadeTotalWins requires PlaceholderAPI to work.");
            getServer().getPluginManager().disablePlugin(this);
        }
    }
}