package fr.oinkoink.neurchi.survie.listeners.entity;

import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        Entity entity = event.getEntity();
        EntityDamageEvent.DamageCause damageCause = event.getCause();
        if(entity instanceof Player){
            Player player = (Player)entity;
            if(damageCause == EntityDamageEvent.DamageCause.LAVA){
                player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 200, 0));
            }
        }
    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        Entity damager = event.getDamager();
        EntityDamageEvent.DamageCause damageCause = event.getCause();

        if(entity instanceof EnderCrystal && damager instanceof Player){
            Player player = (Player)event.getDamager();

            if(Randomizer.getPercentage(50.0D)){
                player.damage(player.getHealth());
                player.sendMessage("§c§lEnder Dragon §7§l: §7Vous ne toucherez plus mes crystaux !");
            }
        }
        if(entity instanceof Player && damager instanceof Slime){
            Player player = (Player)entity;
            if(Randomizer.getPercentage(3.0D)){
                PotionEffect effect= player.getPotionEffect(PotionEffectType.CONFUSION);
                if(effect != null){
                    int duration = effect.getDuration();
                    duration = duration*2;
                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, duration, 0));
                }
                else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 100, 0));
                }
            }
            if(Randomizer.getPercentage(3.0D)) {
                PotionEffect effect = player.getPotionEffect(PotionEffectType.SLOW);
                if (effect != null) {
                    int duration = effect.getDuration();
                    duration = duration * 2;
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, 0));
                } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 0));
                }
            }
        }
        if(entity instanceof Player && damageCause == EntityDamageEvent.DamageCause.PROJECTILE){
            Player player = (Player)entity;
            if(Randomizer.getPercentage(5.0D)){
                event.setCancelled(true);
                player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
            }


        }
    }
}
