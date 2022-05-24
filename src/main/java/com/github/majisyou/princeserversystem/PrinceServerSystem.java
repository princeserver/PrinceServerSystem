package com.github.majisyou.princeserversystem;

import com.github.majisyou.princeserversystem.Entitys.Command.Cmd_test;
import com.github.majisyou.princeserversystem.Entitys.Events.EntityManagerEvent;
import com.github.majisyou.princeserversystem.MainSystem.ConfigManager;
import com.github.majisyou.princeserversystem.Maintenance.commands.Cmd_maintenance;
import com.github.majisyou.princeserversystem.Maintenance.event.Player_preLogin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PrinceServerSystem extends JavaPlugin {

    private static PrinceServerSystem instance;
    public PrinceServerSystem(){
        instance = this;
    }
    public static PrinceServerSystem getInstance(){
        return instance;
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        //Config
        saveDefaultConfig();
        ConfigManager.loadConfig();


        //Event
        new EntityManagerEvent(this);
        new Player_preLogin(this);

        //Command
        new Cmd_maintenance(this);
//        new Cmd_test(this);

        getLogger().info("ServerSystemEnable");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getScheduler().cancelTasks(this);
        getLogger().info("ServerSystemDisable");
    }


}
