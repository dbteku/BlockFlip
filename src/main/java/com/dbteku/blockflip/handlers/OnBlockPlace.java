package com.dbteku.blockflip.handlers;

import org.bukkit.Axis;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Orientable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.dbteku.blockflip.main.BlockFlipPlugin;
import com.dbteku.memory.PlayerMemory;

public class OnBlockPlace implements Listener{

	private BlockFlipPlugin plugin;
	private PlayerMemory memory;

	public OnBlockPlace(BlockFlipPlugin plugin, PlayerMemory memory){
		this.memory = memory;
		this.plugin = plugin;
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){	
		final Block block = event.getBlockPlaced();
		String playerName = event.getPlayer().getName();
		if(isVerticalLocked(playerName)){
			if (block.getType() == Material.ACACIA_LOG  || 
					block.getType() == Material.BIRCH_LOG || 
					block.getType() == Material.DARK_OAK_LOG || 
					block.getType() == Material.JUNGLE_LOG || 
					block.getType() == Material.OAK_LOG || 
					block.getType() == Material.SPRUCE_LOG || 
					block.getType() == Material.STRIPPED_ACACIA_LOG ||
					block.getType() == Material.STRIPPED_BIRCH_LOG ||
					block.getType() == Material.STRIPPED_DARK_OAK_LOG ||
					block.getType() == Material.STRIPPED_JUNGLE_LOG ||
					block.getType() == Material.STRIPPED_OAK_LOG ||
					block.getType() == Material.STRIPPED_SPRUCE_LOG ||
					block.getType() == Material.STRIPPED_ACACIA_WOOD ||
					block.getType() == Material.STRIPPED_BIRCH_WOOD ||
					block.getType() == Material.STRIPPED_DARK_OAK_WOOD ||
					block.getType() == Material.STRIPPED_JUNGLE_WOOD ||
					block.getType() == Material.STRIPPED_OAK_WOOD ||
					block.getType() == Material.STRIPPED_SPRUCE_WOOD
					) {
				flipBlock(block);
			}
		}
	}

	private void flipBlock(Block block){
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, ()->{
			BlockData data = block.getBlockData();
		    if(data instanceof Orientable) {
		    	Orientable orientation = (Orientable) data;
		        orientation.setAxis(Axis.Y);
		        block.setBlockData(orientation);
		    }
		});
	}
	
	private boolean isVerticalLocked(String playerName){
		return false;
	}

}
