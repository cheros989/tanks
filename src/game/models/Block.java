package game.models;

import java.awt.Graphics;

import game.MainScene;

public class Block extends Sprite {
	
	public Block(String path) {
		super(path);
	}
	
	@Override
	public void draw(Graphics g) {
		g.fillRect(getPosX(), getPosY(), MainScene.TAIL_SIDE, MainScene.TAIL_SIDE);
	}
	
}
