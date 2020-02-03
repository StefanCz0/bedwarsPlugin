package cz.stefan.bedwars;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventException;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class joinEvent implements Listener{
	public main m;
	public int i = 0;
	public joinEvent(main m) {
		this.m = m;
	}
	public team ts=new team("",ChatColor.RESET);
	@EventHandler
	public void PlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		i = 0;
		p.sendMessage(m.getConfig().getString("onJoin.message"));
		ScoreboardManager manager = Bukkit.getServer().getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();

		for(int k = 0; k<30; k++) {
			try {
			if(Material.getMaterial(m.getConfig().getString("onJoin.player.slot_"+k+".material"))!=null) {
				ItemStack stack = new ItemStack(Material.getMaterial(m.getConfig().getString("onJoin.player.slot_"+k+".material")));
				ItemMeta meta = stack.getItemMeta();
				meta.setDisplayName(m.getConfig().getString("onJoin.player.slot_"+k+".name"));
				event.getPlayer().getInventory().setItem(k, stack);
			}}catch (NullPointerException e) {}
		}
		Objective objective = board.registerNewObjective("test", "dummy");

		objective.setDisplayName(ChatColor.BOLD+""+ChatColor.GREEN+"Bedwars");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		if(team.teamExists(1)) {
			team.removeTeam(ts);
			Score sc2 = objective.getScore(team.getTeamsColor(0)+team.getTeamsName(0));
			sc2.setScore(0);
		}else {
			Score sc2 = objective.getScore(team.getTeamsColor(0)+team.getTeamsName(0));
			sc2.setScore(0);}

		Score sc1 = objective.getScore(ChatColor.AQUA+"Teams: "); 
		sc1.setScore(1);
		Score sc = objective.getScore(" "); 
		sc.setScore(2);
		p.setScoreboard(board);
	}
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		for(int k = 0; k<30; k++) {
			try {
			if(Material.getMaterial(m.getConfig().getString("onJoin.player.slot_"+k+".material"))!=null) {
				Player p = (Player)e.getWhoClicked();
				ItemStack stack = new ItemStack(Material.getMaterial(m.getConfig().getString("onJoin.player.slot_"+k+".material")));
				if(p.getItemInHand()==stack) {
					if(m.getConfig().getString("onJoin.player.slot_"+k+".onClick")=="startGame") {
						if(team.getTeam(p).getTeamName()=="ADMIN") {m.start(); p.sendMessage("game started");}
					}
				}
				
	
				
			}}catch (NullPointerException ex) {}
		}
	}
}
