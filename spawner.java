package cz.stefan.bedwars;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class spawner{
	public SpawnerType type;
	public Location loc;
	public static ArrayList<spawner> list = new ArrayList<spawner>();
	public spawner(SpawnerType type, Location loc) {
		this.loc = loc;
		this.type = type;
		list.add(this);
	}
	public static spawner getSpawners(SpawnerType p) {
		spawner sp=null;
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getType()==p) {
				sp =list.get(i);
			}
		}
		return sp;
	}
	public void spawn() {
		if(this.type==SpawnerType.diamond) {
			ItemStack diamond = new ItemStack(Material.DIAMOND);
			loc.getWorld().dropItem(loc, diamond);
		}
		if(this.type==SpawnerType.iron) {
			ItemStack iron = new ItemStack(Material.IRON_INGOT);
			loc.getWorld().dropItem(loc, iron);
		}
		if(this.type==SpawnerType.gold) {
			ItemStack gold = new ItemStack(Material.GOLD_INGOT);
			loc.getWorld().dropItem(loc, gold);
		}
		if(this.type==SpawnerType.team) {
			ItemStack iron = new ItemStack(Material.IRON_INGOT);
			loc.getWorld().dropItem(loc, iron);
			ItemStack gold = new ItemStack(Material.GOLD_INGOT);
			loc.getWorld().dropItem(loc, gold);
		}
	}
	public Location getLoc() {
		return loc;
	}
	public SpawnerType getType() {
		return type;
	}
}
