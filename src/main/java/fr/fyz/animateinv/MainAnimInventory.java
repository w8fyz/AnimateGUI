package fr.fyz.animateinv;

import org.bukkit.plugin.java.JavaPlugin;

public class MainAnimInventory extends JavaPlugin{ 
	
	private static MainAnimInventory INSTANCE;
	
	public static MainAnimInventory getInstance() {
		return INSTANCE;
	}
	
	@Override
	public void onEnable() {
		INSTANCE = this;
		System.out.println("Animate Inventory loaded!");
	}

}
