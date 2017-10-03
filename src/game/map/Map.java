package game.map;

import java.awt.Color;
import java.awt.Graphics;

import game.MainScene;

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
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"x----------------------------x",
		"xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
	};
	
	public static String[] getMap() {
		return map;
	}
	
	public static void buildMap(Graphics g) {
		for (int i = 0; i < 20; i++) {
			String[] currentRow = map[i].split("");
			for (int j = 0; j < 30; j++) {
				if (currentRow[j].equals("x")) {
					g.setColor(new Color(0,0,128));
					g.fillRect(j*MainScene.TAIL_SIDE, i*MainScene.TAIL_SIDE, MainScene.TAIL_SIDE, MainScene.TAIL_SIDE);
				}
				if (currentRow[j].equals("-")) {
					g.setColor(new Color(0,0,0));
					g.fillRect(j*MainScene.TAIL_SIDE, i*MainScene.TAIL_SIDE, MainScene.TAIL_SIDE, MainScene.TAIL_SIDE);
				}
			}
		}
	}
}
