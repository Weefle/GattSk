package me.Funnygatt.GattSK.Expressions;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.Skript;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Collect;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Zachary on 11/21/2014.
 */
public class ExprClickedItemLore extends SimpleExpression<String> {
	protected String[] get(Event event)
	{
		return Collect.asArray(((InventoryClickEvent)event).getCurrentItem().getItemMeta().getLore().toString());
	}

	public boolean isSingle()
	{
		return true;
	}

	public Class<? extends String> getReturnType()
	{
		return String.class;
	}

	public String toString(Event event, boolean b)
	{
		return "clicked item";
	}

	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	{
		if (!ScriptLoader.isCurrentEvent(InventoryClickEvent.class))
		{
			Skript.error("Clicked Item Name can only be used in an inventory click event.");
			return false;
		}
		return true;
	}
}
