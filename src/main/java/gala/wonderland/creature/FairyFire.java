/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland.creature;

import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 *
 * @author Isabella
 * // You can probably tell what's next. One class for each type that overrides these methods with specific behavior
    
    // Remember: abstract means that you can't actually create an object of this class. It allows you to partially define <em>abstract methods</em>
    // probably only works in javadocs. let me try this xD
    * GG
    * just
    * let's move on xD
    * 
 */
public class FairyFire extends Fairy {

    public FairyFire(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.FIRE_FAIRY;
    }

    public void onInteract(Player player) {
        //  keep trying xD
        player.sendMessage("You are burining yourself on a Fire fairy!");
        //i really would love for the friggn javadocs to work xD 
        /*
        Add flame damage when clicked 
        unless offered magma cream, then have the fire fairy poot out something + happy sound at being fed?
        should they be tameable..
        make the fairy ones agressive and seek out players like hostile mobs? unless fed
        
        
        
        */
    }
    
    
    
    
}
