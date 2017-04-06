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
public class FairyStorm extends Fairy {

    public FairyStorm(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.STORM_FAIRY;
    }
}


/*
Only hostile fairy besides fire
when clicked makes angry noises, clicking has a random chance to smite you with lightning
clicking always makes storm noises



*/