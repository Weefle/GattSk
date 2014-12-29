package me.Funnygatt.GattSK.Effects.General;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 8/4/2014.
 */
public class EffLoadChunk extends Effect{

	private Expression<Location> loc;
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int i, Kleenean kleenean, SkriptParser.ParseResult parse) {
		this.loc  = (Expression<Location>) exprs[0];

		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "load chunk";
	}
	@Override
	protected void execute(Event event) {
		Location locmain[] = loc.getAll(event);
		for (Location location : locmain) {
			Chunk chunk = location.getChunk();
			int zLoc = chunk.getZ();
			int xLoc = chunk.getX();
			World world = location.getWorld();
			world.loadChunk(xLoc, zLoc);
		}
	}


}
