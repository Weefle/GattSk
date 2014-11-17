package me.Funnygatt.GattSK.Expressions;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Collect;
import me.Funnygatt.GattSK.Managers.ScoreboardManagers;
import org.bukkit.event.Event;
import org.bukkit.scoreboard.Objective;

public class ExprGetObjectiveDisplay extends SimpleExpression<Objective>{

	
	private Expression<String> slot;
	private Expression<String> board;
	
	@Override
	public Class<? extends Objective> getReturnType() {
		
		return Objective.class;
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
		this.slot = (Expression<String>) args[0];
		this.board = (Expression<String>) args[1];
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		// TODO Auto-generated method stub
		return "get objective display sot";
	}

	@Override
	@javax.annotation.Nullable
	protected Objective[] get(Event arg0) {

		String slot = this.slot.getSingle(arg0);
		String board = this.board.getSingle(arg0);
		if (slot == null | board == null){
			return null;
		}
		return Collect.asArray(ScoreboardManagers.getObjectiveDisplay(board, slot));
	}

}
