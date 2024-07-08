package me.testplugin.july.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import org.bukkit.plugin.Plugin;

public class accept implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

        Player p = (Player) commandSender;
        Player t = Bukkit.getPlayer(strings[0]);



        if (duel.dueled.contains(p.getDisplayName())) {
            int i = duel.dueled.indexOf(p.getDisplayName());
            if (t.getName().equals(duel.dueler.get(i))) {
                duel.dueled.remove(i);
                duel.dueler.remove(i);
                Bukkit.dispatchCommand(console, "tp " + p.getName() + " 0 64 0");
                t.sendMessage("Teleporting!");
                Bukkit.dispatchCommand(console, "tp " + t.getName() + " 0 64 0");
                p.sendMessage("Teleporting!");



                return true;
            }
            p.sendMessage("Error");
        }

        return true;
    }
}
