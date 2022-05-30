package com.github.majisyou.princeserversystem.Maintenance.commands;


import com.github.majisyou.princeserversystem.MainSystem.ConfigManager;
import com.github.majisyou.princeserversystem.PrinceServerSystem;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Cmd_maintenance implements CommandExecutor {

    public Cmd_maintenance(PrinceServerSystem plugin){
        plugin.getCommand("maintenance").setExecutor(this);
        plugin.getCommand("maintenance").setTabCompleter(new Cmd_tabComplete());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!sender.hasPermission("prince_server_maintenance")) {//permissionが持っているなら
            sender.sendMessage("You dont have permission");
            return false;
        }

        if (args.length == 0){
            sender.sendMessage("Maintenance_mode is "+ ConfigManager.getMaintenance_mode());
            //メンテナンスモードが今どのような状態かを見ることができる
            return true;
        }
        if(args.length!=2){
            sender.sendMessage("引数の数が違います");
            return true;
        }
        switch (args[0]){
            case "mode"->{
                if(args[1].equalsIgnoreCase("true")){
                    //コマンドでtrueを打った時に
                    //configの中のServer_maintenanceをtrue
                    //この中にパーミッションを持っていない人はkickするコマンドを使用する。
                    this.Login_player_kick(); //この下のメソッドでkick
                    ConfigManager.setMaintenance_mode(args[1]);
                    ConfigManager.loadConfig();
                    sender.sendMessage("MaintenanceModeをONにしました");
                    return true;
                }
                if(args[1].equalsIgnoreCase("false")){
                    //コマンドでfalseと打った場合
                    //configの中のServer_maintenanceをfalseにする
                    ConfigManager.setMaintenance_mode(args[1]);
                    ConfigManager.loadConfig();
                    sender.sendMessage("MaintenanceModeをOFFにしました");
                    return true;
                }
                sender.sendMessage("2引数目はtrueもしくはfalseにしましょう");
                return true;
            }
            case "player"->{
                if(ConfigManager.getPlayers().contains(args[1])){
                    sender.sendMessage(args[1]+"のプレイヤーをコンフィグから消したよ");
                }else {
                    sender.sendMessage(args[1]+"のプレイヤーをコンフィグに登録したよ");
                }
                ConfigManager.setPlayers(args[1]);
                Player player = PrinceServerSystem.getInstance().getServer().getPlayer(args[1]);
                if(player==null){
                    PrinceServerSystem.getInstance().getLogger().info("(PSS)"+args[1]+"という名のプレイヤーはサーバ内にいないけど、登録したよ");
                }
                return true;
            }
        }
        sender.sendMessage("第一引数はmodeかplayerにしてください");
        return true;

    }

    public void Login_player_kick(){
        Player[] players= PrinceServerSystem.getInstance().getServer().getOnlinePlayers().toArray(new Player[0]);
        if(!(players.length==0)){
            for (Player p : players){
                if(!p.hasPermission("prince_server_maintenance")){
                    p.kick(Component.text("メンテナンスを開始したよ"));
                }
            }
        }else{
            Bukkit.getLogger().info("プレイヤーがいません");
        }
    }
}
