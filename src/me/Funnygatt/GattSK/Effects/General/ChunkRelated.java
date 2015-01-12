package me.Funnygatt.GattSK.Effects.General;

import net.skquery.api.annotation.LookThrough;
import net.skquery.api.annotation.ToSkript;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * Created by Zachary on 1/12/2015.
 */
@LookThrough
public class ChunkRelated {

	@ToSkript("generate chunk at %location%")
	public static void generateChunk(Location[] location){
		for (Location loc : location) {
			Chunk chunk = loc.getChunk();
			int zLoc = chunk.getZ();
			int xLoc = chunk.getX();
			World world = loc.getWorld();
			world.loadChunk(xLoc, zLoc, true);
		}
	}

	@ToSkript("load chunk at %location%")
	public static void loadChunk(Location[] location){
		for (Location loc : location) {
			Chunk chunk = loc.getChunk();
			int zLoc = chunk.getZ();
			int xLoc = chunk.getX();
			World world = loc.getWorld();
			world.loadChunk(xLoc, zLoc);
		}
	}
	@ToSkript("unload chunk at %location%")
	public static void unloadChunk(Location[] location){
		for (Location loc : location) {
			Chunk chunk = loc.getChunk();
			int zLoc = chunk.getZ();
			int xLoc = chunk.getX();
			World world = loc.getWorld();
			world.unloadChunkRequest(xLoc, zLoc, true);
		}
	}
}
