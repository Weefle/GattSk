//package me.Funnygatt.GattSK.BungeeCord;
//
//import ch.njol.skript.lang.Expression;
//import ch.njol.skript.lang.SkriptParser;
//import ch.njol.skript.lang.util.SimpleExpression;
//import ch.njol.util.Kleenean;
//import me.Funnygatt.GattSK.Main;
//import org.bukkit.entity.Player;
//import org.bukkit.event.Event;
//
//import java.io.ByteArrayOutputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//
///**
//* Created by Zachary on 11/14/2014.
//*/
//public class BCExprServerAmount extends SimpleExpression<Integer>{
//	private Expression<String> srv;
//
//	protected void execute(Event event)
//	{
//		String srv = this.srv.getSingle(event);
//		if (srv == null) {
//			return;
//		}
//		getServerAmount(srv);
//	}
//
//	public String toString(Event event, boolean bool)
//	{
//		return "";
//	}
//
//	public boolean init(Expression<?>[] args, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult)
//	{
//		this.srv = (Expression<String>) args[0];
//		return true;
//	}
//
//	public static void getServerAmount(String srv) {
//		ByteArrayOutputStream in = new ByteArrayOutputStream();
//		DataOutputStream out = new DataOutputStream(in);
//		try {
//			out.writeUTF("PlayerCount");
//			out.writeUTF(srv);
//		}
//		catch (IOException localIOException) {
//		}
//			srv.sendPluginMessage(Main.plugin, "BungeeCord", b.toByteArray());
//
//		{
//		}
//	}
//}
