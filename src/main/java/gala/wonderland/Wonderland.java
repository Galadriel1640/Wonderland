/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;

/**
 *
 * @author Isabella
 */
public class Wonderland extends JavaPlugin {

    public static Wonderland instance;
    
    public void onLoad() { //onload happens even before onEnable. we do this here to make sure instance is initialized before anything tries to use it
        // otherwise we would get a NullPointerException (which you have no doubt seen before)
        // NPEs are the bane of every java developer's existence
        // but it's still better than C++ because the same kind of error there just makes your whole system die
        instance = this;
    }
    
    public void onEnable() {
        System.out.println("Look I work!:3");
        Bukkit.getPluginManager().registerEvents(new Watcher(), this);
    }

    /*public boolean onCommand(CommandSender sender, Command command, String commandlable, String[] args) {
        
        switch(args[0]) {
            case "help":
                sender.sendMessage("help");
                break;
            case
            case
            
            return true;
        }
     */
}
//Where is the part where they spawn from clicked mushrooms? i still want that to be a spawning mechanic, also i looked into how to spawn the custom mobs naturally in a biome that would be neat to look into
// thats the only question i remember .___.