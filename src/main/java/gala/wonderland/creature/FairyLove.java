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
public class FairyLove extends Fairy {

    public FairyLove(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.LOVE_FAIRY;
    }
}




/*
very friendly, follows players around
can easily be tamed with x
non hostile
random spawn




*/