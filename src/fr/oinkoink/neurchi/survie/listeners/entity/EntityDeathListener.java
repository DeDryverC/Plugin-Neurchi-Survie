package fr.oinkoink.neurchi.survie.listeners.entity;

import fr.oinkoink.neurchi.survie.utils.ItemBuilder;
import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityDeathListener implements Listener {


    @EventHandler
    public void onEntityDeath(EntityDeathEvent event){
        LivingEntity entity = event.getEntity();
        EntityType entityType = entity.getType();
        Location entityLoc = entity.getLocation();
        Player player = entity.getKiller();


        if(player!= null) {
            Location playerLoc = player.getLocation();
            if (entity instanceof Villager) {
                if (entityType == EntityType.VILLAGER) {
                    if (player.getLocation().getBlock().getType() == Material.AIR) {
                        player.getLocation().getBlock().setType(Material.COBWEB);
                    } else {
                        player.getLocation().add(0.0D, 1.0D, 0.0D).getBlock().setType(Material.COBWEB);
                    }
                    entityLoc.getWorld().spawnEntity(entityLoc, EntityType.ZOMBIE_VILLAGER);
                }
            }
            if (entity instanceof Bat) {
                if (Randomizer.getPercentage(1.0D)) {
                    ItemStack gift = new ItemStack(Material.DIAMOND, 1);
                    entityLoc.getWorld().dropItem(entityLoc, gift);
                }
            }
            if (entity instanceof Witch) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 3));
                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 3));
            }
            if (entity instanceof Creeper) {
                if (Randomizer.getPercentage(2.0D)) {
                    Creeper creeper = (Creeper) entityLoc.getWorld().spawnEntity(entityLoc, EntityType.CREEPER);
                    creeper.setPowered(true);
                }
            }
            if (entity instanceof CaveSpider) {
                if (Randomizer.getPercentage(3.0D)) {
                    entityLoc.getWorld().spawnEntity(entityLoc, entityType.SPIDER);
                    entityLoc.getWorld().spawnEntity(entityLoc, entityType.SPIDER);
                }
            }
            if (entity instanceof Enderman) {
                if (Randomizer.getPercentage(1.0D)) {
                    ItemStack gift = new ItemStack(Material.ENDER_EYE, 1);
                    entityLoc.getWorld().dropItem(entityLoc, gift);
                }
            }
            if (entity instanceof Zombie) {
                if (Randomizer.getPercentage(1.0D)) {
                    Ageable zombie = (Zombie) entity.getWorld().spawnEntity(entityLoc, EntityType.ZOMBIE);
                    ZombieHorse zombieHorse = (ZombieHorse) entity.getWorld().spawnEntity(entityLoc, EntityType.ZOMBIE_HORSE);
                    zombie.setTarget((LivingEntity) player);
                    zombie.setBaby();
                    zombieHorse.getInventory().setSaddle((new ItemBuilder(Material.SADDLE)).build());
                    zombieHorse.setTamed(true);
                    zombieHorse.setAdult();
                    zombieHorse.addPassenger((Entity) zombie);
                }
            }
        }
    }
}
