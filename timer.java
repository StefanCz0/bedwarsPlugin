package cz.stefan.bedwars;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class timer extends BukkitRunnable{
	public main m;
	public int diamond=0;
	public int msgsecond=0;
	public int emerald=0;
	public timer(main m) {
		this.m = m;
	}
	@Override
	public void run() {
		if(main.inGame) {
			if(diamond==15) {
				spawner.getSpawners(SpawnerType.diamond).spawn();
				diamond=0;
			}
			if(emerald==15) {
				spawner.getSpawners(SpawnerType.diamond).spawn();
				emerald=0;
			}

			if(msgsecond==40) {
				Bukkit.broadcastMessage(ChatColor.RED+"[WARNING] Cross teaming is not allowed! /report <player>");

			}
			msgsecond++;
			diamond++;
			emerald++;
		}

	}

}
