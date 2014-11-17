package me.Funnygatt.GattSK.Managers;

import ch.njol.skript.Skript;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.HashMap;

public class ScoreboardManagers {
	
	public static ScoreboardManager scoreboardManager;
	public static HashMap<String, Scoreboard> boardList = new HashMap<String, Scoreboard>();

	public static Scoreboard board;

	// Scoreboard Creation and Getting
	//Possible Syntax: create [a] new scoreboard %string(s)%
	public static void createNewScoreboard(String name){
		if (getBoard(name) == null) {
			scoreboardManager = Bukkit.getScoreboardManager();
			board = scoreboardManager.getNewScoreboard();
			boardList.put(name, board);
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to create a Scoreboard that already Exists!");
		}
	}
	//Possible syntax: scoreboard [from] %string(s)%

	public static Scoreboard getBoard(String name){
		if (boardList.containsKey(name)){
			return boardList.get(name);
		}
		else{
			return null;
		}
	}


	// Score Related
	//Possible Syntax: set value [of] %string(board)% objective %string(obj)% for [score] %string(s)% to %integer(v)%
	public static void setScore(String boardname, String objective, String s, Integer v){
		if (getBoard(boardname) != null) {
			board = boardList.get(boardname);
			board.getObjective(objective.toString()).getScore(s).setScore(v);
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to set a score within a scoreboard that doesn't exist!");
		}

	}

	//Possible syntax: value [of] %string(board)% objective %string(obj)% for [score] %string(s)%
	public static int getScore(String boardname, String obj, String s){
		if (getBoard(boardname) != null) {
			board = boardList.get(boardname);
			int score = board.getObjective(obj.toString()).getScore(s).getScore();
			return score;
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to get a score within a scoreboard that doesn't exist!");
			return 0;
		}
	}

	public static void deleteScore(String boardname, String s){
		if (getBoard(boardname) != null) {
			board = boardList.get(boardname);
			board.resetScores(s);
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to remove a score within a scoreboard that doesn't exist!");
		}
	}
	
	//Scoreboard Objective Displays



	//Scoreboard of Player
	//Possible syntax: set scoreboard of %player% to %string% | set %player%'s scoreboard to %string%
	public static void setPlayerScoreboard(Player p, String boardname){
		if (getBoard(boardname) != null) {
			board = boardList.get(boardname);
			p.setScoreboard(board);
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to set a scoreboard for a player to a scoreboard that doesn't exist!");
		}
	}
	//Possible syntax: scoreboard of %player% | %player%'s scoreboard
	
	//Scoreboard Objectives
	//Possible syntax: create [a] [new] %ScoreboardTypes(objtype)% objective for [score][board] %string(board)% (called|named) %string(name)%
	public static void createObjective(String boardname, String name, String objtype){
		if (getBoard(boardname) != null) {
			Scoreboard board = boardList.get(boardname);
			board.registerNewObjective(name, objtype);
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to create an objective for a scoreboard that doesn't exist!");
		}
	}

	public static void setObjectiveDisplayName(String boardname, String name, String displayname){
		if (getBoard(boardname) != null) {
			Scoreboard board = boardList.get(boardname);
			board.getObjective(name).setDisplayName(displayname);
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to create an objective for a scoreboard that doesn't exist!");
		}
	}


	//Possible syntax: objective %string (name)% from [score][board] %string (board)%
	public static String getObjective(String boardname, String name){
		if (getBoard(boardname) != null) {
			Scoreboard board = boardList.get(boardname);
			return board.getObjective(name).toString();
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to get an objective for a scoreboard that doesn't exist!");
		}
		return null;
	}
	
	//Possible syntax: objective in [[display]slot] %displayslot% from [score][board] %string (board)%
	public static Objective getObjectiveDisplay(String boardname, String displaySlot){
		if (getBoard(boardname) != null) {
			Scoreboard board = boardList.get(boardname);
			return board.getObjective(displaySlot);
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to get an objective for a scoreboard that doesn't exist!");
			return null;
		}
	}
	
	//Possible syntax: objective type of %string(name)% (from|in) [score][board] %scoreboard(name)%
	public static String getObjectiveType(String boardname, String name){
		if (getBoard(boardname) != null) {
			Scoreboard board = boardList.get(boardname);
			String type = board.getObjective(name).getCriteria();
			return type;
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "Tried to get an objective type for a scoreboard that doesn't exist!");
			return null;
		}
	}
	public static Objective get(String id, String criteria, String boardname)
	{
		Scoreboard board = boardList.get(boardname);
		Objective o = board.getObjective(id);
		if (o == null) {
			o = board.registerNewObjective(id, criteria);
		}
		return o;
	}
	public static void setObjectiveDisplay(String boardname, String objective, String slot){
		board = boardList.get(boardname);
		if (slot.equalsIgnoreCase("sidebar") || slot.equalsIgnoreCase("side bar") || slot.equalsIgnoreCase("side_bar")) {
			board.getObjective(objective.toString()).setDisplaySlot(DisplaySlot.SIDEBAR);
		} else if (slot.equalsIgnoreCase("player list") || slot.equalsIgnoreCase("playerlist") || slot.equalsIgnoreCase("player_list")) {
			board.getObjective(objective.toString()).setDisplaySlot(DisplaySlot.PLAYER_LIST);
		} else if (slot.equalsIgnoreCase("below name") || slot.equalsIgnoreCase("belowname") || slot.equalsIgnoreCase("below_name")) {
			board.getObjective(objective.toString()).setDisplaySlot(DisplaySlot.BELOW_NAME);
		}
	}

}
