package me.Funnygatt.GattSK.BungeeCord;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.Funnygatt.GattSK.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by Zachary on 11/14/2014.
 */
public class BCEffConnect extends Effect{
	private Expression<Player> p;
	private Expression<String> srv;

	protected void execute(Event event)
	{
		Player[] p = this.p.getAll(event);
		String srv = this.srv.getSingle(event);
		if ((p == null) || (srv == null)) {
			return;
		}
		for (Player player : p) {
			connect(player, srv);
		}
	}

	public String toString(Event event, boolean bool)
	{
		return "";
	}

	public boolean init(Expression<?>[] args, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
	{
		this.p = (Expression<Player>) args[0];
		this.srv = (Expression<String>) args[1];
		return true;
	}

	public static void connect(Player p, String srv)
	{
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try
		{
			out.writeUTF("Connect");
			out.writeUTF(srv);
		}
		catch (IOException localIOException) {}
		p.sendPluginMessage(Main.plugin, "BungeeCord", b.toByteArray());
	}
}
