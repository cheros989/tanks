package game.models;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.constants.Direction;
import game.map.Map;

public class Shell extends Sprite {
	
	private int direction;
	private boolean isDelete = false;

	public Shell(String path, int direction, double startX, double startY) {
		super(path);
		this.direction = direction;
		this.speed = 20;
		this.setPosition((int) startX - getWidth()/2, (int) startY);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(getImage(), getPosX(), getPosY(), null);
		Rectangle rectangle = getRect();
		for (Block block : Map.blocks) {
			if (rectangle.intersects(block.getRect())) {
				this.isDelete = true;
			}
		}
//		if (rectangle.intersects(MainScene.hero.getRect())) MainScene.hero.speed = 0;
		if (direction == Direction.UP) posy -= speed;
		if (direction == Direction.DOWN) posy += speed;
		if (direction == Direction.LEFT) posx -= speed;
		if (direction == Direction.RIGHT) posx += speed;
	}

	public boolean isDelete() {
		return isDelete;
	}
	
}
