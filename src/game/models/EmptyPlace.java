package game.models;

import java.awt.Color;
import java.awt.Graphics;

import game.MainScene;

public class EmptyPlace extends Sprite {

	public EmptyPlace(String path) {
		super(path);
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(255, 255, 255));
		g.fillRect(getPosX(), getPosY(), MainScene.TAIL_SIDE, MainScene.TAIL_SIDE);
	}
}
