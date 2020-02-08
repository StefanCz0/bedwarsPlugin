package cz.stefan.bedwars;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class blockPlaceListener implements Listener{
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		team tempTeam = team.getTeams();
		if(tempTeam.hasTeam(e.getPlayer())) {
			if(tempTeam.getTeam(e.getPlayer()).getTeamColor().equals(ChatColor.GREEN)) {
				Block tempBlock = e.getBlockPlaced();
				if (tempBlock.getType().equals(Material.WHITE_WOOL))tempBlock.setType(Material.GREEN_WOOL);

			}
		}
	}
}
