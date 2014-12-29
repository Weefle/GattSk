package me.Funnygatt.GattSK.Effects.Scoreboard.SimpleScoreboards;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.SimpleScoreboard;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public class EffShowSimpleBoard extends Effect{
	private Expression<Player> players;
	private Expression<String> boardname;
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] args, int arg1, Kleenean arg2,
			ParseResult arg3) {
		
		this.players = (Expression<Player>) args[0];
		this.boardname = (Expression<String>) args[1];
		
		return true;
	}

	@Override
	public String toString(@javax.annotation.Nullable Event arg0, boolean arg1) {
		return "SIMPLESCOREBOARD set player scoreboard";
	}

	@Override
	protected void execute(Event arg0) {
		Player[] players = this.players.getAll(arg0);
		String boardname = this.boardname.getSingle(arg0);
		if (players == null | boardname == null){
			return;
		}
		for (Player p : players){
			SimpleScoreboard.showSimpleBoard(p, boardname);
		}
	}

}
