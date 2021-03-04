package fr.fyz.animateinv;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class AnimateInventory {

	public Player player;
	public ArrayList<Frame> frames;
	public int ticks;
	public boolean loop;
	public int size;
	public String title;
	public boolean closeAtEnd;
	public Inventory inv;
	public String id;
	public BukkitTask task;

	public AnimateInventory(String title, int size, Player player, ArrayList<Frame> frames, int ticks, boolean loop,
			boolean closeAtEnd) {
		this.player = player;
		this.closeAtEnd = closeAtEnd;
		this.frames = frames;
		this.ticks = ticks;
		this.loop = loop;
		this.title = title;
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public String getTitle() {
		return title;
	}

	public boolean isLoop() {
		return loop;
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Frame> getFrames() {
		return frames;
	}

	public int getDelay() {
		return ticks;
	}

	public boolean isCorrectInventory() {
		Inventory actual = player.getOpenInventory().getTopInventory();
		if (player != null && player.isOnline() && player.getOpenInventory().getTopInventory() != null
				&& actual.getTitle().equals(inv.getTitle())) {
			return true;
		}
		return false;
	}

	public void play() {
		inv = Bukkit.createInventory(player, size, title);
		updateInv(frames.get(0), true);
		player.openInventory(inv);

		task = new BukkitRunnable() {
			int actual_frame = 1;

			@Override
			public void run() {
				if (isCorrectInventory()) { // Check if inventory is valid and if the player is online
					Frame frame;
					if (canAccessFrame(actual_frame)) { // check if the list can get the frame from the int
						frame = frames.get(actual_frame);
					} else {
						frame = frames.get(actual_frame - 1);
					}
					updateInv(frame, false);
					actual_frame++;
					if (actual_frame >= frames.size()) { // Frames ended.
						if (loop) {
							actual_frame = 0; // Loop
						} else if (closeAtEnd) {
							close();
						}
					}
				} else {
					close();
				}

			}
		}.runTaskTimer(Main.getInstance(), ticks, ticks);
	}

	@SuppressWarnings("deprecation")
	public void updateInv(Frame f, boolean firstFrame) {
		if (!firstFrame) {
			player.getOpenInventory().getTopInventory().clear();
		}
		f.getAllItems().keySet().forEach(e -> inv.setItem(e, f.getAllItems().get(e)));
		if (!firstFrame) {
			player.updateInventory();
		}
	}

	public void close() {
		task.cancel();
		if (player.isOnline()) {
			player.closeInventory();
		}
	}

	public boolean canAccessFrame(int i) {
		return i < frames.size();
	}

	public void loop() {

	}

}
