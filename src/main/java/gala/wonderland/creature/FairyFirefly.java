/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland.creature;

import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;

/**
 *
 * @author Isabella
 */
public class FairyFirefly extends Fairy {

    public FairyFirefly(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.FIREFLY_FAIRY;
    }
}


/*
I WILL FIND A WAY TO MAKE YOU GLOW
only spawns at night, but anywhere
glows. somehow.
drops xp casualy as they fly around, an orb at a time
poof out all the particles
no player interactions unless killed, then drops glowstone( or 3-4 dust) and makes a sad noise to shame the player


*/