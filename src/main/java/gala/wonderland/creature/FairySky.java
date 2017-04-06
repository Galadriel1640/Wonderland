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
public class FairySky extends Fairy {

    public FairySky(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.SKY_FAIRY;
    }
}

/*
-If fed something rare get a temporary flight effect? prehaps just speed or jump (think medor)
-non hostile
-shy

*/
