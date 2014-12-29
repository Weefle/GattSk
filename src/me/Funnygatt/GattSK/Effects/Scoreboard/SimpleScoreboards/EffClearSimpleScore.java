package me.Funnygatt.GattSK.Effects.Scoreboard.SimpleScoreboards;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.SimpleScoreboard;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class EffClearSimpleScore extends Effect{
	
	private Expression<String> boardName;
	private Expression<Number> slot;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2,
			ParseResult arg3) {
		this.boardName = (Expression<String>) args[1];
		this.slot = (Expression<Number>) args[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return "SIMPLESCOREBOARD set scoreboard score";
	}

	@Override
	protected void execute(Event arg0) {
		String board = this.boardName.getSingle(arg0);
		Number score = this.slot.getSingle(arg0);
		
		if (board == null | score == null) {
			return;
		}
		SimpleScoreboard.clearScore(board, score.intValue());
		
	}

}
