package de.luxa.boots;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDsetboottrader implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if(command.getName().equalsIgnoreCase("setboottrader")) {
			if(sender instanceof Player) {
				Player p = (Player) sender; 
				if(p.hasPermission("boots.settrader")) {
					if(args.length == 0) {
						
						new BootTrader(p);
						
					}else{
						p.sendMessage("§cBitte benutze /setboottrader");
					}
				}else {
					p.sendMessage("§cDazu hast du leider keine Rechte!");
				}
			}
				
		}
		
		return false;
	}

}
