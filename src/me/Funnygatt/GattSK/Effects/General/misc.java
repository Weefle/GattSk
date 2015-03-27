package me.Funnygatt.GattSK.Effects.General;

import ch.njol.skript.Skript;
import net.skquery.api.annotation.LookThrough;
import net.skquery.api.annotation.ToSkript;
import org.bukkit.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.Plugin;

/**
 * Created by Zachary on 1/12/2015.
 */
@LookThrough
public class misc {

	/*@ToSkript("(remove|delete) %block% from [better][ ][new] exploded blocks")
	public static void removeBlockFromExplodedBlocks(Block[] block){
		for (Block b : block){
			Object event = new EntityExplodeEvent(null, block[0].getLocation(), null, 1);
			((EntityExplodeEvent)event).blockList().remove(block);
		}
	}*/

	//TODO: Convert to SkQueryAPI once w00t tells me how to do this >.>

	@ToSkript("(generate|create) [new] world [named] %name% using [generator] %generator%")
	public static void createWorldUsingGenerator(String name, String generator){
		if (!worldExists(name)){
			WorldCreator c = new WorldCreator(name);
			c.generator(getGenerator(generator, name));
			World world = c.createWorld();
		}
	}
	public static boolean worldExists(String name){
		if (Bukkit.getWorld(name) != null){
			return true;
		}
		else{
			return false;
		}
	}
	static ChunkGenerator getGenerator(String generator, String name)
	{
		if(generator == null)
		{
			return null;
		}
		Plugin generatorPlugin = Bukkit.getPluginManager().getPlugin(generator);
		if(generatorPlugin == null)
		{
			return null;
		}
		return generatorPlugin.getDefaultWorldGenerator(name, null);
	}

	@ToSkript("spawn reason (of|for) %entity%")
	public static String spawnReason(Entity entity) {
		if (entity.hasMetadata("spawnreason"))
			return entity.getMetadata("spawnreason").get(0).asString();
		else{
			return "<none>";
		}
	}

	@ToSkript("update inventory of %player%")
	public static void updateInventory(Player[] players){
		for (Player p : players){
			p.updateInventory();
		}
	}

	@ToSkript("reset all server recipes")
	public static void resetRecipes(){
		Bukkit.resetRecipes();
	}

	@ToSkript("spawn %integer% of particle %effect%[:%speed%] at %location% [offset by %offsetx%, %offsety% (and|,) %offsetz%] [with data %data%]")
	public static void spawnParticle(Integer count, String effect, Number speed, Location[] locations, Number offsetx, Number offsety, Number offsetz, Integer data){
		Effect eff = null;
		for (Effect effCheck : Effect.values()){
			//Bukkit.broadcastMessage(effCheck.name() + " CHECKING AGAINST " + string);
			if (effCheck.name().equalsIgnoreCase(effect)){
				eff = effCheck;
			}
		}
		if (eff == null){
			Skript.error("Unknown Effect! " + effect + " isn't a valid effect!");
			return;
		}
		for (Location location : locations) {
			//location.getWorld().playEffect(location, eff, integer);
			if (data == null) {
				location.getWorld().spigot().playEffect(location, eff);
			} else {
				location.getWorld().spigot().playEffect(location, eff, data, 0, offsetx.floatValue(), offsety.floatValue(), offsetz.floatValue(), speed.floatValue(), count, 500);
			}
		}
	}

	@ToSkript("(summon|play|create|activate|spawn) effect %string% at %locations%[[ with] data %id% [and %data%]]")
	public static void playEffect(String string, Location[] locations, Integer id, Integer data){
		//PlayEffect.PlayEffect(locations, effectType, data);
		Effect eff = null;
		for (Effect effCheck : Effect.values()){
			//Bukkit.broadcastMessage(effCheck.name() + " CHECKING AGAINST " + string);
			if (effCheck.name().equalsIgnoreCase(string)){
				eff = effCheck;
			}
		}
		if (eff == null){
			Skript.error("Unknown Effect! " + string  + " isn't a valid effect!");
			return;
		}
		for (Location location : locations) {
			//location.getWorld().playEffect(location, eff, integer);
			if (data == null) {
				location.getWorld().spigot().playEffect(location, eff);
			}
			else{
				if (id != null) {
					location.getWorld().spigot().playEffect(location, eff, id, data, 1, 1, 1, 1, 1, 50);
				}
				else{
					location.getWorld().spigot().playEffect(location, eff, id, 0, 1, 1, 1, 1, 1, 50);
				}
			}
		}
	}
	@ToSkript("(summon|play|create|activate|spawn) %count% of effect %string% at %locations% to %players%[[ with] data %integer% [and %integer%]]")
	public static void playEffect(Integer count, String string, Location[] locations, Player[] players, Integer integer1, Integer integer2){
		//PlayEffect.PlayEffect(locations, effectType, data);
		Effect eff = null;
		for (Effect effCheck : Effect.values()){
			if (effCheck.name() == string){
				eff = effCheck;
			}
		}
		if (eff == null){
			Skript.error("Unknown Effect! " + string  + " isn't a valid effect!");
		}
		for (Player p : players){
			for (Location location : locations) {
				if (integer1 == null) {
					p.spigot().playEffect(location, eff, 0, 0, 1, 1, 1, 1, count, 50);
				}
				else{
					if (integer2 != null) {
						p.spigot().playEffect(location, eff, integer1, integer2, 1, 1, 1, 1, count, 50);
					}
					else{
						p.spigot().playEffect(location, eff, integer1, 0, 1, 1, 1, 1, count, 50);
					}
				}
			}
		}
	}
}

