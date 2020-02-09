package cz.stefan.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

public class timer extends BukkitRunnable{
	public main m;
	public int diamond=0;
	public int msgsecond=0;
	public int gold=0;
	public int TMGold = 0;
	public int TMIron = 0;
	public int iron = 0;
	public int i = 0;
	public timer(main m) {
		this.m = m;
	}
	@Override
	public void run() throws NullPointerException{
		if(main.inGame) {
			try {
			if(diamond==15) {
				main.getSpawners(SpawnerType.diamond).spawn();
				diamond=0;
			}
			if(iron==1) {
			main.getSpawners(SpawnerType.iron).spawn();
			iron=0;
			}
			if(TMGold==5) {
				main.getSpawners(SpawnerType.team).spawn(Material.GOLD_INGOT);
				TMGold=0;
			}
			
			main.getSpawners(SpawnerType.team).spawn(Material.IRON_INGOT);
			main.getSpawners(SpawnerType.team).random();
			
			if(gold==2) {
				main.getSpawners(SpawnerType.gold).spawn();
				gold=0;
			}
			
			if(msgsecond==40) {
				Bukkit.broadcastMessage(ChatColor.RED+"[WARNING] Cross teaming is not allowed! /report <player>");

			}
			}catch(NullPointerException e) {}
			i++;
			if(i==2) {
			i=0;
			msgsecond++;
			diamond++;
			gold++;
			TMGold++;
			iron++;
			}
			
		}

	}

}
