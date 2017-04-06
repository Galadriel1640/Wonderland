/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland.creature;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Item;

/**
 *
 * @author Isabella
 */
public abstract class Fairy extends Creature {
    
    // This is now red because it extends Creature, but does not initialize the item and mob.
    // Any Fairy is also a Creature, but creatures consist of items and mobs, yet fairies somehow don't
    // Java does not like this.
    // We fix this by giving this a constructor too, and passing the arguments to the constructor of Creatrure
    
    public Fairy(LivingEntity mobEntity, Item itemEntity) {
        super(mobEntity, itemEntity); // okay just wanted to test something.. here's the actual syntax:
        // This calls the constructor of the next higher class in the hierarchy
        // The fields declared in Creature are inherited by Fairy, meaning this now has a mobEntity and an itemEntity without having to declare them again
        // That's the main idea of class inheritance. You can now add more fields, which makes this class a more "specific" case of a creature
    }//sorry :p youre good now
    
    
    // This is now saying the method defined in Fairy overrides the one in Creature. This will work by default, but it asks you to
    // add this annotation. it doesn't REALLY have an effect, but I think it used to and it still is good practice
    @Override
    public void onInteract(Player player) {
        player.sendMessage("You are interacting with a generic Fairy");
        // this will illustrate the mechanics of inheritance in a moment
    }
    
}

// Auto format: Alt+Shift+F
