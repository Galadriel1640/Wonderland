/* s.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gala.wonderland.creature;

import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.material.Wool;
import org.bukkit.Particle;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.SkullType;
import org.bukkit.EntityEffect;
import org.bukkit.Sound;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.inventory.ItemStack;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;

/**
 *
 * @author Isabella
 */
public class Sprites implements Listener {

    Random rnd = new Random();

    ChatColor messageColor = null;
    Location loc = null;
    World world = null;
    String spriteSpawnMessage = null;
    String spriteName = null;
    DyeColor spriteColor = null;
    Material spriteMaterial = null;

    @EventHandler
    public void onClickBlock(PlayerInteractEvent evt) {

        if (evt.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        ItemStack is = evt.getItem();
        if (is != null
                && is.getType() == spriteMaterial
                && is.hasItemMeta()
                && is.getItemMeta().hasLore()
                && is.getItemMeta().getLore()
                        .contains(spriteName + " sprite nest")) {
            switch (evt.getClickedBlock().getData()) {
                case 1:

                    spriteName = "Forest";
                    messageColor = ChatColor.GREEN;
                    spriteSpawnMessage = "A forest sprite has appeared!";
                    spriteColor = DyeColor.GREEN;
                    spriteMaterial = Material.APPLE;
                    break;
                case 2:

                    spriteName = "Water";
                    messageColor = ChatColor.BLUE;
                    spriteSpawnMessage = "A water sprite has appeared!";
                    spriteColor = DyeColor.BLUE;
                    spriteMaterial = Material.PRISMARINE_CRYSTALS;
                    break;
                case 3:

                    spriteName = "Mushroom";
                    messageColor = ChatColor.RED;
                    spriteSpawnMessage = "A mushroom sprite has appeared!";
                    spriteColor = DyeColor.RED;
                    spriteMaterial = Material.RED_MUSHROOM;
                    break;
                default:
            }
        }

        if (rnd.nextInt(1) < 1) {
            evt.getPlayer().sendMessage(messageColor + "You hear noises coming from inside this item!");
            Location loc = evt.getClickedBlock().getLocation();
            evt.getClickedBlock().getRelative(evt.getBlockFace());

            // Create invisible ocelotthings aer
            Entity entity = world.spawnEntity(loc, EntityType.OCELOT);
            LivingEntity living = (LivingEntity) entity;
            living.setSilent(true);
            living.setCustomName(messageColor + spriteName + " Sprite");
            living.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 0));

            // Create wool item
            ItemStack spriteItemStack = (new Wool(spriteColor)).toItemStack(1);
            Item spriteEntity = world.dropItem(living.getLocation(), spriteItemStack); //spawn the block
            spriteEntity.setGravity(false);

            //keep wool from being picked up
            spriteEntity.setPickupDelay(Integer.MAX_VALUE);

            // Attach wool to ocelot
            living.setPassenger(spriteEntity);

            //Spawn Sound
            spriteEntity.getWorld().playSound(spriteEntity.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 2f);
            spriteEntity.getWorld().playSound(spriteEntity.getLocation(), Sound.ENTITY_RABBIT_AMBIENT, 1, 2f);
            spriteEntity.getWorld().playSound(spriteEntity.getLocation(), Sound.ENTITY_LLAMA_AMBIENT, 1, 2f);

            //spawn message
            //evt.getPlayer().sendMessage(messageColor + spriteSpawnMessage);  // &d 
        }

    }
}
