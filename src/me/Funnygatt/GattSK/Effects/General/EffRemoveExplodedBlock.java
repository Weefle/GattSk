package me.Funnygatt.GattSK.Effects.General;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityExplodeEvent;

/**
 * Created by Zachary on 12/23/2014.
 */
public class EffRemoveExplodedBlock extends Effect {
	private Expression<Block> block;
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int i, Kleenean kleenean, SkriptParser.ParseResult parse) {
		this.block  = (Expression<Block>) exprs[0];

		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "load chunk";
	}
	@Override
	protected void execute(Event event) {
		Block[] blocks = this.block.getAll(event);


		for (Block bl : blocks) {

			((EntityExplodeEvent)event).blockList().remove(bl);
		}
	}
}
