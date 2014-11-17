package me.Funnygatt.GattSK.Expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Collect;
import me.Funnygatt.GattSK.Managers.ScoreboardManagers;
import org.bukkit.event.Event;

public class ExprGetObjective extends SimpleExpression<String>{
	
	private Expression<String> objective;
	private Expression<String> board;
	
	@Override
	public Class<? extends String> getReturnType() {
		
		return String.class;
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
		this.objective = (Expression<String>) args[0];
		this.board = (Expression<String>) args[1];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return "get objective";
	}

	@Override
	@javax.annotation.Nullable
	protected String[] get(Event arg0) {

		String obj = this.objective.getSingle(arg0);
		String board = this.board.getSingle(arg0);
		if (obj == null | board == null){
			return null;
		}
		return Collect.asArray(ScoreboardManagers.getObjective(board, obj));
	}
}
