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
public class FairySnow extends Fairy {

    public FairySnow(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.SNOW_FAIRY;
    }

}






/*



*/