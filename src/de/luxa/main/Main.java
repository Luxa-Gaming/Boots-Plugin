package de.luxa.main;


import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.luxa.boots.CMDsetboottrader;
import de.luxa.boots.EVENTboots;


public class Main extends JavaPlugin{
	
	
	@Override
	public void onEnable(){
		System.out.println("Enabled");
		
		this.getCommand("setboottrader").setExecutor(new CMDsetboottrader());
		
		PluginManager pm = Bukkit.getPluginManager();


			pm.registerEvents(new EVENTboots(),this);
		}
	}

	

