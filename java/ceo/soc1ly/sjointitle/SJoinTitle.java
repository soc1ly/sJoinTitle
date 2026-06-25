package ceo.soc1ly.sjointitle;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import ceo.soc1ly.sjointitle.PlayerJoinListener;
import ceo.soc1ly.sjointitle.ReloadCommand;

public final class SJoinTitle extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        getCommand("sjt").setExecutor(new ReloadCommand(this));
    }

    @Override
    public void onDisable() {
    }
}
