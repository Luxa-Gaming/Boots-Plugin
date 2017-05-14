package de.luxa.boots;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class BootTrader {

	public BootTrader(Player p) {
		Witch v = (Witch) p.getWorld().spawnEntity(p.getLocation(), EntityType.WITCH);
		v.setCustomName("§5§lLynix");
		v.setCustomNameVisible(true);
		v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 50000000, 5000000));
		v.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 50000000, 5000000));
	}
	
	public static Inventory getBootInv() {
		Inventory Inv = Bukkit.createInventory(null, 9*1, "§6§lHexenboots-Shop");
		Inv.addItem(createBoot("§cFire-Boots", Color.RED));
		Inv.addItem(createBoot("§bWater-Boots", Color.BLUE));
		Inv.addItem(createBoot("Cloud-Boots", Color.AQUA));
		return Inv; 
	}
	
	private static ItemStack createBoot(String name, Color color) {
		ItemStack item= new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta imeta = (LeatherArmorMeta) item.getItemMeta(); 
		imeta.setDisplayName(name);
		imeta.setColor(color);
		item.setItemMeta(imeta);
		return item;
	}
	
}
