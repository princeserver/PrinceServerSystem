package com.github.majisyou.princeserversystem.Maintenance.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Cmd_tabComplete implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if(args.length==1){
            List<String> tab = new ArrayList<String>();
            tab.add("mode");
            tab.add("player");
            return tab;
        }
        if(args[0].equals("mode")){
            List<String> tab = new ArrayList<String>();
            tab.add("true");
            tab.add("false");
            return tab;
        }
        return null;
    }
}
