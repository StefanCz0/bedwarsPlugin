package cz.stefan.bedwars;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;



public class spawner{
	
	static ArrayList<spawner> spawners = new ArrayList<spawner>();
	public static Player p;
	public String type;
	public Location loc;
	public spawner(Player p, String type){
	this.p=p;
	this.type=type;
	}
	public static void create(spawner sp){
	   sp.setLocation(p.getLocation());
	   spawners.add(sp);  
	}
	public static spawner getSpawner() {
		spawner tempSpawner = null;
		for(int i = 0; i<spawners.size();i++) {
			tempSpawner = spawners.get(i);
		}
		return tempSpawner;
		
		
	}
	public void spawn(){
	  if(main.inGame){
	  if(type=="base"){ 
	    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
	        scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {
	            @Override
	            public void run() {
	                p.getWorld().dropItemNaturally(getLocation(), new ItemStack(Material.IRON_INGOT));
	            }
	        }, 10L);
	        scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() {
	            @Override
	            public void run() {
	                p.getWorld().dropItemNaturally(getLocation(), new ItemStack(Material.GOLD_INGOT));
	            }
	        }, 100L);
	        }
	    }
	}
	public Location getLocation(){
	  return loc;
	}
	public void setLocation(Location l){
	  l = loc;
	}
	
}
