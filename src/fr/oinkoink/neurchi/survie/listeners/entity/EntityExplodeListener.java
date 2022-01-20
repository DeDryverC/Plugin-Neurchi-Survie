package fr.oinkoink.neurchi.survie.listeners.entity;

import fr.oinkoink.neurchi.survie.utils.FireWorkBuilder;
import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.Random;

public class EntityExplodeListener implements Listener {


    @EventHandler
    public void onEntityExplode(ExplosionPrimeEvent event) {
        Entity entity = event.getEntity();

        EntityType entityType = entity.getType();
        Location entityLoc = entity.getLocation();


        if (entity instanceof Creeper) {
            LivingEntity livingEntity = (LivingEntity) event.getEntity();
            if(Randomizer.getPercentage(7.5D)) {
                Location fwLoc = entityLoc;
                fwLoc.setY(entityLoc.getY() +1 );
                event.setCancelled(true);
                livingEntity.damage(100.0D);
                FireWorkBuilder firework = new FireWorkBuilder(livingEntity, fwLoc, 0);
            }
        }
        if(entity instanceof TNTPrimed){
            if(Randomizer.getPercentage(5.0D)){
                event.setCancelled(true);
            }
        }

    }
}

