package me.Mali_Plavi.MoreFood;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MoreFood extends JavaPlugin implements Listener{
	
	public Logger logger = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		logger.info("[" + ChatColor.DARK_AQUA + "MoreFood" +  ChatColor.WHITE + "]Has Been Enabled!");
		this.getServer().getPluginManager().registerEvents(this, this);
	}
	@Override
	public void onDisable() {
		logger.info("[" + ChatColor.DARK_AQUA + "MoreFood" +  ChatColor.WHITE + "]Has Been Disabled!");
	}
	@EventHandler
	public void onEat(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Action a = e.getAction();
		if(a == Action.RIGHT_CLICK_BLOCK || a == Action.RIGHT_CLICK_AIR){
			if(p.getFoodLevel() != 20){
			if (p.getInventory().getItemInHand().getType() == Material.GOLD_INGOT){
				int amount = p.getInventory().getItemInHand().getAmount();
				if(amount == 1){
					p.setItemInHand(new ItemStack(Material.AIR));
					p.setFoodLevel(p.getFoodLevel() + 8);
					p.playSound(p.getLocation(), Sound.EAT, 3 , 1);
					p.playEffect(p.getLocation() ,Effect.STEP_SOUND, Material.GOLD_BLOCK);
				}
				else{
				ItemStack butter = new ItemStack(Material.GOLD_INGOT, amount - 1);
				p.setItemInHand(butter);
				p.setFoodLevel(p.getFoodLevel() + 8);
				p.playSound(p.getLocation(), Sound.EAT, 3 , 1);
				p.playEffect(p.getLocation() ,Effect.STEP_SOUND, Material.GOLD_BLOCK);
				}
			}
			}
		}
	}
}
