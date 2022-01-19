package fr.oinkoink.neurchi.survie.listeners.entity;

import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.entity.EnderCrystal;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        Entity entity = event.getEntity();
        EntityDamageEvent.DamageCause damageCause = event.getCause();

    }

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        EntityDamageEvent.DamageCause damageCause = event.getCause();

        if(entity instanceof EnderCrystal && event.getDamager() instanceof Player){
            Player player = (Player)event.getDamager();

            if(Randomizer.getPercentage(50.0D)){
                player.damage(player.getHealth());
                player.sendMessage("§c§lEnder Dragon §7§l: §7Vous ne toucherez plus mes crystaux !");
            }
        }
    }
}
