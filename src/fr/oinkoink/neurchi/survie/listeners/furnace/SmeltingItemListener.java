package fr.oinkoink.neurchi.survie.listeners.furnace;

import fr.oinkoink.neurchi.survie.MainEvent;
import fr.oinkoink.neurchi.survie.utils.ItemBuilder;
import fr.oinkoink.neurchi.survie.utils.Randomizer;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

public class SmeltingItemListener implements Listener {



    @EventHandler
    private void onSmeltItem(FurnaceSmeltEvent event){
        ItemStack source = event.getSource();
        if(source.getType() == Material.GRAVEL){
            ItemStack newResult;
            if(Randomizer.getPercentage(1.0E-4D)){
                newResult = (new ItemBuilder(Material.NETHER_STAR)).build();
            }
            else {
                switch(Randomizer.getRandomInt(9)){
                    case 1:
                        newResult = (new ItemBuilder(Material.STICK)).withAmount(Randomizer.getRandomInt(5)).build();
                        break;
                    case 2:
                        newResult = (new ItemBuilder(Material.DIRT)).build();
                        break;
                    case 3:
                        newResult = (new ItemBuilder(Material.OAK_BOAT)).build();
                        break;
                    case 4:
                        newResult = (new ItemBuilder(Material.IRON_NUGGET)).build();
                        break;
                    case 5:
                        newResult = (new ItemBuilder(Material.GOLD_NUGGET)).build();
                        break;
                    case 6:
                        newResult = (new ItemBuilder(Material.DEAD_BUSH)).build();
                        break;
                    case 7:
                        newResult = (new ItemBuilder(Material.OAK_DOOR)).build();
                        break;
                    case 8:
                        newResult = (new ItemBuilder(Material.LEAD)).build();
                        break;
                    case 9:
                        newResult = (new ItemBuilder(Material.FIRE_CHARGE)).build();
                        break;
                    default:
                        newResult = (new ItemBuilder(Material.FLINT)).build();


                }
            }
            event.setResult(newResult);
        }
    }
}
