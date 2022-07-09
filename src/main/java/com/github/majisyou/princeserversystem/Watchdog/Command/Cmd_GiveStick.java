package com.github.majisyou.princeserversystem.Watchdog.Command;

import com.github.majisyou.princeserversystem.PrinceServerSystem;
import com.github.majisyou.princeserversystem.Watchdog.System.WatchdogMainSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Cmd_GiveStick implements CommandExecutor {
    public Cmd_GiveStick(PrinceServerSystem plugin){
        plugin.getCommand("watchdogItem").setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player){
            ItemStack item = WatchdogMainSystem.WatchDogItem();
            player.getInventory().addItem(item);
        }
        return true;
    }
}
