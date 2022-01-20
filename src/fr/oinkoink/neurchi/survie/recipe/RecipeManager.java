package fr.oinkoink.neurchi.survie.recipe;

import fr.oinkoink.neurchi.survie.MainEvent;
import fr.oinkoink.neurchi.survie.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.plugin.Plugin;

public class RecipeManager {

    private MainEvent mainEvent;
    public RecipeManager(MainEvent pl ){
        this.mainEvent = pl;
    }

    private FurnaceRecipe smeltGravel() {
        NamespacedKey key = new NamespacedKey(this.mainEvent, "smelt_gravel");
        ItemStack result = (new ItemBuilder(Material.FLINT)).build();
        FurnaceRecipe smeltingGravel = new FurnaceRecipe(key, result, Material.GRAVEL, 0.1F, 200);

        return smeltingGravel;
    }



    public void createCrafts() {
        this.mainEvent.getServer().addRecipe((Recipe)smeltGravel());

    }
}
