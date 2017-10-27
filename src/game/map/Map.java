package game.map;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import game.MainScene;
import game.models.Block;
import game.models.EmptyPlace;
import game.models.Shell;
import game.models.Tank;

public class Map {
	
	private static String[] map = new String[] {
		"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
		"x----------------------------x",
		"x----------------------------x",
		"xxxxxxxxxx-------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x---------------xxxxx--------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----xxxx--------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
	};
	
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	public static ArrayList<EmptyPlace> emptyPlaces = new ArrayList<EmptyPlace>();
	public static ArrayList<Shell> shells = new ArrayList<Shell>();
	public static ArrayList<Tank> tanks = new ArrayList<Tank>();

	public static String[] getMap() {
		return map;
	}
	
	public static void buildMap() {
		int size = MainScene.TAIL_SIDE;
		int rows = MainScene.ROWS;
		int cols = MainScene.COLS;
		for (int i = 0; i < rows; i++) {
			String[] currentRow = map[i].split("");
			for (int j = 0; j < cols; j++) {
				if (currentRow[j].equals("x")) {
					Block block = new Block("block.png");
					block.setPosition(j*size, i*size);
					blocks.add(block);
				}
				if (currentRow[j].equals("-")) {
					EmptyPlace emptyPlace = new EmptyPlace("emptyPlace.png");
					emptyPlace.setPosition(j*size, i*size);
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
		while (iterator.hasNext()) {
			Shell shell = iterator.next();
			if (shell.isDelete()) {
				iterator.remove();
				continue;
			}
			shell.draw(g);
		}
		for (Tank tank : tanks) {
			tank.draw(g);
		}
	}
}
