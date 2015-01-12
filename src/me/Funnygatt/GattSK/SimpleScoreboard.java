package me.Funnygatt.GattSK;

import ch.njol.skript.Skript;
import me.Funnygatt.GattSK.Managers.ScoreboardManagers;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.util.HashMap;

/**
 * Created by Zachary on 12/25/2014.
 */
public class SimpleScoreboard{
	//private HashMap<String, HashMap<Integer, String>> = new HashMap<String, HashMap<Integer, String>>();
	private static HashMap<Scoreboard, HashMap<Integer, String>> ScoreboardTracker = new HashMap<>();
	private static HashMap<String, Scoreboard> SimpleScoreboards = new HashMap<String, Scoreboard>();

	private static ScoreboardManager sbm = Bukkit.getScoreboardManager();

	public static void debug(String board){
		Scoreboard targetBoard = SimpleScoreboards.get(board);
		Bukkit.broadcastMessage("Scoreboard '" + board + "': " + targetBoard.toString());
		Bukkit.broadcastMessage("Objectives: " + targetBoard.getObjectives().toString());
		Bukkit.broadcastMessage("Title: " + targetBoard.getObjective("SimpleScoreboard").getDisplayName());
		Bukkit.broadcastMessage("HashMap 'ScoreboardTracker': " + ScoreboardTracker.toString());
		Bukkit.broadcastMessage("HashMap 'SimpleScoreboards': " + SimpleScoreboards.toString());
		Bukkit.broadcastMessage("HashMap 'ScoreboardTracker.get': " + ScoreboardTracker.get(targetBoard).toString());
	}

	public static void newSimpleScoreboard(String name){
		Scoreboard newBoard = sbm.getNewScoreboard();
		newBoard.registerNewObjective("SimpleScoreboard", "dummy");
		newBoard.getObjective("SimpleScoreboard").setDisplaySlot(DisplaySlot.SIDEBAR);
		SimpleScoreboards.put(name, newBoard);
		ScoreboardManagers.boardList.put(name, newBoard);
		HashMap<Integer, String> newMap = new HashMap<Integer, String>();
		newMap.put(1, "&1");
		newMap.put(2, "&2");
		newMap.put(3, "&3");
		newMap.put(4, "&4");
		newMap.put(5, "&5");
		newMap.put(6, "&6");
		newMap.put(7, "&7");
		newMap.put(8, "&8");
		newMap.put(9, "&9");
		newMap.put(10, "&0");
		newMap.put(11, "&a");
		newMap.put(12, "&b");
		newMap.put(13, "&c");
		newMap.put(14, "&d");
		newMap.put(15, "&e");
		ScoreboardTracker.put(newBoard, newMap);
	/*	newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&1")).setScore(1);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&2")).setScore(2);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&3")).setScore(3);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&4")).setScore(4);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&5")).setScore(5);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&6")).setScore(6);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&7")).setScore(7);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&8")).setScore(8);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&9")).setScore(9);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&0")).setScore(10);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&a")).setScore(11);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&b")).setScore(12);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&c")).setScore(13);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&d")).setScore(14);
		newBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&e")).setScore(15);*/

	}

	public static void showSimpleBoard(Player targetPlayer, String scoreboardName){
		Scoreboard targetBoard = SimpleScoreboards.get(scoreboardName);
		targetPlayer.setScoreboard(targetBoard);
	}

	public static void setScoreboardTitle(String scoreboardName, String title){
		Scoreboard targetBoard = SimpleScoreboards.get(scoreboardName);
		targetBoard.getObjective("SimpleScoreboard").setDisplayName(title);
	}

	public static void clearScore(String scoreboardName, Integer slot){
		Scoreboard targetBoard = SimpleScoreboards.get(scoreboardName);
		if (slot <= 15){
			if (slot > 0){
			//Bukkit.broadcastMessage("Score to Reset: " + null);
			HashMap<Integer, String> hashMap = ScoreboardTracker.get(targetBoard);
				if (hashMap.containsKey(slot)) {
					String score2reset = hashMap.get(slot);
					//Bukkit.broadcastMessage("Score to Reset: " + score2reset);
					targetBoard.resetScores(score2reset);
					hashMap.remove(slot);
				}
				ScoreboardTracker.put(targetBoard, hashMap);
				if (slot < 10) {
					targetBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&" + slot)).setScore(slot);
				}
				else{
					if (slot == 10){
						targetBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&0")).setScore(slot);
					}
					if (slot == 11){
						targetBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&a")).setScore(slot);
					}
					if (slot == 12){
						targetBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&b")).setScore(slot);
					}
					if (slot == 13){
						targetBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&c")).setScore(slot);
					}
					if (slot == 14){
						targetBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&d")).setScore(slot);
					}
					if (slot == 15){
						targetBoard.getObjective("SimpleScoreboard").getScore(ChatColor.translateAlternateColorCodes('&', "&e")).setScore(slot);
					}
				}
			}
			else{
				Skript.error(Skript.SKRIPT_PREFIX + "SimpleScoreboard Score cannot below 0");
				return;
			}
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "SimpleScoreboard Score cannot above 15");
			return;
		}
	}

	public static String colorString(String s)
	{
		return ChatColor.translateAlternateColorCodes('&', s);
	}

	public static void setScore(String scoreboardName, Integer slot, String value){
		Scoreboard targetBoard = SimpleScoreboards.get(scoreboardName);
		if (slot <= 15){
			if (slot > 0){
				//Bukkit.broadcastMessage("Score to Reset: " + null);
				HashMap<Integer, String> hashMap = ScoreboardTracker.get(targetBoard);
				if (hashMap.get(slot).toString() != value.toString()){
					if (hashMap.containsKey(slot)) {
						String score2reset = hashMap.get(slot);
						//Bukkit.broadcastMessage("Score to Reset: " + score2reset);
						targetBoard.resetScores(score2reset);
						hashMap.remove(slot);
					}
					hashMap.put(slot, value);
					ScoreboardTracker.put(targetBoard, hashMap);
					targetBoard.getObjective("SimpleScoreboard").getScore(value).setScore(slot);
				}

			}
			else{
				Skript.error(Skript.SKRIPT_PREFIX + "SimpleScoreboard Score cannot below 0");
				return;
			}
		}
		else{
			Skript.error(Skript.SKRIPT_PREFIX + "SimpleScoreboard Score cannot above 15");
			return;
		}
	}
}

