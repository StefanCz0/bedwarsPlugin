package cz.stefan.bedwars;

import org.bukkit.scheduler.BukkitRunnable;

public class task extends BukkitRunnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		spawner.getSpawner().spawn();
	}}