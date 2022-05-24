package com.github.majisyou.princeserversystem.Entitys.Events;

import com.github.majisyou.princeserversystem.Entitys.System.EntitySystem;
import com.github.majisyou.princeserversystem.PrinceServerSystem;
import io.papermc.paper.event.entity.EntityMoveEvent;
import io.papermc.paper.event.player.PlayerItemFrameChangeEvent;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EntityManagerEvent implements Listener {
    public EntityManagerEvent(PrinceServerSystem plugin){ //mainメソッド内でイベントリスナを呼び出すためのコマンド
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

//    @EventHandler
//    public static void Spawn(EntitySpawnEvent event){
//        PrinceServerSystem.getInstance().getLogger().info("spawnが呼び出された");
//        EntitySystem.EntityManage(event.getEntity());
//    }

    @EventHandler
    public static void DropItem(EntityDropItemEvent event){
//        PrinceServerSystem.getInstance().getLogger().info("entitydropitemが呼び出された");
        EntitySystem.EntityManage(event.getEntity());
    }
//    @EventHandler
//    public static void EntityInteract(EntityInteractEvent event) {
//        PrinceServerSystem.getInstance().getLogger().info("interactが呼び出された");
//        EntitySystem.EntityManage(event.getEntity());
//    }
    @EventHandler
    public static void EntityBreed(EntityBreedEvent event) {
//        PrinceServerSystem.getInstance().getLogger().info("breedmが呼び出された");
        EntitySystem.EntityManage(event.getEntity());
    }
    @EventHandler
    public static void DamageEntity(EntityDamageEvent event) {
//        PrinceServerSystem.getInstance().getLogger().info("Damageが呼び出された");
        EntitySystem.EntityManage(event.getEntity());
    }
    @EventHandler
    public static void PlayerRightClick(PlayerInteractEntityEvent event){
//        PrinceServerSystem.getInstance().getLogger().info("RightClickChangeが呼び出された");
        EntitySystem.EntityManage(event.getPlayer());
    }
    @EventHandler
    public static void PlayerItemFrame(PlayerItemFrameChangeEvent event){
//        PrinceServerSystem.getInstance().getLogger().info("ItemFrameChangeが呼び出された");
        EntitySystem.EntityManage(event.getPlayer());
    }
    @EventHandler
    public static void PlayerBreakChest(BlockBreakEvent event){
        if(event.getBlock().getType().equals(Material.CHEST)||event.getBlock().getType().equals(Material.BARREL)){
//            PrinceServerSystem.getInstance().getLogger().info("BlockBreakが呼び出された");
            EntitySystem.EntityManage(event.getPlayer());
        }
    }
    @EventHandler
    public static void EntityMove(EntityMoveEvent event){
//        PrinceServerSystem.getInstance().getLogger().info("Moveが呼び出された");
        EntitySystem.EntityManage(event.getEntity());
    }
    @EventHandler
    public static void EntityPlace(EntityPlaceEvent event){
//        PrinceServerSystem.getInstance().getLogger().info("Placeが呼び出された");
        EntitySystem.EntityManage(event.getEntity());
    }





//    @EventHandler
//    public static void ItemSpawn(ItemSpawnEvent event) {
//        PrinceServerSystem.getInstance().getLogger().info("itemspawnが呼び出された");
//        EntitySystem.EntityManage(event.getEntity());
//    }
//    @EventHandler
//    public static void ItemSpawn(ItemSpawnEvent event) {
//        PrinceServerSystem.getInstance().getLogger().info("itemspawnが呼び出された");
//        EntitySystem.EntityManage(event.getEntity());
//    }





}
