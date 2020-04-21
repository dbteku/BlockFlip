package com.dbteku.blockflip.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockFlipPlugin extends JavaPlugin {

	private static final String BASE_CMD = "bfp";
	
	public BlockFlipPlugin() {
		
	}
	
	@Override
	public void onEnable() {
		checkFolder();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public static boolean isOnline(String name){
		return Bukkit.getPlayer(name) != null;
	}
	
	
	private void checkFolder(){
		File file = new File("plugins/" + getDescription().getName());
		if(!file.exists()){
			file.mkdir();
		}
	}
	
	
}
