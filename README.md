# AnimateGUI
Want to create a animation in a minecraft GUI ? Try this !

# But.. How ?

For now, the only solution is to import all the class in your project and follow all the steps :

**Step One : Creating the AnimateInventory object**

Start by creating a new Object "AnimateInventory"

*Example :*

    new AnimateInventory("§cTest animation", 27, p, getFrames(), 1, true, false);

 - The first argument is for the title of the GUI

 - The second is for the number of slots (27 is a simple chest)
 - The third is the player assigned to the GUI
 - the fourth is all the *frames of the Inventory (go to step 2 to understand)*
 - the fifth is the time **in ticks** between 2 *frames*
 - the sixth is a boolean to know if the animation have to **loop** *when It end, it restart and this forever*
 - the seventh is a boolean for the gui to know if when the animation end he need to close the inventory of the player.

**Step Two : Adding frames**

Create a new ArrayList of "Frame"

    new ArrayList<Frame>
For *every* frame you will need to create a HashMap of **Integer** and **ItemStack**

	HashMap<Integer, ItemStack> frame1 = new HashMap<>();

The **Integer** is where the item have to be placed and the **ItemStack** is the item !

When all the frames are done *(you can see an example below)*
**add every frames in the arraylist by creating a new Frame()**

    new Frame(frame1);
    new Frame(frame2);
    new Frame(frame3);
    etc...
and... *Tada*
now you only need to add in the constructor of the **AnimateInventory** the arraylist.

The last thing you need to do is to call the function **play()** when you want

   	public Inventory(Player p) {
		this.p = p;
		inv = new AnimateInventory("§cTest animation", 27, p, getFrames(), 10, true, false); // "Register" the animation
	}
	
	public void open() { // The animation start
		inv.play();
	}
Gg ! You just created a *animated inventory!*
If you have any questions feel free to ask me on **discord**

Im gonna add some features like already-compiled API and a plugin already created.

*Please don't reappropriate my work and have a great day! 💛*

## Example :
Here is a 3 frames animation exemple that will change the colors of a full chest of stained glass from **white** to **orange** and finally **magenta**.

	public ArrayList<Frame> getFrames() {
		ArrayList<Frame> frames = new ArrayList<>();
		HashMap<Integer, ItemStack> frame1 = new HashMap<>();

		for (int i = 0; i < 27; i++) {
			frame1.put(i, new ItemCreator(Material.STAINED_GLASS_PANE, 0).setName("").getItem());
		}

		HashMap<Integer, ItemStack> frame2 = new HashMap<>();

		for (int i = 0; i < 27; i++) {
			frame2.put(i, new ItemCreator(Material.STAINED_GLASS_PANE, 1).setName("").getItem());
		}

		HashMap<Integer, ItemStack> frame3 = new HashMap<>();

		for (int i = 0; i < 27; i++) {
			frame3.put(i, new ItemCreator(Material.STAINED_GLASS_PANE, 2).setName("").getItem());
		}

		frames.add(new Frame(frame1));
		frames.add(new Frame(frame2));
		frames.add(new Frame(frame3));

		return frames;
	}

## Questions ?
Ask me anything on discord ! 

 - Fyz#0001
