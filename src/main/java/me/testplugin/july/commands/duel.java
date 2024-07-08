package me.testplugin.july.commands;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import net.md_5.bungee.api.chat.ClickEvent.Action;
import net.md_5.bungee.api.chat.HoverEvent;
import java.util.ArrayList;


import javax.xml.soap.Text;
import java.awt.*;

import static org.bukkit.Bukkit.getServer;

public class duel implements CommandExecutor {

    public static ArrayList<String> dueled = new ArrayList<String>();
    public static ArrayList<String> dueler = new ArrayList<String>();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            Player r = getServer().getPlayer(args[0]);

            if (p.getDisplayName().equals(r.getDisplayName())) {
                p.sendMessage(ChatColor.RED + "You can't duel yourself!");
                return true;
            }

            if (duel.dueler.contains(p.getDisplayName())) {
                p.sendMessage("You have already dueled a player!");
                return true;
            }

            p.sendMessage(ChatColor.GREEN + "Duel request sent.");

            dueled.add(r.getDisplayName());
            dueler.add(p.getDisplayName());

            TextComponent yes = new TextComponent("ACCEPT");
            yes.setColor(net.md_5.bungee.api.ChatColor.GREEN);

            yes.setClickEvent(new ClickEvent(Action.RUN_COMMAND, "/accept " + ((Player) sender).getDisplayName()));
            yes.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(ChatColor.GRAY + "Accept duel").create()));
            TextComponent full = new TextComponent(new TextComponent(p.getDisplayName()), new TextComponent(" has sent you a duel. "), yes);

            r.spigot().sendMessage(full);
        }

        return true;
    }

}
