package com.github.majisyou.princeserversystem.Watchdog.Event;

import com.github.majisyou.princeserversystem.PrinceServerSystem;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

public class RedStoneCheck implements Listener {
    private static final PrinceServerSystem plugin = PrinceServerSystem.getInstance();
    public RedStoneCheck(PrinceServerSystem plugin){ //mainメソッド内でイベントリスナを呼び出すためのコマンド
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public static void RedStoneEventCheck(BlockRedstoneEvent event){
        if(event.getBlock().getState().getType().equals(Material.REDSTONE)||event.getBlock().getState().getType().equals(Material.REDSTONE_WIRE)){
            Block block = event.getBlock();

            if(!block.hasMetadata("check")){
                plugin.getLogger().info("(PSS)"+event.getBlock().getLocation().getWorld().getName()+"のx:"+event.getBlock().getLocation().getX()+"のy:"+event.getBlock().getLocation().getY()+"のz:"+event.getBlock().getLocation().getZ()+"の位置でレッドストーン信号のONを確認した");
            }

            block.setMetadata("check",new FixedMetadataValue(plugin,true));

        }
    }

}
