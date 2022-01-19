package fr.oinkoink.neurchi.survie.listeners.blocks;

import fr.oinkoink.neurchi.survie.utils.ItemBuilder;
import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;


public class BreakListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        Player player = event.getPlayer();
        Location playerLoc = player.getLocation();
        Block block = event.getBlock();
        Material blockType = block.getType();
        Location blockLoc = block.getLocation();


        if (blockType == Material.DIAMOND_ORE) {
            if (Randomizer.getPercentage(3.0D)) {
                player.playSound(playerLoc, Sound.ENTITY_CREEPER_PRIMED, 1.0F, 1.0F);
            }

        }
        if (blockType == Material.DIAMOND_ORE ||
                blockType == Material.EMERALD_ORE ||
                blockType == Material.IRON_ORE||
                blockType == Material.COAL_ORE ||
                blockType == Material.COPPER_ORE ||
                blockType == Material.GOLD_ORE) {
            if(Randomizer.getPercentage(1.0D)){
                ItemStack gift = new ItemStack(blockType,1);
                blockLoc.getWorld().dropItem(blockLoc, gift);
            }
        }

        if(blockType == Material.SPAWNER){
            CreatureSpawner spawner = (CreatureSpawner)block.getState();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand.getType() == Material.DIAMOND_PICKAXE && itemInHand.containsEnchantment(Enchantment.SILK_TOUCH)) {
                ItemStack spawnerItem = (new ItemBuilder(blockType)).withName("§fSpawner : §7" + spawner.getSpawnedType().toString()).build();
                BlockStateMeta blockStateMeta = (BlockStateMeta)spawnerItem.getItemMeta();
                blockStateMeta.setBlockState((BlockState)spawner);
                spawnerItem.setItemMeta((ItemMeta)blockStateMeta);
                blockLoc.getWorld().dropItem(blockLoc, spawnerItem);
                itemInHand.setAmount(0);
                player.playSound(playerLoc, Sound.ENTITY_ITEM_BREAK, 1.0F, 1.0F);

            }
        }
        if(blockType == Material.POPPY){
            if(Randomizer.getPercentage(5.0D)){
                player.getWorld().spawnEntity(blockLoc, EntityType.CREEPER);
            }
        }
        if(blockType == Material.OAK_LOG){
            if(Randomizer.getPercentage(1.0D)){
                player.damage(2.0D);
            }
            if(Randomizer.getPercentage(0.01D)){
                ItemStack gift = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE,1);
                player.playSound(playerLoc, Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                blockLoc.getWorld().dropItem(blockLoc, gift);
            }
        }
        if(blockType == Material.SPRUCE_LOG ||
                blockType == Material.BIRCH_LOG){
            if(Randomizer.getPercentage(0.01D)){
                ItemStack gift = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE,1);
                player.playSound(playerLoc, Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                blockLoc.getWorld().dropItem(blockLoc, gift);
            }
        }
        if(blockType == Material.DIRT){
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            Damageable itemInHandMeta = (Damageable) itemInHand.getItemMeta();
            if (itemInHand.getType() == Material.GOLDEN_PICKAXE && itemInHand.containsEnchantment(Enchantment.SILK_TOUCH)){
                if(Randomizer.getPercentage(8.0D)){
                    int luck = Randomizer.getRandomInt(3);
                    if(luck == 1){
                        ItemStack gift = new ItemStack(Material.RAW_COPPER, Randomizer.getRandomInt(2));
                        blockLoc.getWorld().dropItem(blockLoc, gift);
                    }
                    else if(luck == 2){
                        ItemStack gift = new ItemStack(Material.GOLD_NUGGET, Randomizer.getRandomInt(2));
                        blockLoc.getWorld().dropItem(blockLoc, gift);
                    }
                    else if(luck == 3){
                        ItemStack gift = new ItemStack(Material.IRON_NUGGET, Randomizer.getRandomInt(2));
                        blockLoc.getWorld().dropItem(blockLoc, gift);
                    }
                    int actualDmg = itemInHandMeta.getDamage();
                    itemInHandMeta.setDamage(actualDmg+2);
                    itemInHand.setItemMeta(itemInHandMeta);
                }
            }
        }
    }
}
