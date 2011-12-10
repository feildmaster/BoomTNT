package feildmaster.anotherTNTplugin;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

class blockListener extends BlockListener {
    public void onBlockPlace(BlockPlaceEvent event) {
        if(event.getPlayer().getGameMode() == GameMode.CREATIVE || event.getPlayer().isOp()) return;

        Block block = event.getBlock();
        if(block.getType() == Material.TNT) {
            if(Math.random() < 0.9) {
                //event.getPlayer().getServer().broadcastMessage(event.getPlayer().getDisplayName()+" messed up when setting up TNT!");
                event.getPlayer().sendMessage("You messed up when setting TNT!");
                block.setType(Material.AIR);
                event.getPlayer().getWorld().createExplosion(block.getLocation(), 4F);
            }
        }
    }
}
