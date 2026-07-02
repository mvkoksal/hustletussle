package io.github.mvkoksal.hustleTusslePlugin;

import org.bukkit.plugin.java.JavaPlugin;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class HustleTusslePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new CommandTussle(), this);
        this.getCommand("tussle").setExecutor(new CommandTussle());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text("Hello, " + event.getPlayer().getName() + "!"));
    }
    
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
