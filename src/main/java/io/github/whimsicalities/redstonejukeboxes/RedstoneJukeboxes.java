package io.github.whimsicalities.redstonejukeboxes;

import io.github.whimsicalities.redstonejukeboxes.listeners.JukeboxPoweredListener;
import org.bukkit.plugin.java.JavaPlugin;

public class RedstoneJukeboxes extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        JukeboxPoweredListener jukeboxPoweredListener = new JukeboxPoweredListener();
        getServer().getPluginManager().registerEvents(jukeboxPoweredListener, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
