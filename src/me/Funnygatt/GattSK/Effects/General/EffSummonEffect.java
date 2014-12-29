package me.Funnygatt.GattSK.Effects.General;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Utilities.PlayEffect;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EffSummonEffect extends Effect implements Listener {
	
	private Expression<String> effectname;
	private Expression <Location>location;
	private Expression <Number>data;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int i, Kleenean kleenean,
			ParseResult parse) {
		this.effectname  = (Expression<String>) exprs[0];
		this.location  = (Expression<Location>) exprs[1];
		this.data  = (Expression<Number>) exprs[2];
		
		return true;
	}

	@Override
	public String toString(Event e, boolean b) {
		return "(summon|play|create|activate) effect " + this.effectname.toString() + " at " + this.location.toString(e, b) + " [with] data " + this.data.toString(e, b);
	}

	@Override
	@EventHandler
	protected void execute(Event e){
		
		String s = this.effectname.getSingle(e);
		//PlayEffect pe = this.effectname.getSingle(e);
		Location[] l = this.location.getAll(e);
		int data = (Integer) this.data.getSingle(e);
		for (Location fl : l) {
			PlayEffect.PlayEffect(l, s, data);
		}
	}
}
