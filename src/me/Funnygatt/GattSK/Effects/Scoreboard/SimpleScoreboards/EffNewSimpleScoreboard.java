package me.Funnygatt.GattSK.Effects.Scoreboard.SimpleScoreboards;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.SimpleScoreboard;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 12/25/2014.
 */
public class EffNewSimpleScoreboard extends Effect {
	private Expression<String> scoreboardName;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2,
						SkriptParser.ParseResult arg3) {

		this.scoreboardName = (Expression<String>) args[0];

		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "SIMPLESCOREBOARD new scoreboard";
	}

	@Override
	protected void execute(Event arg0) {

		String board = this.scoreboardName.getSingle(arg0);
		if (board == null){
			return;
		}
		SimpleScoreboard.newSimpleScoreboard(board);
	}
}
