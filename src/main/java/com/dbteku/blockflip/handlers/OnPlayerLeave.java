package com.dbteku.blockflip.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.dbteku.memory.PlayerMemory;

public class OnPlayerLeave implements Listener{

	private PlayerMemory memory;
	
	public OnPlayerLeave(PlayerMemory memory){
		this.memory = memory;
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
	    String playerName = event.getPlayer().getName();
//	    memory.writePlayerSettingToDiskAndRemove(playerName);
	}
	
}
