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
public class FairyMoss extends Fairy {

    public FairyMoss(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.MOSS_FAIRY;
    }

    public void onInteract(Player player) {
        //  keep trying xD
        player.sendMessage("This Moss fairy feels soft and cool");
    }
    
    // now we have some classes going. time to finish the factory method and then we can explore the effects of inheritance
    
    
}



/*
make slime sounds. its a must
the fuck does moss do, just looks cool....


*/
