package me.Funnygatt.GattSK;

import ch.njol.skript.Skript;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.skript.lang.ExpressionType;
import me.Funnygatt.GattSK.Effects.General.*;
import me.Funnygatt.GattSK.Effects.Scoreboard.*;
import me.Funnygatt.GattSK.Effects.Scoreboard.SimpleScoreboards.*;
import me.Funnygatt.GattSK.Effects.Scoreboard.Teams.*;
import me.Funnygatt.GattSK.Effects.World.EffCreateWorldFrom;
import me.Funnygatt.GattSK.Expressions.*;
import me.Funnygatt.GattSK.Expressions.ServerProperties.ExprMaxPlayers;
import me.Funnygatt.GattSK.Utilities.CustomYML;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;

public class Main extends JavaPlugin implements Listener{
	
	public static PluginManager pm;
	public static Plugin plugin;
	public static CustomYML customYML;
	
	public void onEnable(){
		pm = Bukkit.getPluginManager();
		plugin = this;
		Skript.registerAddon(this);

		WorldLoader wl = new WorldLoader();
		wl.createWorldList();

		//General

		Skript.registerEffect(EffResetRecipes.class, "reset [all] [server] recipes");

		Skript.registerEffect(EffGenerateChunk.class, "generate chunk at %location%");
		Skript.registerEffect(EffLoadChunk.class, "load chunk at %location%");
		Skript.registerEffect(EffUnloadChunk.class, "unload chunk at %location%");
		Skript.registerEffect(EffSummonEffect.class, "(summon|play|create|activate|spawn) effect %string% at %locations%[[ with] data %integer%]");
		Skript.registerEffect(EffUpdateInventory.class, "update %player% inventory");
		Skript.registerEffect(EffRemoveExplodedBlock.class, "(remove|delete) %block% from [better][ ][new] exploded blocks");

		//Scoreboards

		Skript.registerEffect(EffNewScoreboard.class, "create [a] new scoreboard [named] %string%");
		Skript.registerEffect(EffSetPlayerScoreboard.class, "set scoreboard of %players% to %string%");
		Skript.registerEffect(EffSetScore.class, "set value of score %string% (for|in) [score][board] %string% objective %string% to %number%");
		Skript.registerEffect(EffResetScore.class, "reset [value] [of] score %string% (for|in) [score][board] %string%");
		Skript.registerEffect(EffNewObjective.class, "create [a] [new] %string% objective for [score][board] %string% (called|named) %string%");
		Skript.registerEffect(EffSetObjectiveDisplay.class, "set objective display slot for [objective] %string% in [score][board] %string% to %string%");
		Skript.registerEffect(EffSetObjectiveName.class, "set objective display name for [objective] %string% in [score][board] %string% to %string%");
		Skript.registerEffect(EffUnregisterObjective.class, "unregister objective %string% in [score][board] %string%");

		Skript.registerEffect(EffCreateTeam.class, "create team %string% in [score][board] %string%");
		Skript.registerEffect(EffTeamPlayer.class, "(0¦remove|1¦add) [player] %offlineplayer% (from|to) team %string% in [score][board] %string%");

		Skript.registerEffect(EffSetTeamPrefix.class, "set (0¦suffix|1¦prefix) for team %string% in [score][board] %string% to %string%");
		Skript.registerEffect(EffSetTeamFF.class, "set friendly fire for team %string% in [score][board] %string% to %boolean%");
		Skript.registerEffect(EffSetTeamSeeInvis.class, "set see friendly invisibles for team %string% in [score][board] %string% to %boolean%");

		Skript.registerExpression(ExprGetScore.class, Integer.class, ExpressionType.PROPERTY, new String[] {"value [of] %string% objective %string% for [score] %string%"});
		//Skript.registerExpression(ExprGetPlayerScoreboard.class, Scoreboard.class, ExpressionType.PROPERTY, new String[] {"scoreboard of %player%"});
		Skript.registerExpression(ExprGetObjectiveType.class, String.class, ExpressionType.PROPERTY, new String[] {"objective type of %string% (from|in) [score][board] %scoreboard%"});
		Skript.registerExpression(ExprGetObjectiveDisplay.class, Objective.class, ExpressionType.PROPERTY, new String[] {"objective in [[display]slot] %displayslot% from [score][board] %string%"});
		Skript.registerExpression(ExprGetObjective.class, String.class, ExpressionType.PROPERTY, new String[] {"objective %string% from [score][board] %string%"});

		// Simple Scoreboards
		Skript.registerEffect(EffNewSimpleScoreboard.class, "create [a] new simple scoreboard [named] %string%");
		Skript.registerEffect(EffDebug.class, "debug simple %string%");
		Skript.registerEffect(EffShowSimpleBoard.class, "set simple [score][ ][board] of %players% to %string%");
		Skript.registerEffect(EffSetSimpleScore.class, "set (slot|value|score) %integer% of simple [score][ ][board] %string% to %string%");
		Skript.registerEffect(EffSetSimpleScore.class, "(clear|delete) (slot|value|score) %integer% of simple [score][ ][board] %string%");
		Skript.registerEffect(EffSimpleDisplayName.class, "set display title for simple [score][board] %string% to %string%");

		//World Manager

		Skript.registerEffect(EffCreateWorld.class, "create [a] new world [name[d]] %string%");
		Skript.registerEffect(EffDeleteWorld.class, "delete world %string%");
		Skript.registerEffect(EffUnloadWorld.class, "unload world %string%");
		Skript.registerEffect(EffLoadWorld.class, "load world %string%");
		Skript.registerEffect(EffCreateWorldFrom.class, "create world named %string% from [folder] %string%");

		Skript.registerExpression(ExprLastCreatedWorld.class, World.class, ExpressionType.PROPERTY, new String[]{"last created world"});

		//Bukkit.getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", this);

		//EnumClassInfo.create(ScoreboardTypes.class, "ScoreboardTypes").register();
		//EnumClassInfo.create(ScoreboardDisplaySlots.class, "displayslots").register();
		//EnumClassInfo.create(DisplaySlot.class, "displayslot").register();

		Skript.registerExpression(ExprClickedItem.class, ItemStack.class, ExpressionType.PROPERTY, new String[]{"clicked item"});
		Skript.registerExpression(ExprCursorItem.class, ItemStack.class, ExpressionType.PROPERTY, new String[]{"cursor item"});
		Skript.registerExpression(ExprClickedSlot.class, Integer.class, ExpressionType.PROPERTY, new String[]{"clicked slot"});
		Skript.registerExpression(ExprClickType.class, String.class, ExpressionType.PROPERTY, new String[]{"click type"});
		Skript.registerExpression(ExprClickedItemName.class, String.class, ExpressionType.PROPERTY, new String[]{"clicked item name"});
		Skript.registerExpression(ExprClickedItemLore.class, String.class, ExpressionType.PROPERTY, new String[]{"clicked item lore"});

		SimplePropertyExpression.register(ExprSkullDisplay.class, String.class, "skull owner", "block");


		//Bukkit Server Properties
		Skript.registerExpression(ExprMaxPlayers.class, Integer.class, ExpressionType.SIMPLE, new String[]{"max players"});

	}

}
