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
public class FairyMagic extends Fairy {

    public FairyMagic(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }

    @Override
    public CreatureType getType() {
        return CreatureType.MAGIC_FAIRY;

    
}
}



/*
random potion effects when clicked, good and bad ones
makes certain noises based if the potion was a good one or a harmful one
larger chance to get a good one



*/