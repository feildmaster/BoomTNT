package com.feildmaster.anotherTNTplugin;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BoomPlugin extends JavaPlugin implements Listener {
    private boolean damageBlocks;
    private boolean creativeBypass;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        damageBlocks = getConfig().getBoolean("damage-blocks");
        creativeBypass = getConfig().getBoolean("creative-bypass");
    }

    public void onDisable() {
        reloadConfig();
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        if ((creativeBypass && event.getPlayer().getGameMode() == GameMode.CREATIVE) || event.getPlayer().hasPermission("boom.bypass")) {
            return;
        }

        Block block = event.getBlock();
        if (block.getType() != Material.TNT || Math.random() >= 0.9) {
            return;
        }

        event.getPlayer().sendMessage("You messed up when setting TNT!");
        block.setType(Material.AIR);

        Location l = block.getLocation();
        event.getPlayer().getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), 4F, damageBlocks, damageBlocks);
    }
}
