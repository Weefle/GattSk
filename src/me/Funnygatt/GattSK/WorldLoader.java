package me.Funnygatt.GattSK;

import me.Funnygatt.GattSK.Utilities.CustomYML;
import org.bukkit.World;

import java.io.File;

/**
 * Created by Zachary on 1/12/2015.
 */
public class WorldLoader {
	File worldList;
	CustomYML yml = Main.customYML;

	void loadWorlds(){
		yml.getCustomConfig().get;
	}

	void createWorldList(){
		yml.saveCustomConfig();
	}

	void addWorld(World world, String generator){
		yml.getCustomConfig().set(world.toString(), generator);
	}

	void addWorld(String world, String generator){
		yml.getCustomConfig().set(world, generator);
	}

	String getGenerator(World world){

		if (!yml.getCustomConfig().get(world.toString()).equals("Default")){
			return yml.getCustomConfig().get(world.toString()).toString();
		}
		else {
			return "Default";
		}
	}

	String getGenerator(String world){
		if (!yml.getCustomConfig().get(world).equals("Default")){
			return yml.getCustomConfig().get(world).toString();
		}
		else {
			return "Default";
		}
	}

}
