package me.testplugin.july;

import me.testplugin.july.commands.duel;
import me.testplugin.july.utils.configmanager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import me.testplugin.july.commands.accept;

public final class Plugin extends JavaPlugin {
    public static boolean invun = false;
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Hey");
        //setup config

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        configmanager.setup();
        configmanager.get().addDefault("dueled", false);
        configmanager.get().options().copyDefaults(true);
        configmanager.save();

        getCommand("duel").setExecutor(new duel());
        getCommand("accept").setExecutor(new accept());

    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        if (invun)
            e.setCancelled(true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Bye");
    }
}
