package fr.oinkoink.neurchi.survie.listeners.entity;

import fr.oinkoink.neurchi.survie.utils.FireWorkBuilder;
import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
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
        LivingEntity entity = (LivingEntity) event.getEntity();

        EntityType entityType = entity.getType();
        Location entityLoc = entity.getLocation();
        Player player = entity.getKiller();


        if (entity instanceof Creeper) {
            if(Randomizer.getPercentage(7.5D)) {
                Location fwLoc = entityLoc;
                fwLoc.setY(entityLoc.getY() +1 );
                event.setCancelled(true);
                entity.damage(100.0D);
                FireWorkBuilder firework = new FireWorkBuilder(entity, fwLoc, 0);
            }
        }

    }
}

