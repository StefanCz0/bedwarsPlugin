package cz.stefan.bedwars;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class team {
	public static ArrayList<team> teams = new ArrayList<team>();

	public static HashMap<String, team> playerTeams = new HashMap<String, team>();

	public ChatColor teamColor;
	public String nm;
	public static boolean alive;
	public static boolean hasBed;

	public team(String name, ChatColor clr){

		teamColor =clr;
		nm=name;
		teams.add(this);
	}
	public static team getTeams() {
		for(int i = 0; i<teams.size(); i++) {
		return teams.get(i);
		} 
		return null;
		}
	public static void removeTeam(team team) {
		teams.remove(team);
	}
	public static void addPlayer(team team, Player p){
		playerTeams.put(p.getName(), team);
	}

	public static void removePlayer(Player p){
		if(hasTeam(p) == true){
			playerTeams.remove(p.getName());
		}
	}
	// check if player has a team
	public static boolean hasTeam(Player p){
		return playerTeams.containsKey(p.getName());
	}
	
	public static team getTeam(Player p){

		if(hasTeam(p) == true){
		
			return playerTeams.get(p);
		}
		
		else if(hasTeam(p) == false){
			
			return null;
		}
		return null;
	}
	
	public ChatColor getTeamColor(){
		return teamColor;
	}
	public String getTeamName(){
		return nm;
	}
}
