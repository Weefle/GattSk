package me.Funnygatt.GattSK.Expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Collect;
import me.Funnygatt.GattSK.Managers.ScoreboardManagers;
import org.bukkit.event.Event;

public class ExprGetScore extends SimpleExpression<Integer>{

	private Expression<String> boardname;
	private Expression<String> objective;
	private Expression<String> score;
	
	@Override
	public Class<? extends Integer> getReturnType() {
		
		return Integer.class;
	}

	@Override
	public boolean isSingle() {
		// TODO Auto-generated method stub
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2,
			ParseResult arg3) {
		this.boardname = (Expression<String>) args[0];
		this.objective = (Expression<String>) args[1];
		this.score = (Expression<String>) args[2];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return "get score";
	}

	@Override
	@javax.annotation.Nullable
	protected Integer[] get(Event arg0) {

		String board = this.boardname.getSingle(arg0);
		String obj = this.objective.getSingle(arg0);
		String scoretofind = this.score.getSingle(arg0);
		
		if (board == null | obj == null | scoretofind == null){
			return null;
		}
		
		Integer score = ScoreboardManagers.getScore(board, obj, scoretofind);
		
		return Collect.asArray(score);
	}

}
