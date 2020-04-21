package com.dbteku.blockflip.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{

	private final String BASE_CMD = "bfp";
	private final String HELP_CMD = "help";
	private final String VERSION = "version";
	private final String TOGGLE = "toggle";
	private final String STATUS = "status";
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(sender instanceof Player){
			playerCommand(label, args, sender);
		}else{
			consoleCommands(label,args,sender);
		}
		return false;
	}
	
	private void consoleCommands(String label, String[] args, CommandSender sender){
		if(label.equalsIgnoreCase(BASE_CMD)){
			
		}
	}
	
	private void playerCommand(String label, String[] args, CommandSender sender){
		String player = sender.getName();
		if(label.equalsIgnoreCase(BASE_CMD)){
			if(args.length > 0){
				if(args[0].equalsIgnoreCase(HELP_CMD)){
					// Send Help
				}
				else if(args[0].equalsIgnoreCase(VERSION)){
					//Send version
				}
				else if(args[0].equalsIgnoreCase(TOGGLE)){
					// Toggle vertical
				}
				else if(args[0].equalsIgnoreCase(STATUS)){
					// Get current status.
				}else{
					// Show syntax.
				}
			}else{
				// Send help
			}
		}
	}
	

}
