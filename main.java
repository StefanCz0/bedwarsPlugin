package cz.stefan.bedwars;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_15_R1.util.CraftMagicNumbers.NBT;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public final class main extends JavaPlugin implements Listener{
	public boolean SCVisible;
	public static boolean inGame;
	
	
	public timer timer;
	@Override
	public void onEnable() {
		getLogger().info("plugin enabled");
		getServer().getPluginManager().registerEvents(new joinEvent(this), this);
		timer = new timer(this);
		
		timer.runTaskTimer(this, 0, 20);
	}


	@Override
	public void onDisable() {
		getLogger().info("plugin disabled");
		inGame=false;
	}
	
	@Override 
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		try {
			if(label.equalsIgnoreCase("report")) {
				if(args[0]==null) {
					sender.sendMessage("you must define valid user");
				} else {
					Player reported = Bukkit.getServer().getPlayer(args[0]);
					reported.sendMessage("You have been reported");
				}
			}
			if(label.equalsIgnoreCase("bw")||label.equalsIgnoreCase("bedwars")) {
				if(args[0].equalsIgnoreCase("reload")) {
					reload();
				}
				if(args[0].equalsIgnoreCase("start")) {
					inGame=true;
					Player p = (Player) sender;
					

				}
				if(args[0].equalsIgnoreCase("stop")) {
					inGame=false;

				}

				if(sender instanceof Player) {


					if(args[0].equalsIgnoreCase("spawner"))if(args[1].equalsIgnoreCase("create")) {
						if(args[2].equalsIgnoreCase("diamond")) {
							Player p = (Player) sender;
							Location loc = p.getLocation();
							spawner sp = new spawner(SpawnerType.diamond, loc);
							p.sendMessage("diamond spawner created");
						}
						if(args[2].equalsIgnoreCase("team")) {
						Player p = (Player) sender;
						Location loc = p.getLocation();
						spawner sp = new spawner(SpawnerType.team, loc);
						p.sendMessage("team spawner created");
						}
					}
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
						return false;
					}

					if(args[0].equalsIgnoreCase("info")) sender.sendMessage(ChatColor.AQUA+"INFO \n" + ChatColor.WHITE+"author: pavelstef \n "+"version: alpha");
				}
				return false;
			}

		} catch(Exception e) {
			sender.sendMessage(ChatColor.BLUE+"[bedwars]"+ChatColor.RED+" invalid command");

		}
		return true;
	}

	public void reload() {
		try {
			ScoreboardManager manager = Bukkit.getServer().getScoreboardManager();
			Scoreboard board = manager.getNewScoreboard();
			Objective objective = board.registerNewObjective("tst", "dummy");
			Player p = (Player) Bukkit.getServer().getOnlinePlayers();
			int i = 0;
			p.sendMessage(getConfig().getString("onJoin.message"));
			ScoreboardManager man = Bukkit.getServer().getScoreboardManager();
			Scoreboard bo = manager.getNewScoreboard();
			objective.setDisplayName(ChatColor.BOLD+""+ChatColor.GREEN+"Bedwars");
			objective.setDisplaySlot(DisplaySlot.SIDEBAR);


			Score sc1 = objective.getScore(ChatColor.AQUA+"Teams: "); 
			sc1.setScore(1);
			Score sc = objective.getScore(" "); 
			sc.setScore(2);
			p.setScoreboard(bo);
		} catch (NullPointerException e) {}
	}

}
