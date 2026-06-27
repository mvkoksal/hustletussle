package io.github.mvkoksal.hustleTusslePlugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class TaskInventory {
    int inventorySize;
    String inventoryName;
    Inventory inventory;
    public TaskInventory() {
        inventorySize = 27;
        inventoryName = "TaskInventory";
        inventory = Bukkit.createInventory(null, inventorySize, Component.text(inventoryName));

        // Add objects symbolizing task categories (1 em = easy; 2 ems = medium; 3 ems = hard)
        inventory.setItem(2, new ItemStack(Material.EMERALD));
        inventory.setItem(10, new ItemStack(Material.EMERALD));
        inventory.setItem(11, new ItemStack(Material.EMERALD));
        inventory.setItem(18, new ItemStack(Material.EMERALD));
        inventory.setItem(19, new ItemStack(Material.EMERALD));
        inventory.setItem(20, new ItemStack(Material.EMERALD));
    }

    public void addTask(String task, ItemStack taskObject, int diffLevel) {
        if (diffLevel == 1) {
            for(int i=4; i <=8; i++) {
                if(inventory.getItem(i) == null ||
                        inventory.getItem(i).getType() == Material.GRAY_STAINED_GLASS_PANE) {
                    // Set the lore of the object as the task descp
                    List<Component> taskLore = List.of(Component.text(task, TextColor.color(NamedTextColor.LIGHT_PURPLE)));
                    taskObject.lore(taskLore);
                    inventory.setItem(i, taskObject);
                    break;
                }
            }
            //slots
        } else if (diffLevel == 2){
            for(int i=13; i <=15; i++) {
                if(inventory.getItem(i) == null ||
                        inventory.getItem(i).getType() == Material.GRAY_STAINED_GLASS_PANE) {
                    List<Component> taskLore = List.of(Component.text(task, TextColor.color(NamedTextColor.AQUA)));
                    taskObject.lore(taskLore);
                    inventory.setItem(i, taskObject);
                    break;
                }
            }

        } else if (diffLevel == 3){
            for(int i=22; i <=23; i++) {
                if(inventory.getItem(i) == null ||
                        inventory.getItem(i).getType() == Material.GRAY_STAINED_GLASS_PANE) {
                    List<Component> taskLore = List.of(Component.text(task, TextColor.color(NamedTextColor.RED)));
                    taskObject.lore(taskLore);
                    inventory.setItem(i, taskObject);
                    break;
                }
            }
        }
    }

    // NEW CLASS - tasklist
    //Shuffles the easy, medium and hard task queues, and initializes the chest with tasks.
    // public void initializeChest

    //Adds a hard task.
}
