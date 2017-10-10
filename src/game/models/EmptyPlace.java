package game.models;

import java.awt.Graphics;

public class EmptyPlace extends Sprite {

	public EmptyPlace(String path) {
		super(path);
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(getImage(), getPosX(), getPosY(), null);
	}
}
