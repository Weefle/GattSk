package me.Funnygatt.GattSK.Effects.Scoreboard.SimpleScoreboards;

import me.Funnygatt.GattSK.SimpleScoreboard;
import net.skquery.api.annotation.LookThrough;
import net.skquery.api.annotation.ToSkript;
import org.bukkit.entity.Player;

/**
 * Created by Zachary on 1/12/2015.
 */
@LookThrough
public class simpleScoreboardsMain {

//	Skript.registerEffect(EffNewSimpleScoreboard.class, "create [a] new simple scoreboard [named] %string%");
//	Skript.registerEffect(EffDebug.class, "debug simple %string%");
//	Skript.registerEffect(EffShowSimpleBoard.class, "set simple [score][ ][board] of %players% to %string%");
//	Skript.registerEffect(EffSetSimpleScore.class, "set (slot|value|score) %integer% of simple [score][ ][board] %string% to %string%");
//	Skript.registerEffect(EffSetSimpleScore.class, "(clear|delete) (slot|value|score) %integer% of simple [score][ ][board] %string%");
//	Skript.registerEffect(EffSimpleDisplayName.class, "set display title for simple [score][board] %string% to %string%");

	@ToSkript("create [a] new simple scoreboard [named] %name%")
	public static void newSimpleScoreboard(String name){
		SimpleScoreboard.newSimpleScoreboard(name);
	}
	@ToSkript("debug simple %name%")
	public static void debugSimpleScoreboard(String name){
		SimpleScoreboard.debug(name);
	}

	@ToSkript("set simple [score][ ][board] of %players% to %name%")
	public static void setPlayerBoard(Player[] players, String name){
		for (Player p : players){
			SimpleScoreboard.showSimpleBoard(p, name);
		}
	}

	@ToSkript("set (slot|value|score) %slot% of simple [score][ ][board] %name% to %value%")
	public static void setSimpleSlot(Integer slot, String name, String value){
		SimpleScoreboard.setScore(name, slot, value);
	}

	@ToSkript("(clear|delete) (slot|value|score) %slot% of simple [score][ ][board] %name%")
	public static void clearSimpleSlot(Integer slot, String name){
		SimpleScoreboard.clearScore(name, slot);
	}

	@ToSkript("set display title for simple [score][board] %name% to %string%")
	public static void setSimpleDisplayTitle(String name, String string){
		SimpleScoreboard.setScoreboardTitle(name, string);
	}
}
