package com.dbteku.blockflip.handlers;

import java.util.ArrayList;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;

import com.dbteku.blockflip.main.BlockFlipPlugin;
import com.dbteku.memory.PlayerMemory;

public class EventManager {
	
	private PluginManager pm;
	private BlockFlipPlugin plugin;
	private OnBlockPlace onBlockPlace;
	private OnPlayerJoin onPlayerJoin;
	private OnPlayerLeave onPlayerLeave;
	private ArrayList<Listener> events;
	private PlayerMemory memory;
	
	public EventManager(BlockFlipPlugin plugin, PluginManager pm, PlayerMemory memory){
		this.memory = memory;
		this.plugin = plugin;
		this.pm = pm;
		this.events = new ArrayList<Listener>();
	}
	
	public void registerEvents(){
		onBlockPlace = new OnBlockPlace(plugin, memory);
		onPlayerJoin = new OnPlayerJoin(memory);
		onPlayerLeave = new OnPlayerLeave(memory);
		events.add(onBlockPlace);
		events.add(onPlayerJoin);
		events.add(onPlayerLeave);
		register();
	}
	
	private void register(){
		for(Listener l: events){
			pm.registerEvents(l, plugin);
		}
	}

}
