package ceo.soc1ly.sjointitle;

import org.bukkit.Sound;
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

        String soundName = plugin.getConfig().getString("sound");
        float volume = (float) plugin.getConfig().getDouble("volume", 1.0);
        float pitch = (float) plugin.getConfig().getDouble("pitch", 1.0);

        if (soundName != null && !soundName.isEmpty()) {
            try {
                Sound sound = Sound.valueOf(soundName);
                event.getPlayer().playSound(event.getPlayer().getLocation(), sound, volume, pitch);
            } catch (IllegalArgumentException e) {
                plugin.getLogger().warning("invalid sound: " + soundName);
            }
        }
    }
}
