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
public class FairyNyan extends Fairy {

    public FairyNyan(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity);
    }
    
    
    @Override
    public CreatureType getType() {
        return CreatureType.NYAN_FAIRY;
    }
    
    // This is what i mean when i say you can't just draft up some code in java. it all has to have packages and its own file and ugh.
    // scripting laguages are much more efficient for quick dirty testing
    // try python

}


/*
semi rare spawn. spawns everywhere
when clicked makes a frightened noise and runs away
uses a rainbow snowball to explode in a rainbow?.-.

Or

makes you have rainbow chat for 30 seconds or so

(insert something colorful here)



*/
