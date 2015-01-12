package me.Funnygatt.GattSK.Effects.General;

import net.skquery.api.annotation.LookThrough;
import net.skquery.api.annotation.ToSkript;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by Zachary on 1/12/2015.
 */
@LookThrough
public class misc {

//	@ToSkript("(remove|delete) %block% from [better][ ][new] exploded blocks")
//	public static void removeBlockFromExplodedBlocks(Block[] block){
//		for (Block b : block){
//			(, (EntityExplodeEvent) ).blockList().remove(b);
//		}
//	}
	//TODO: Convert to SkQueryAPI once w00t tells me how to do this >.>

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
