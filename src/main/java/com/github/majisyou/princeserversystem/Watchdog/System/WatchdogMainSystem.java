package com.github.majisyou.princeserversystem.Watchdog.System;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WatchdogMainSystem {

    public static ItemStack WatchDogItem(){
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName("§aCheckChest");
        item.setItemMeta(itemMeta);
        return item;
    }

}
