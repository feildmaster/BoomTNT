package feildmaster.anotherTNTplugin;

import org.blockface.bukkitstats.CallHome;
import org.bukkit.event.Event;
import org.bukkit.plugin.java.JavaPlugin;

public class boom extends JavaPlugin {
    public void onDisable() {
        getServer().getLogger().info(String.format("[%1$s] Disabled!", getDescription().getName()));
    }

    public void onEnable() {
        // Stats Usage
        CallHome.load(this);

        getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, new blockListener(), Event.Priority.Lowest, this);
        getServer().getLogger().info(String.format("[%1$s] v%2$s Enabled!", getDescription().getName(), getDescription().getVersion()));
    }
}
