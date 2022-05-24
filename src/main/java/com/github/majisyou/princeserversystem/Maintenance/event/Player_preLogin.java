package com.github.majisyou.princeserversystem.Maintenance.event;

import com.github.majisyou.princeserversystem.MainSystem.ConfigManager;
import com.github.majisyou.princeserversystem.PrinceServerSystem;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class Player_preLogin implements Listener {
    public Player_preLogin(PrinceServerSystem plugin){ //mainメソッド内でイベントリスナを呼び出すためのコマンド
        plugin.getServer().getPluginManager().registerEvents(this,plugin);
    }

    @EventHandler
    public static void PlayerLogin(AsyncPlayerPreLoginEvent event){
        if(ConfigManager.getMaintenance_mode().equals("true")){ //configの中のmaintenane_modeがtrueだからっていうやつ
            if(ConfigManager.getPlayers().contains(event.getName())){
                return;
            }
            event.disallow(AsyncPlayerPreLoginEvent.Result.KICK_FULL,Component.text("メンテナンス中です"));
            PrinceServerSystem.getInstance().getLogger().info("(PSS)"+event.getName()+"がログインしてきました");
        }
    }

}
