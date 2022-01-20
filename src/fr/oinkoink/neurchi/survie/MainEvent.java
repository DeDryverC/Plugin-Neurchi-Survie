package fr.oinkoink.neurchi.survie;

import fr.oinkoink.neurchi.survie.listeners.blocks.BreakListener;
import fr.oinkoink.neurchi.survie.commands.Generals;
import fr.oinkoink.neurchi.survie.listeners.entity.EntityDamageListener;
import fr.oinkoink.neurchi.survie.listeners.entity.EntityDeathListener;
import fr.oinkoink.neurchi.survie.listeners.entity.EntityExplodeListener;
import fr.oinkoink.neurchi.survie.listeners.furnace.SmeltingItemListener;
import fr.oinkoink.neurchi.survie.listeners.player.DrinkPotionListener;
import fr.oinkoink.neurchi.survie.recipe.RecipeManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MainEvent extends JavaPlugin {


    public RecipeManager recipeManager = new RecipeManager(this);
    private Logger logger=Logger.getLogger("Minecraft");

    @Override
    public void onLoad() {
    }

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getConfig();
        FileConfiguration config = this.getConfig();
        config.addDefault("youAreAwesome", true);

        System.out.println("Activation du plugin");

        PluginManager pluginManager = Bukkit.getPluginManager();

        /** COMMANDES **/
        getCommand("changelog").setExecutor(new Generals());
        getCommand("tpflat").setExecutor(new Generals());

        /** LISTENERS **/
        getServer().getPluginManager().registerEvents(new BreakListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
        getServer().getPluginManager().registerEvents(new EntityExplodeListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new DrinkPotionListener(), this);
        getServer().getPluginManager().registerEvents(new SmeltingItemListener(), this);


        this.recipeManager.createCrafts();


        for(String str : getConfig().getStringList("badwords")){
            System.out.println(str);
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Desactivation du plugin");
    }
}
