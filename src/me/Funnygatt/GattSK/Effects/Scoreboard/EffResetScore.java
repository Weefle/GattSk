package me.Funnygatt.GattSK.Effects.Scoreboard;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Managers.ScoreboardManagers;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

/**
 * Created by Zachary on 11/17/2014.
 */
public class EffResetScore extends Effect {

	private Expression<String> boardName;
	private Expression<String> objectiveName;
	private Expression<String> scoreName;
	private Expression<Number> score;

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2,
						SkriptParser.ParseResult arg3) {
		this.boardName = (Expression<String>) args[1];
		this.scoreName = (Expression<String>) args[0];
		return true;
	}

	@Override
	public String toString(@Nullable Event arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return "set scoreboard score";
	}

	@Override
	protected void execute(Event arg0) {
		String board = this.boardName.getSingle(arg0);
		String namescore = this.scoreName.getSingle(arg0);

		if (board == null | namescore == null) {
			return;
		}

		ScoreboardManagers.deleteScore(board, namescore);

	}
}