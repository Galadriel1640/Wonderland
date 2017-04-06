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
public class FairyFlower extends Fairy {

    public FairyFlower(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.FLOWER_FAIRY;
    }
}





/*
Feed it colored wool/dye/clay it will drop out the corrosponding color flower
or maybe just randomly drops flowers?
spawns around flowers :3
non hostile




*/