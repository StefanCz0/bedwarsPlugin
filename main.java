package cz.stefan.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public final class main extends JavaPlugin{
	public boolean SCVisible;
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		Player pl = event.getPlayer();
		Block block = event.getBlock();
		Material wool = Material.WHITE_WOOL;
		if(block.getBlockData().getMaterial()==wool) {
		if(team.getTeam(pl).getTeamColor()==ChatColor.RED) {
		wool = Material.RED_WOOL;
		}
		block.setType(wool);
		}
		
	}
	@Override
	public void onEnable() {
		getLogger().info("plugin enabled");

	}

	@Override
	public void onDisable() {
		getLogger().info("plugin disabled");
	}
	public void scoreBoard() {
		team tmpTm = team.getTeams();	
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		Team tm = board.registerNewTeam(tmpTm.getTeamName());
		tm.setColor(tmpTm.getTeamColor());
		tm.setPrefix("["+tmpTm.getTeamName()+"] ");
		Objective objective = board.registerNewObjective("BedWars", "dummy");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("BedWars");
		Score sc1 = objective.getScore("");
		sc1.setScore(1);
		Score sc2 = objective.getScore(""); 
		sc2.setScore(2);
	}
	@Override 
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){

		if(label.equalsIgnoreCase("bw")) {

			if(sender instanceof Player) {
				if(args[0].equalsIgnoreCase("scoreboard")) {
					if(args[1].equalsIgnoreCase("true")) {
						
					}
				}
				if(args[0].equalsIgnoreCase("spawner"))if(args[1].equalsIgnoreCase("create"))if(args[2].equalsIgnoreCase("teamSpawner")) {}
				if(args[0].equalsIgnoreCase("team")) {

					if(args[1].equalsIgnoreCase("create")) {
						if(args[2].equalsIgnoreCase("red")) {team red =new team(args[3], ChatColor.RED); }
						if(args[2].equalsIgnoreCase("dark_red")) {team dark_red=new team(args[3], ChatColor.DARK_RED);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("aqua")) {team aqua=new team(args[3], ChatColor.AQUA);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("dark_aqua")) {team dark_aqua=new team(args[3], ChatColor.DARK_AQUA);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("blue")) {team blue=new team(args[3], ChatColor.BLUE);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("dark_blue")) {team dark_blue=new team(args[3], ChatColor.DARK_BLUE);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("green")) {team green=new team(args[3], ChatColor.GREEN);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[3]);}
						if(args[2].equalsIgnoreCase("dark_green")) {team dark_green=new team(args[3], ChatColor.DARK_GREEN);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("yellow")) {team yellow=new team(args[3], ChatColor.YELLOW);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("light_purple")) {team light_purple=new team(args[3], ChatColor.LIGHT_PURPLE);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
						if(args[2].equalsIgnoreCase("dark_purple")) {team dark_purple=new team(args[3], ChatColor.DARK_PURPLE);sender.sendMessage("New team was created \n "+"team: "+args[3]+" color: " + args[2]);}
					}
					if(args[1].equalsIgnoreCase("get")) {
						team tmpTm = team.getTeams();	
						if(args[2].equalsIgnoreCase(tmpTm.getTeamName())) {
							sender.sendMessage("finded team "+tmpTm.getTeamName());
						}

					}
					if(args[1].equalsIgnoreCase("join")) {
						team tmpTm = team.getTeams();	
						if(args[2].equalsIgnoreCase(tmpTm.getTeamName())) {
							Player p = (Player) sender;
							team.addPlayer(tmpTm, p);
						}

					}
					if(args[1].equalsIgnoreCase("leave")) {
						team tmpTm = team.getTeams();	
						if(args[2].equalsIgnoreCase(tmpTm.getTeamName())) {
							Player p = (Player) sender;
							tmpTm.removePlayer(p);
						}

					}
					if(args[1].equalsIgnoreCase("remove")) {
						team tmpTm = team.getTeams();	
						if(args[2].equalsIgnoreCase(tmpTm.getTeamName())) {
							sender.sendMessage("deleting team "+tmpTm.getTeamName());
							team.removeTeam(tmpTm);
						}
						if(!(args[2].equalsIgnoreCase(tmpTm.getTeamName()))) {
							sender.sendMessage("team do not exists: "+tmpTm.getTeamName());

						}

					}
				}

				if(args[0].equalsIgnoreCase("info")) sender.sendMessage(ChatColor.AQUA+"INFO \n" + ChatColor.WHITE+"author: pavelstef \n "+"version: alpha");
			} else
				return true;
		}
		return false;
	}



}
