package me.Funnygatt.GattSK.Expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Collect;
import me.Funnygatt.GattSK.Managers.WorldManagers;
import org.bukkit.World;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 11/14/2014.
 */
public class ExprLastCreatedWorld extends SimpleExpression<World> {

	@Override
	public Class<? extends World> getReturnType() {

		return World.class;
	}

	@Override
	public boolean isSingle() {
		// TODO Auto-generated method stub
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2,
						SkriptParser.ParseResult arg3) {
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return "get objective";
	}

	@Override
	@javax.annotation.Nullable
	protected World[] get(Event arg0) {
		return Collect.asArray(WorldManagers.lastCreatedWorld);
	}
}
