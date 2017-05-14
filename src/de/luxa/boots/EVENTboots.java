package de.luxa.boots;

import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Witch;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

@SuppressWarnings("deprecation")
public class EVENTboots implements Listener{

	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if(p.getInventory().getBoots() !=null && p.getInventory().getBoots().getType() != Material.AIR) {
			switch(p.getInventory().getBoots().getItemMeta().getDisplayName()) {
			case "§bWater-Boots":
				p.playEffect(p.getLocation().add(0, 1, 0), Effect.WATERDRIP, 1);
				break; 
			case"§cFire-Boots":
				p.playEffect(p.getLocation().add(0, 1, 0), Effect.LAVADRIP, 1);
				break;
			case "Cloud-Boots":
				p.playEffect(p.getLocation().add(0, 1, 0), Effect.CLOUD, 1);
				
				
				
				default:
					break; 
			}
		}
	}
	
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		System.out.println("[BOOTS DEBUG] onClick Event");
		if(e.getWhoClicked() instanceof Player) {
			System.out.println("[BOOTS DEBUG] Player instance detectedt");
			Player p = (Player) e.getWhoClicked(); 
			System.out.println("[BOOTS DEBUG] Player: " + p);
			
			System.out.println("[BOOTS DEBUG] 1: "+e.getClickedInventory().getTitle());
			System.out.println("[BOOTS DEBUG] bool: "+e.getClickedInventory().getTitle().equalsIgnoreCase("§6§lHexenboots-Shop"));
			if(e.getClickedInventory().getTitle().equalsIgnoreCase("§6§lHexenboots-Shop")) {
				System.out.println("[BOOTS DEBUG] BeforCancel");
				e.setCancelled(true);
				System.out.println("[BOOTS DEBUG] AfterCancel");
				if(e.getCurrentItem().getType() !=Material.AIR && e.getCurrentItem() !=null ) {
					p.getInventory().setBoots(e.getCurrentItem());
					System.out.println("[BOOTS DEBUG] Boots set!");
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEntityEvent e) {
		System.out.println("[BOOTS DEBUG] Interact Event");
		if(e.getRightClicked() instanceof Witch) {
			System.out.println("[BOOTS DEBUG] Whick clicked: "+(Witch) e.getRightClicked());
			Witch v = (Witch) e.getRightClicked();
			if(v.getCustomName().equalsIgnoreCase("§5§lLynix")) {
				System.out.println("[BOOTS DEBUG] Name matches!");
				e.setCancelled(true);
				e.getPlayer().openInventory(BootTrader.getBootInv()); 
			}
		}
	}
	
}
