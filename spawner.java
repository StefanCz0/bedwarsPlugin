package cz.stefan.bedwars;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class spawner{
	public SpawnerType type;
	public Location loc;

	
	public spawner(SpawnerType type, Location loc, int sample) {
		this.loc = loc;
		this.type = type;
		

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

	}
	public void spawn(Material spawn) {
		ItemStack diamond = new ItemStack(spawn);
		loc.getWorld().dropItem(loc, diamond);
	}
	public Location getLoc() {
		return loc;
	}
	public void random() {
		Random r = new Random();
		int rn = r.nextInt(6);
		if(rn==2) {loc.setX(loc.getX()+1); loc.setX(loc.getX()-1);}
		if(rn==0) { loc.setZ(loc.getZ()+1);loc.setZ(loc.getZ()-1);}
		if(rn==3) {loc.setX(loc.getX()-1);loc.setX(loc.getX()+1);}
		if(rn==5) {loc.setZ(loc.getZ()-1);loc.setZ(loc.getZ()+1);}

	}
	public SpawnerType getType() {
		return type;
	}
}
