package com.github.majisyou.princeserversystem.Watchdog.Event;

import com.github.majisyou.princeserversystem.MainSystem.ConfigManager;
import com.github.majisyou.princeserversystem.PrinceServerSystem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.*;
import org.bukkit.block.data.BlockData;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class CheckChest implements Listener {
    public CheckChest(PrinceServerSystem plugin){ //mainメソッド内でイベントリスナを呼び出すためのコマンド
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public static void RightClickChest(PlayerInteractEvent event){
        if(!ConfigManager.getPlayers().contains(event.getPlayer().getName())){
            return;
        }
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if(event.getItem()!=null){
                if(event.getItem().getType().equals(Material.STICK)){
                    if(event.getItem().getItemMeta().hasDisplayName()){
                        if(event.getItem().getItemMeta().getDisplayName().equals("§aCheckChest")){
                            event.setCancelled(true);
                            BlockState block = event.getClickedBlock().getState();
                            Inventory inventory = null;
                            if(block instanceof ShulkerBox){
                                inventory = Bukkit.createInventory(null, InventoryType.SHULKER_BOX);
                                inventory.setContents(((ShulkerBox) block).getInventory().getContents());
                            }
                            if(block instanceof Chest){
                                if(((Chest) block).getInventory().getContents().length == 27){
                                    inventory = Bukkit.createInventory(null, InventoryType.CHEST);
                                    inventory.setContents(((Chest) block).getInventory().getContents());
                                }
                                if(((Chest) block).getInventory().getContents().length == 54){
                                    inventory = Bukkit.createInventory(null, 54);
                                    inventory.setContents(((Chest) block).getInventory().getContents());
                                }

                            }
                            if(block instanceof Barrel){
                                inventory = Bukkit.createInventory(null, InventoryType.BARREL);
                                inventory.setContents(((Barrel) block).getInventory().getContents());
                            }
                            if(block instanceof Furnace){
                                inventory = Bukkit.createInventory(null, InventoryType.FURNACE);
                                inventory.setContents(((Furnace) block).getInventory().getContents());
                            }
                            if(inventory != null){
                                event.getPlayer().openInventory(inventory);
                            }
                        }
                    }
                }
            }
        }
    }
}
