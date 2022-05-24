package com.github.majisyou.princeserversystem.Entitys.Command;

import com.github.majisyou.princeserversystem.Entitys.Events.EntityManagerEvent;
import com.github.majisyou.princeserversystem.Entitys.System.EntitySystem;
import com.github.majisyou.princeserversystem.Maintenance.commands.Cmd_tabComplete;
import com.github.majisyou.princeserversystem.PrinceServerSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Cmd_test implements CommandExecutor {

    private static final PrinceServerSystem plugin = PrinceServerSystem.getInstance();
    public Cmd_test(PrinceServerSystem plugin){
        plugin.getCommand("Entity_test").setExecutor(this);
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
//        Player player = (Player) sender;
//        List<Entity> entities = player.getNearbyEntities(10,10,10);
//        plugin.getLogger().info("entityの数は"+entities.size());
////        plugin.getLogger().info();
//        int entity_number = entities.size();
////        EntitySystem.EntityMetaSet(player);
////
//        for (Entity entity : entities){
//            plugin.getLogger().info(entity.getName()+"の名前");
//            plugin.getLogger().info(entity.getCustomName()+"の名前");
//            plugin.getLogger().info(entity.getType().name()+"の名前");
//            plugin.getLogger().info(entity.getType().translationKey()+"の名前");
//            plugin.getLogger().info(entity.getType().getName()+"の名前");
//            plugin.getLogger().info(entity.getType().getKey().getKey()+"の名前");
//            if(entities instanceof Player)
//                continue;
//            plugin.getLogger().info(entity.getName());
//            entity.remove();
//            plugin.getLogger().info(entity_number+"の大きさ");
//            entity_number -= 1;
//        }
//
        return true;
    }
}
