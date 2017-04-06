/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland.creature;

import gala.wonderland.Wonderland;
import gala.wonderland.creature.CreatureType;
import gala.wonderland.creature.FairyMoss;
import gala.wonderland.creature.FairyFire;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.metadata.FixedMetadataValue;

/**
 *
 * @author Isabella
 */
public abstract class Creature {

    // These fields will allow the Creature to keep track of its components
    protected final LivingEntity mobEntity;
    protected final Item itemEntity;

    protected Creature(LivingEntity mobEntity, Item itemEntity) {
        this.mobEntity = mobEntity;
        this.itemEntity = itemEntity; // this. ignores the parameter with the same name
    }

    public abstract CreatureType getType();

    public LivingEntity getMob() { // These don't need to be abstract anymore because the item and mob are actually known to this class now
        // I thought we might get some creatures that aren't stacks of entities, but that seems to be the general theme, no?
        //I mean i do want creatres that are just like cats with special effects or custom things about them and not a item stacked on a vanished mob, is that what you mean?
        // yes, but in fact i'm not sure we even need these methods, so we'll just drop them once we do cats  brb cat is scratching at the door
        return mobEntity;
    }

    public Item getItem() {
        return itemEntity;
    }

    public static void spawnCreature(CreatureType type, Location loc) {
        World world = loc.getWorld();
        ItemStack fairyItemStack = type.getItemStack();

        // Create invisible bat
        Entity entity = world.spawnEntity(loc, EntityType.BAT);
        LivingEntity living = (LivingEntity) entity;
        living.setSilent(true);
        living.setCustomName(type.getChatColor() + type.getName());
        living.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));

        // Create wool item
        Item fairyEntity = world.dropItem(living.getLocation(), fairyItemStack); //spawn the block
        fairyEntity.setGravity(false);

        //keep wool from being picked up
        fairyEntity.setPickupDelay(Integer.MAX_VALUE);

        // Attach wool to bat
        living.setPassenger(fairyEntity); // oh well O.p, do I need to add fairy there or keep it the same?

        // Create the creature object that will be associated with this mob/item
        
        Creature creature = null;
        
        switch(type) {
            case FIRE_FAIRY:
                creature = new FairyFire(living, fairyEntity);
                break;
            case MOSS_FAIRY:
                creature = new FairyMoss(living, fairyEntity);
                break;
            // there must be a case and a class for every kind of fairy here. otherwise it won't remember what creature it is after spawning, so for every fairy and im also guessing any new creatures i make as well?
                // yes, sprites and the such like
                // let's just make two more for now and see what happens            // there must be a case and a class for every kind of fairy here. otherwise it won't remember what creature it is after spawning, so for every fairy and im also guessing any new creatures i make as well?
                // yes, sprites and the such like
                // let's just make two more for now and see what happens
        }
        
        living.setMetadata("wonderland.creature", new FixedMetadataValue(Wonderland.instance, creature));
        // don't worry too much about this metadata syntax. I hate it.
        // This is still complaining because the metadata value also needs a reference to the plugin that owns it.
        // it must be the actual instance the server creates when it launches your plugin. this requires one more trick in the Wonderland class
        
        //Spawn Sound
        fairyEntity.getWorld().playSound(fairyEntity.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 2f);
        fairyEntity.getWorld().playSound(fairyEntity.getLocation(), Sound.ENTITY_CAT_AMBIENT, 1, 2f);

        //spawn message
        //evt.getPlayer().sendMessage(messageColor + fairySpawnMessage);  // &d 
    }

    public void onInteract(org.bukkit.entity.Player player) { // Fully qualified class names (with package) can be used to specify a type if for some reason imports aren't autocompleting.
        // This method does nothing by default. Subclasses (extending classes) will override this, but if they don't, this is the default code
        player.sendMessage("You are interacting with a creature");
    }

    public void onDamage(EntityDamageEvent evt) {

    }

    public void onAttack(EntityDamageByEntityEvent evt) {

    }

    public void onDeath(EntityDeathEvent evt) {
        onDeath();
    }

    public void onDeath() { // This is called overloading. You can define multiple methods with the same name if they can be distinguished by their parameters
        mobEntity.remove();
        itemEntity.remove();
        // Make sure no decapitated fairies float around
    }
    
    
    // This will be spam-called on every creature on every tick. That's what will let us do AI later on
    // creatures will scan their environment and decide what to do in here
    public void onTick() {
        
    }

}
