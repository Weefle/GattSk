package me.Funnygatt.GattSK.Expressions.ServerProperties;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 12/1/2014.
 */
public class ExprMaxPlayers extends SimpleExpression<Integer>{
	protected Integer[] get(Event event){
		return new Integer[] { Integer.valueOf(Bukkit.getMaxPlayers()) };
	}
	public boolean isSingle(){
		return true;
	}
	public Class<? extends Integer> getReturnType(){
		return Integer.class;
	}
	public String toString(Event event, boolean b){
		return "max player";
	}

	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult){
		return true;
	}
}
