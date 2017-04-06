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
public class FairyDusk extends Fairy {

    public FairyDusk(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.DUSK_FAIRY;
    }
}


/*
only appearing at dusk( if possible) but will spawn anywhere 
non hostile
feed x to get x since if it only spawns at certain times
(die after dusk hours over?)


*/