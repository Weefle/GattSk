package me.Funnygatt.GattSK.Effects.General;

import ch.njol.skript.Skript;
import me.Funnygatt.GattSK.Main;
import net.skquery.api.annotation.LookThrough;
import net.skquery.api.annotation.ToSkript;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityExplodeEvent;

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

	@ToSkript("geeky is love")
	public static void geekyLove(){
		Bukkit.getScheduler().runTaskTimer(Main.plugin, new Runnable() {
			@Override
			public void run() {
				for (Player p : Bukkit.getOnlinePlayers()){
					p.getWorld().createExplosion(p.getLocation(), 0);
					Entity widda = p.getWorld().spawnEntity(p.getLocation(), EntityType.WITHER);
					widda.setCustomName(ChatColor.RED + "widda man 2000");
					widda.remove();
				}
			}
		}, 5L, 5L);
	}

	//TODO: Convert to SkQueryAPI once w00t tells me how to do this >.>

	@ToSkript("spawn reason (of|for) %entity%")
	public static String spawnReason(Entity entity) {
		if (entity.hasMetadata("spawnreason"))
			return entity.getMetadata("spawnreason").toString();
		else{
			Skript.error("Couldn't get Spawn Reason for " + entity + ". Entity could've been spawned before GattSk was updated!!!");
			return "<none>";
		}
	}

	@ToSkript("set custom name of %entities% to %name%")
	public static void setEntityHandle(Entity[] entities, String name){
		for (Entity e : entities){
			e.setCustomName(name);
			e.setCustomNameVisible(true);
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

	@ToSkript("(summon|play|create|activate|spawn) effect %effectType% at %locations%[[ with] data %data%]")
	public static void playEffect(String effectType, Location[] locations,  Integer data){
		//PlayEffect.PlayEffect(locations, effectType, data);
		for (Location location : locations) {
			location.getWorld().playEffect(location, Effect.valueOf(effectType), data);
		}
	}
	@ToSkript("(summon|play|create|activate|spawn) effect %effectType% at %locations% to %players% [[ with] data %data%]")
	public static void playEffectToPlayer(String effectType, Location[] locations, Player[] players, Integer data){
		//PlayEffect.PlayEffect(locations, effectType, data);
		for (Player p : players){
			for (Location location : locations) {
				p.playEffect(location, Effect.valueOf(effectType), data);
			}
		}
	}
}
