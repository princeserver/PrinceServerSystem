package com.github.majisyou.princeserversystem.Maintenance.event;


import com.github.majisyou.princeserversystem.MainSystem.ConfigManager;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class Player_Login implements Listener {

//    @EventHandler
//    public void Login_cancel (PlayerJoinEvent event){
//
//        if(ConfigManager.getMaintenance_mode().equals("true")){ //configの中のmaintenane_modeがtrueだからっていうやつ
//            if(!(event.getPlayer().isPermissionSet("prince_server_maintenance"))){ //パーミッションprince_server_maintenanceがなったら
//                event.getPlayer().kick(Component.text(ChatColor.RED+"メンテナンス中です")); //キックするコマンド
////                System.getLogger(event.getPlayer().getName()+"がログインしようとしたよ");
//            }else {
//                event.getPlayer().sendMessage("メンテナンス中だよ");
//            }
//        }
//    }
}
