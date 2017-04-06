/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland.creature;

import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.material.Wool;
import org.bukkit.entity.EntityType;

/**
 *
 * @author Isabella
 */
public enum CreatureType {
    
    FIRE_FAIRY("Fire Fairy", Particle.FLAME, ChatColor.RED, "I'm a Fire fairy!", (new Wool(DyeColor.RED)).toItemStack(1), EntityType.BAT), 
    SNOW_FAIRY("Snow Fairy", Particle.SNOW_SHOVEL, ChatColor.WHITE , "I'm a Snow fairy!", (new Wool(DyeColor.WHITE)).toItemStack(1), EntityType.BAT), 
    NYAN_FAIRY("Nyan Fairy", Particle.CRIT_MAGIC, ChatColor.AQUA , "I'm a Nyan fairy!", (new Wool(DyeColor.CYAN)).toItemStack(1), EntityType.BAT), 
    MAGIC_FAIRY("Magic Fairy", Particle.SPELL_WITCH, ChatColor.DARK_PURPLE , "I'm a Magic fairy!", (new Wool(DyeColor.PURPLE)).toItemStack(1), EntityType.BAT),  
    STORM_FAIRY("Storm Fairy", Particle.VILLAGER_ANGRY, ChatColor.DARK_GRAY , "I'm a Storm fairy!", (new Wool(DyeColor.GRAY)).toItemStack(1), EntityType.BAT), 
    EARTH_FAIRY("Earth Fairy", Particle.BLOCK_DUST, ChatColor.DARK_GREEN , "I'm an Earth fairy!", (new Wool(DyeColor.BROWN)).toItemStack(1), EntityType.BAT),  
    MOSS_FAIRY("Moss Fairy", Particle.TOTEM, ChatColor.DARK_GREEN , "I'm a Moss fairy!", (new Wool(DyeColor.GREEN)).toItemStack(1), EntityType.BAT), 
    FIREFLY_FAIRY("Firefly Fairy", Particle.SPELL_MOB, ChatColor.GOLD , "I'm a Firefly fairy!", (new Wool(DyeColor.ORANGE)).toItemStack(1), EntityType.BAT), 
    SUN_FAIRY("Sun Fairy", Particle.SPELL, ChatColor.YELLOW , "I'm a Sun fairy!", (new Wool(DyeColor.YELLOW)).toItemStack(1), EntityType.BAT),  
    LOVE_FAIRY("Love Fairy", Particle.HEART, ChatColor.LIGHT_PURPLE , "I'm a Love fairy!", (new Wool(DyeColor.PINK)).toItemStack(1), EntityType.BAT), 
    SPRING_FAIRY("Spring Fairy", Particle.VILLAGER_HAPPY, ChatColor.GREEN , "I'm a Spring fairy!", (new Wool(DyeColor.LIME)).toItemStack(1), EntityType.BAT), 
    FLOWER_FAIRY("Flower Fairy", Particle.DRAGON_BREATH, ChatColor.DARK_PURPLE , "I'm a Flower fairy!", (new Wool(DyeColor.MAGENTA)).toItemStack(1), EntityType.BAT), 
    SKY_FAIRY("Sky Fairy", Particle.FLAME, ChatColor.DARK_AQUA , "I'm a Sky fairy!", (new Wool(DyeColor.LIGHT_BLUE)).toItemStack(1), EntityType.BAT),  
    MOON_FAIRY("Moon Fairy", Particle.END_ROD, ChatColor.BLACK , "I'm a Moon fairy!", (new Wool(DyeColor.BLACK)).toItemStack(1), EntityType.BAT), 
    OCEAN_FAIRY("Ocean Fairy", Particle.MOB_APPEARANCE, ChatColor.BLUE , "I'm an Ocean fairy!", (new Wool(DyeColor.BLUE)).toItemStack(1), EntityType.BAT), 
    DUSK_FAIRY("Dusk Fairy", Particle.CLOUD, ChatColor.RED , "I'm a Dusk fairy!", (new Wool(DyeColor.SILVER)).toItemStack(1), EntityType.BAT);
    
    private static final CreatureType[] woolBlockTypes = {
        SNOW_FAIRY,
        FIREFLY_FAIRY,
        FLOWER_FAIRY,
        SKY_FAIRY,
        SUN_FAIRY,
        SPRING_FAIRY,
        LOVE_FAIRY,
        STORM_FAIRY,
        DUSK_FAIRY,
        NYAN_FAIRY,
        MAGIC_FAIRY,
        OCEAN_FAIRY,
        EARTH_FAIRY,
        MOSS_FAIRY,
        FIRE_FAIRY,
        MOON_FAIRY
    };
    
    private final String creatureName;
    private final Particle particleType;
    private final ChatColor chatColor;
    private final String spawnMessage;
    private final ItemStack itemStack;
    private final EntityType mobType;
    
    private CreatureType(String creatureName, Particle particleType, ChatColor chatColor, String spawnMessage, ItemStack itemStack, EntityType mobType) {
        this.creatureName = creatureName;
        this.particleType = particleType;
        this.chatColor = chatColor;
        this.spawnMessage = chatColor + spawnMessage;
        this.itemStack = itemStack;
        this.mobType = mobType;
    }
    
    public static CreatureType getWoolType(int woolData) {
        return woolBlockTypes[woolData];
    }
    
    public String getName() {
        return creatureName;
    }
    
    public Particle getParticle() {
        return particleType;
    }
    
    public ChatColor getChatColor() {
        return chatColor;
    }
    
    public EntityType getMobType() {
        return mobType;
    }
    
    public String getSpawnMessage() {
        return spawnMessage;
    }
    
    public ItemStack getItemStack() {
        return itemStack;
    }
}
