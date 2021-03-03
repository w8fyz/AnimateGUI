package fr.fyzdesign.animateinv;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.inventory.ItemStack;

public class Frame {
	
	public HashMap<Integer, ItemStack> items;

	public Frame(HashMap<Integer, ItemStack> items) {
		this.items = items;
	}
	
	public HashMap<Integer, ItemStack> getAllItems() {
		return items;
	}
	
	public <K, V> Integer getKey(ItemStack value) {
	    for (Entry<Integer, ItemStack> entry : getAllItems().entrySet()) {
	        if (entry.getValue().equals(value)) {
	            return entry.getKey();
	        }
	    }
	    return null;
	}
	
}
