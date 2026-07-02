package io.github.mvkoksal.hustleTusslePlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Collection;
import java.util.EventListener;

public class CommandTussle implements CommandExecutor, Listener {

    public static TaskInventory taskInventory;
    public static ItemStack paper;

        // This method is called, when somebody uses our command
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Bukkit.broadcastMessage("Let the HustleTussle begin...");
            GetGameState.currentGameState = GetGameState.GameState.IN_PROGRESS;

            Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
            for(Player player: onlinePlayers) {
                // Give initial items to all players.
                ItemStack sword = new ItemStack(Material.STONE_SWORD);
                ItemStack pickaxe = new ItemStack(Material.STONE_PICKAXE);
                ItemStack axe = new ItemStack(Material.STONE_AXE);
                ItemStack shovel = new ItemStack(Material.STONE_SHOVEL);
                ItemStack beef = new ItemStack(Material.COOKED_BEEF);
                beef.setAmount(20);
                paper = new ItemStack(Material.PAPER);

                player.getInventory().addItem(sword, pickaxe, axe, shovel, beef, paper);

                taskInventory = new TaskInventory();
            }
            return true;
        }

        @EventHandler
        public void onInventoryRightClick(InventoryClickEvent event) {
            int slot = event.getSlot();
            if(taskInventory.inventory.getItem(slot) == paper && event.isRightClick()) {
                event.getWhoClicked().openInventory(taskInventory.inventory);
            }
        }

}
