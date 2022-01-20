package fr.oinkoink.neurchi.survie.listeners.player;

import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrinkPotionListener implements Listener {

    @EventHandler
    public void onDrinkPotion(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
         if(event.getItem().getType() == Material.POTION){
             if(Randomizer.getPercentage(5.0D)){
                 player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0, true));
             }
         }
    }
}
