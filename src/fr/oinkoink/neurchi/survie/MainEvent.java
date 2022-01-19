package fr.oinkoink.neurchi.survie;

import fr.oinkoink.neurchi.survie.listeners.blocks.BreakListener;
import fr.oinkoink.neurchi.survie.commands.Generals;
import fr.oinkoink.neurchi.survie.listeners.entity.EntityDamageListener;
import fr.oinkoink.neurchi.survie.listeners.entity.EntityDeathListener;
import fr.oinkoink.neurchi.survie.listeners.entity.EntityExplodeListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class MainEvent extends JavaPlugin {

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


        /** COMMANDES **/
        getCommand("changelog").setExecutor(new Generals());
        getCommand("tpflat").setExecutor(new Generals());

        /** LISTENERS **/
        getServer().getPluginManager().registerEvents(new BreakListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathListener(), this);
        getServer().getPluginManager().registerEvents(new EntityExplodeListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);


        for(String str : getConfig().getStringList("badwords")){
            System.out.println(str);
        }
    }

    @Override
    public void onDisable() {
        System.out.println("Desactivation du plugin");
    }
}
