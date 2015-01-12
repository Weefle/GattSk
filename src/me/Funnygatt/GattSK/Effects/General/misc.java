package me.Funnygatt.GattSK.Effects.General;

import net.minecraft.server.v1_8_R1.EntityInsentient;
import net.minecraft.server.v1_8_R1.GenericAttributes;
import net.skquery.api.annotation.LookThrough;
import net.skquery.api.annotation.ToSkript;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Entity;
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

	@ToSkript("set knockback resistance of %entities% to %integer%")
	public static void setKnockbackResistance(Entity[] entities, Integer integer){
		for (Entity e : entities){
			EntityInsentient nmsEntity = (EntityInsentient) ((CraftLivingEntity) e).getHandle();
			nmsEntity.getAttributeInstance(GenericAttributes.c).setValue(integer.doubleValue());
		}
	}
	@ToSkript("set attack damage of %entities% to %integer%")
	public static void setAttackDamage(Entity[] entities, Integer integer){
		for (Entity e : entities){
			EntityInsentient nmsEntity = (EntityInsentient) ((CraftLivingEntity) e).getHandle();
			nmsEntity.getAttributeInstance(GenericAttributes.e).setValue(integer.doubleValue());
		}
	}

	@ToSkript("set movement speed of %entities% to %integer%")
	public static void setMovementSpeed(Entity[] entities, Integer integer){
		for (Entity e : entities){
			EntityInsentient nmsEntity = (EntityInsentient) ((CraftLivingEntity) e).getHandle();
			nmsEntity.getAttributeInstance(GenericAttributes.d).setValue(integer.doubleValue());
		}
	}

	@ToSkript("set follow range of %entities% to %integer%")
	public static void setFollowRange(Entity[] entities, Integer integer){
		for (Entity e : entities){
			EntityInsentient nmsEntity = (EntityInsentient) ((CraftLivingEntity) e).getHandle();
			nmsEntity.getAttributeInstance(GenericAttributes.b).setValue(integer.doubleValue());
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
