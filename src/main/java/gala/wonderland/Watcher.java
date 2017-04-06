/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland;

import gala.wonderland.creature.Creature;
import gala.wonderland.creature.CreatureType;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.Action;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 *
 * @author Isabella
 */
public class Watcher implements Listener {
    
    int[] sparkleArea = {-1000, -1000, 1000, 1000}; // xmin, zmin, xmax, zmax
    Random rnd = new Random();

    @EventHandler
    public void onClickBlock(PlayerInteractEvent evt) {
        if (evt.getAction() != Action.LEFT_CLICK_BLOCK) {
            return;
        }

        Location loc = evt.getClickedBlock().getLocation();

        if (loc.getX() < sparkleArea[0] || loc.getX() > sparkleArea[2]
                || loc.getZ() < sparkleArea[1] || loc.getZ() > sparkleArea[3]) {
            return;
        }

        if (evt.getClickedBlock().getType() == Material.WOOL) {

            CreatureType type = CreatureType.getWoolType(evt.getClickedBlock().getData());
            
            if (rnd.nextInt(10) < 5) {
                loc.getWorld().spawnParticle(type.getParticle(), loc.getX() + .5, loc.getY() + .5, loc.getZ() + .5, 6, .6, .6, .6, .1);
                return;
            }
            if (rnd.nextInt(10) < 1) {
                evt.getPlayer().sendMessage(type.getChatColor() + "You hear something rustling in the mushroom!");
                return;
            }

            if (rnd.nextInt(20) < 1) { // 90% chance
                Creature.spawnCreature(type, evt.getClickedBlock().getRelative(evt.getBlockFace()).getLocation()); //brain halp why doesnt this work
            }
        }
    }
    
    // So now we have Creature classes, which contain the state and define the behavior of each creature. They will of course need to be told when something happens to them.
    // The creature classes are not watchers and it wouldn't make sense to make them ones, because there would be one watcher for
    // every creature and each would receive events for ALL mobs. It's more efficient to have one watcher listen for events, filter out the
    // relevant ones and dish those out to the creatures they belong to
    // that's what we do here.
    
    
    @EventHandler
    /* oh wow duh */ public void onInteract(PlayerInteractEntityEvent evt) {
        
        // This will get called every time anyone clicks any mob for any reason, including sheep, horses and item frames.
        // We have to filter out the events we are interested in
        // To do this efficiently, we check for the most obvious signs that an event is not what we want first and return without doing anything:
        
        /* this is already pissing me off again */ Entity clicked = evt.getRightClicked();
        
        if(clicked.getType() != EntityType.BAT && clicked.getType() != EntityType.RABBIT) {
            return;
        }
        
        // If the code reaches beyond that return, we know it's at least the right kind of mob. Next we could check potion effects or stuff, but
        // at this point it's probably best to just check for the metadata i left when spawning the creature
        
        if(!clicked.hasMetadata("wonderland.creature")) {
            return;
        }
        
        // Now we know it's definitely one of ours. We can proceed to work out which and let it know things happened
        
        
        Creature creature = (Creature) clicked.getMetadata("wonderland.creature").get(0).value(); // DO NOT even question this. I said i hate it xD
        // FixedMetadataValues contain things no more specific than "Object". We know it's a creature, so we can explicitly cast
        
        
        // Now that we know who is involved, tap it
        
        creature.onInteract(evt.getPlayer());
        
        // and now we are finally ready
        
        
        
        
    }
    
}
