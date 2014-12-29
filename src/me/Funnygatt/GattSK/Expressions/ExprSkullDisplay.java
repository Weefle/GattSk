package me.Funnygatt.GattSK.Expressions;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import me.Funnygatt.GattSK.Utilities.SkullDisplay;
import org.bukkit.block.Block;
import org.bukkit.event.Event;

/**
 * Created by Zachary on 11/23/2014.
 */
public class ExprSkullDisplay extends SimplePropertyExpression<Block, String> {

	@Override
	public String convert(Block arg0) {
		return SkullDisplay.getSkull(arg0);
	}

	@Override
	public void change(Event e, Object[] delta, Changer.ChangeMode mode) {
		Block[] b = getExpr().getAll(e); //Called to get the Target which is Player in this case.
		for (Block block : b) {
			if (b == null)
				return;
			String h = (String) (delta[0]);
			if (mode == Changer.ChangeMode.SET) {
				SkullDisplay.setSkull(block, h);
			}
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public Class<?>[] acceptChange(final Changer.ChangeMode mode) {
		if (mode == Changer.ChangeMode.SET) //SET can be replaced with REMOVE ADD or similiar stuff.
			return CollectionUtils.array(String.class); //The Class should be the TypeToGet and in this case Number.
		if (mode == Changer.ChangeMode.RESET)
			return CollectionUtils.array(String.class);
		return null;
	}

	@Override
	public Class<? extends String> getReturnType() { //ReturnType is TypeToGet and in this case Number.
		return String.class;

	}
	@Override
	protected String getPropertyName() {
		// TODO Auto-generated method stub
		return "Displayed Head";
	}

}
