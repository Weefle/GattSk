package me.Funnygatt.GattSK.Utilities;

import org.bukkit.SkullType;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;

/**
 * Created by Zachary on 11/23/2014.
 */
public class SkullDisplay {
	public static void setSkull(Block b, String name) {
		Skull skull = (Skull)b.getState();
		skull.setSkullType(SkullType.PLAYER);
		skull.setOwner(name);
		skull.update();
	}
	public static String getSkull(Block b) {
		Skull skull = (Skull)b.getState();
		skull.setSkullType(SkullType.PLAYER);
		return skull.getOwner();
	}
}
