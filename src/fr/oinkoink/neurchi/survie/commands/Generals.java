package fr.oinkoink.neurchi.survie.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Generals implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player joueur = (Player) commandSender;
            if(command.getName().equals("changelog")){
                joueur.sendMessage("§e§l#########################");
                joueur.sendMessage("§6§l--   Survie Neurchi    --");
                joueur.sendMessage("");
                joueur.sendMessage("§6§l Ajouts :");
                joueur.sendMessage("§7 - /changelog : Affiche les changements :D");
                joueur.sendMessage("");
                joueur.sendMessage("§6§l Modifications :");
                joueur.sendMessage("");
                joueur.sendMessage("§6§l Suppression:");
                joueur.sendMessage("§7 - Metaloul");
                joueur.sendMessage("");
                joueur.sendMessage("§e§l#########################");

                return true;
            } if(command.getName().equals("tpflat")){
                Location teleport = new Location(Bukkit.getWorld("Test"), 0,100,0);
                joueur.teleport(teleport);
                return true;

            }

        }
        return false;
    }
}
