package game.map;

import java.awt.*;
import java.util.*;
import java.util.List;

import game.MainScene;
import game.models.*;

public class Map {
	
	private static String[] map = new String[] {
		"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
		"x----------------------------x",
		"x-----------------x----------x",
		"xxxxxxxxxx--------x----------x",
		"x-----------------x----------x",
		"x-----------------x----------x",
		"x-----------------x----------x",
		"x---------------xxxxx--------x",
		"x-------------------x--------x",
		"x-------------------x--------x",
		"x-------------------x--------x",
		"x----xxxxxx------------------x",
		"x------x---------------------x",
		"x------x---------------------x",
		"x------x---------------------x",
		"x------x-------xxxxxxxx------x",
		"x------x-------x-------------x",
		"x--------------x-------------x",
		"x--------------x-------------x",
		"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
	};

	public static List<Block> blocks = new ArrayList<Block>();
	public static List<EmptyPlace> emptyPlaces = new ArrayList<EmptyPlace>();
	public static List<Shell> shells = Collections.synchronizedList(new ArrayList<Shell>());
	public static HashMap<String, Tank> tanks = new HashMap();
	private static int tail_side = MainScene.TAIL_SIDE;
	public static List<RespawnPosition> respawnPositions = new ArrayList<>(Arrays.asList(
			new RespawnPosition(tail_side, tail_side*2),
			new RespawnPosition(tail_side*6, tail_side*10),
			new RespawnPosition(tail_side*12, tail_side*10),
			new RespawnPosition(tail_side*5, tail_side*10),
			new RespawnPosition(tail_side*9, tail_side*15),
			new RespawnPosition(tail_side*15, tail_side*15),
			new RespawnPosition(tail_side*22, tail_side*17),
			new RespawnPosition(tail_side*25, tail_side*15),
			new RespawnPosition(tail_side*28, tail_side*5)
	));

	public static String[] getMap() {
		return map;
	}
	
	public static void buildMap() {
		int rows = MainScene.ROWS;
		int cols = MainScene.COLS;
		for (int i = 1; i < rows; i++) {
			String[] currentRow = map[i-1].split("");
			for (int j = 0; j < cols; j++) {
				if (currentRow[j].equals("x")) {
					Block block = new Block("block.png");
					block.setPosition(j*tail_side, i*tail_side);
					blocks.add(block);
				}
				if (currentRow[j].equals("-")) {
					EmptyPlace emptyPlace = new EmptyPlace("emptyPlace.png");
					emptyPlace.setPosition(j*tail_side, i*tail_side);
					emptyPlaces.add(emptyPlace);
				}
			}
		}
	}

	public static void drawMap(Graphics g) {
		for (Block block : blocks) {
			block.draw(g);
		}
		for (EmptyPlace emptyPlace : emptyPlaces) {
			emptyPlace.draw(g);
		}
		Iterator<Shell> iterator = shells.iterator();
		synchronized (shells) {
			synchronized (iterator) {
				while (iterator.hasNext()) {
					Shell shell = iterator.next();
					if (shell.isDelete()) {
						iterator.remove();
						continue;
					}
					shell.draw(g);
				}
			}
		}
		for (java.util.Map.Entry<String, Tank> t : tanks.entrySet()) {
			t.getValue().draw(g);
		}
	}
}
