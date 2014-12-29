package me.Funnygatt.GattSK;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.ExpressionType;
import me.Funnygatt.GattSK.BungeeCord.BCEffConnect;
import me.Funnygatt.GattSK.Effects.Scoreboard.*;
import me.Funnygatt.GattSK.Effects.World.*;
import me.Funnygatt.GattSK.Expressions.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;

public class Main extends JavaPlugin implements Listener{
	
	public static PluginManager pm;
	public static Plugin plugin;
	
	public void onEnable(){
		pm = Bukkit.getPluginManager();
		plugin = this;
		Skript.registerAddon(this);

		//Scoreboards

		Skript.registerEffect(EffNewScoreboard.class, "create [a] new scoreboard %string%");
		Skript.registerEffect(EffSetPlayerScoreboard.class, "set scoreboard of %players% to %string%");
		Skript.registerEffect(EffSetScore.class, "set value of score %string% (for|in) [score][board] %string% objective %string% to %number%");
		Skript.registerEffect(EffResetScore.class, "reset [value] [of] score %string% (for|in) [score][board] %string%");
		Skript.registerEffect(EffNewObjective.class, "create [a] [new] %string% objective for [score][board] %string% (called|named) %string%");
		Skript.registerEffect(EffSetObjectiveDisplay.class, "set objective display slot for [objective] %string% in [score][board] %string% to %string%");
		Skript.registerEffect(EffSetObjectiveName.class, "set objective display name for [objective] %string% in [score][board] %string% to %string%");

		Skript.registerExpression(ExprGetScore.class, Integer.class, ExpressionType.PROPERTY, new String[] {"value [of] %string% objective %string% for [score] %string%"});
		//Skript.registerExpression(ExprGetPlayerScoreboard.class, Scoreboard.class, ExpressionType.PROPERTY, new String[] {"scoreboard of %player%"});
		Skript.registerExpression(ExprGetObjectiveType.class, String.class, ExpressionType.PROPERTY, new String[] {"objective type of %string% (from|in) [score][board] %scoreboard%"});
		Skript.registerExpression(ExprGetObjectiveDisplay.class, Objective.class, ExpressionType.PROPERTY, new String[] {"objective in [[display]slot] %displayslot% from [score][board] %string%"});
		Skript.registerExpression(ExprGetObjective.class, String.class, ExpressionType.PROPERTY, new String[] {"objective %string% from [score][board] %string%"});


		//World Manager

		Skript.registerEffect(EffCreateWorld.class, "create [a] new world [name[d]] %string%");
		Skript.registerEffect(EffDeleteWorld.class, "delete world %string%");
		Skript.registerEffect(EffUnloadWorld.class, "unload world %string%");
		Skript.registerEffect(EffLoadWorld.class, "load world %string%");
		Skript.registerEffect(EffCreateWorldFrom.class, "create world named %string% from [folder] %string%");

		Skript.registerExpression(ExprLastCreatedWorld.class, World.class, ExpressionType.PROPERTY, new String[]{"last created world"});

		Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
		//Bukkit.getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", this);

		//EnumClassInfo.create(ScoreboardTypes.class, "ScoreboardTypes").register();
		//EnumClassInfo.create(ScoreboardDisplaySlots.class, "displayslots").register();
		//EnumClassInfo.create(DisplaySlot.class, "displayslot").register();

		Skript.registerEffect(BCEffConnect.class, "connect %players% to %string%");

	}

}
