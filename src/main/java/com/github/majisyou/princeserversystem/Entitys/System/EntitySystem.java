package com.github.majisyou.princeserversystem.Entitys.System;

import com.github.majisyou.princeserversystem.MainSystem.ConfigManager;
import com.github.majisyou.princeserversystem.PrinceServerSystem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import java.util.List;

public class EntitySystem {

    private static final PrinceServerSystem plugin = PrinceServerSystem.getInstance();
    private static Integer range = ConfigManager.getEntityRange();
    private static Integer limit = ConfigManager.getEntityLimits();
    private static Integer manage = ConfigManager.getEntityManage();

    public static void EntityManage(Entity entity){
        if(entity.hasMetadata("entityManage")){
            for (MetadataValue value:entity.getMetadata("entityManage")){
                if(value.getOwningPlugin().getName().equals(plugin.getName())){
                    if(!value.asBoolean()){
                        EntityMainRemove(entity);
                    }
                    break;
                }
            }
        }else {
            EntityMainRemove(entity);
        }
    }

    public static void EntityMainRemove(Entity entity){
        List<Entity> EntityManage = entity.getNearbyEntities(range,range,range);
        if(EntityManage.size()>limit){
            plugin.getLogger().info("(PSS)"+entity.getWorld().getName()+"の"+"x:"+entity.getLocation().getX()+"y:"+entity.getLocation().getY()+"z:"+entity.getLocation().getZ()+"付近に"+EntityManage.size()+"体のエンテティが密集しています。");
            plugin.getLogger().info("(PSS)"+"Entityを減らします");
            if(entity instanceof Player player){
                plugin.getLogger().info("(PSS)"+player.getName()+"がいる付近でエンテティの密集を確認した");
                player.sendMessage(ChatColor.RED +"[警告]"+ChatColor.WHITE+"Entityの密集を確認しました。心当たりがある場合は早急にEntityを減らしてください。心当たりが無い場合は座標と時刻を記録し、運営の方まで連絡お願いします");
            }
            EntityRemove(EntityManage);
            EntityMetaSet(entity);
        }else {
            entity.setMetadata("entityManage", new FixedMetadataValue(plugin,false));
        }
    }

    public static void EntityRemove(List<Entity> entitys){
        int entity_number = entitys.size();
        for (Entity entity :entitys){
            if(entity_number<100){
                break;
            }
            EntityMetaSet(entity);
            if(entity instanceof Player player){
                plugin.getLogger().info("(PSS)"+player.getName()+"がいる付近でエンテティの密集を確認した");
                player.sendMessage(ChatColor.RED +"[警告]"+ChatColor.WHITE+"Entityの密集を確認しました。心当たりがある場合は早急にEntityを減らしてください。心当たりが無い場合は座標と時刻を記録し、運営の方まで連絡お願いします");
                EntityMetaSet(player);
                continue;
            }
            if(entity instanceof ItemFrame){
                EntityMetaSet(entity);
                continue;
            }
            if(entity instanceof GlowItemFrame){
                EntityMetaSet(entity);
                continue;
            }
            if(entity instanceof ArmorStand){
                EntityMetaSet(entity);
                continue;
            }
            if(entity instanceof Item){
                EntityMetaSet(entity);
                continue;
            }
            if(entity.getCustomName()!=null){
                EntityMetaSet(entity);
                continue;
            }
            if(entity.isInvulnerable()){
                EntityMetaSet(entity);
                continue;
            }
            if(entity instanceof Villager){
                EntityMetaSet(entity);
                continue;
            }
            if(entity instanceof StorageMinecart){
                EntityMetaSet(entity);
                continue;
            }
            entity_number--;
            entity.remove();
        }
        if(entity_number>manage){
            plugin.getLogger().info("(PSS)"+"Entityの数は100まで減らせず、"+entity_number+"まで減らした");
        }else {
            plugin.getLogger().info("(PSS)"+"Entityの数を100まで減らしました");
        }
    }

    public static void EntityMetaSet(Entity entity){
        if(entity.hasMetadata("entityManage")){
            for (MetadataValue value:entity.getMetadata("entityManage")){
                if(value.getOwningPlugin().getName().equals(plugin.getName())){
                    if(value.asBoolean()){
                        return;
                    }
                    break;
                }
            }
        }
        entity.setMetadata("entityManage",new FixedMetadataValue(plugin,true));
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                try {
                    entity.setMetadata("entityManage",new FixedMetadataValue(plugin,false));
                }catch (Exception e){
                    plugin.getLogger().info("(PSS)"+"metadataを設定するときにエラーが発生した");
                }
            }
        },200);
    }
}
