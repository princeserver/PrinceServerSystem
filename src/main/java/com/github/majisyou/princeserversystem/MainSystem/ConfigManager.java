package com.github.majisyou.princeserversystem.MainSystem;

import com.github.majisyou.princeserversystem.PrinceServerSystem;
import org.bukkit.configuration.Configuration;

import java.util.List;

public class ConfigManager {

    private static final PrinceServerSystem plugin = PrinceServerSystem.getInstance();
    private static final Configuration config = plugin.getConfig();
    private static String Maintenance_mode;
    private static List<String> Players;
    private static Integer EntityRange;
    private static Integer EntityLimits;
    private static Integer EntityManage;

    public static void loadConfig(){
        Maintenance_mode = config.getString("Server_maintenace");
        Players = config.getStringList("Players");
        EntityRange = config.getInt("EntityRange");
        EntityLimits = config.getInt("EntityLimits");
        EntityManage = config.getInt("EntityManage");
    }

    public static String getMaintenance_mode(){
        return Maintenance_mode;
    }
    public static List<String> getPlayers(){return Players;}
    public static Integer getEntityRange(){return EntityRange;}
    public static Integer getEntityLimits(){return EntityLimits;}
    public static Integer getEntityManage(){return EntityManage;}

    public static void setMaintenance_mode(String true_or_false){
        if(true_or_false.equals("true")||true_or_false.equals("false")){
            config.set("Server_maintenace",true_or_false);
            //configの中の設定がtrueかどうかを返すようにできてる
        }
    }

    public static void setPlayers(String players){
        if(Players.contains(players)){
            Players.remove(players);
        }else{
            Players.add(players);
        }
        config.set("Players",Players);
        plugin.saveConfig();
    }
}
