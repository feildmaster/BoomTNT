package com.feildmaster.anotherTNTplugin;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class boom extends JavaPlugin implements Listener {
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().isOp()) return;

        Block block = event.getBlock();
        if(block.getType() == Material.TNT) {
            if(Math.random() < 0.9) {
                event.getPlayer().sendMessage("You messed up when setting TNT!");
                block.setType(Material.AIR);
                Location l = block.getLocation();
                event.getPlayer().getWorld().createExplosion(l.getX(), l.getY(), l.getZ(), 4F, getConfig().getBoolean("explode-blocks"), getConfig().getBoolean("explode-blocks"));
            }
        }
    }
}
