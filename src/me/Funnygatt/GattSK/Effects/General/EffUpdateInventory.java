package me.Funnygatt.GattSK.Effects.General;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;

public class EffUpdateInventory extends Effect {
	private Expression <Player>player;

	
	@SuppressWarnings("unchecked")
	@Override
	public boolean init(Expression<?>[] exprs, int i, Kleenean kleenean,
			ParseResult parse) {
		player  = (Expression<Player>) exprs[0];
		
		return true;
	}

	@Override
	public String toString(Event e, boolean b) {
		
		return "update " + player.toString(e, b) + " inventory";
		
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute(Event e) {
		
		Player p = player.getSingle(e);

		Block b = p.getTargetBlock(null, 4);

		Inventory inv = ((Chest)b).getBlockInventory();
		
		p.updateInventory();;
		
	}

}
