package me.Funnygatt.GattSK.Utilities;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class PlayEffect {
	public static void PlayEffect(Location[] l, String pe, int data) {
		for (Location fl : l) {
			World world = fl.getWorld();
			Effect effect = Effect.valueOf(pe);
			//PlayEffect ply = pe;
			world.playEffect(fl, effect, data);
		}
		
	}

	public static void PlayEffectToPlayer(Location[] l, String s, int data,
			Player plyr) {
		Player player = plyr.getPlayer();
		for (Location fl : l) {
			Effect effect = Effect.valueOf(s);
			//PlayEffect ply = pe;
			plyr.playEffect(fl, effect, data);

		
		}
		
	}
}
