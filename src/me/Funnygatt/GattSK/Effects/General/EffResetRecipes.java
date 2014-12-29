package me.Funnygatt.GattSK.Effects.General;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 11/28/2014.
 */
public class EffResetRecipes extends Effect {


	@Override
	public boolean init(Expression<?>[] exprs, int i, Kleenean kleenean,
						SkriptParser.ParseResult parse) {

		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event e, boolean b) {

		return "reset [all] [server] recipes";

		// TODO Auto-generated method stub
	}

	@Override
	protected void execute(Event e) {

		Bukkit.resetRecipes();
		// TODO Auto-generated method stub

	}

}

