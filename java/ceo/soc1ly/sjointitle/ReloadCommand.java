package ceo.soc1ly.sjointitle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public ReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("sjt.reload")) {
            sender.sendMessage(ColorUtils.colorize(plugin.getConfig().getString("noperm")));
            return true;
        }

        if (args.length == 0 || !args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage(ColorUtils.colorize(plugin.getConfig().getString("use")));
            return true;
        }

        plugin.reloadConfig();
        sender.sendMessage(ColorUtils.colorize(plugin.getConfig().getString("reload")));
        return true;
    }
}
