package game.models;

import java.awt.Graphics;


public class Block extends Sprite {

	public Block(String path) {
		super(path);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(getImage(), getPosX(), getPosY(), null);
	}
}
