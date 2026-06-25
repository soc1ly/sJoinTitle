package ceo.soc1ly.sjointitle;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoinListener implements Listener {

    private final JavaPlugin plugin;

    public PlayerJoinListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String title = plugin.getConfig().getString("title");
        String subtitle = plugin.getConfig().getString("subtitle");
        event.getPlayer().sendTitle(ColorUtils.colorize(title), ColorUtils.colorize(subtitle), 10, 40, 10);
    }
}
