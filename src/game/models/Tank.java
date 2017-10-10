package game.models;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.MainScene;
import game.constants.Direction;
import game.map.Map;

public class Tank extends Sprite {
	
	private int direction = Direction.UP;

	public Tank(String path) {
		super(path);
		speed = 6;
	}

	@Override
	public void draw(Graphics g) {
		boolean leftIntersect = false;
		boolean upIntersect = false;
		boolean downIntersect = false;
		boolean rightIntersect = false;
		for (Block block : Map.blocks) {
			Rectangle b = block.getRect();
			Rectangle t = this.getRect();
			if (MainScene.leftPressed) {
				setDirection(Direction.LEFT);
				t.setLocation(getPosX() - speed, getPosY());
				if (t.intersects(b)) {
					leftIntersect = true;
				}
			}
			if (MainScene.upPressed) {
				setDirection(Direction.UP);
				t.setLocation(getPosX(), getPosY() - speed);
				if (t.intersects(b)) {
					upIntersect = true;
				}
			}
			if (MainScene.downPressed) {
				setDirection(Direction.DOWN);
				t.setLocation(getPosX(), getPosY() + speed);
				if (t.intersects(b)) {
					downIntersect = true;
				}
			}
			if (MainScene.rightPressed) {
				setDirection(Direction.RIGHT);
				t.setLocation(getPosX() + speed, getPosY());
				if (t.intersects(b)) {
					rightIntersect = true;
				}
			}
		}
		if (MainScene.leftPressed && !leftIntersect) {
			posx -= speed;
		}
		if (MainScene.rightPressed && !rightIntersect) {
			posx += speed;
		}
		if (MainScene.upPressed && !upIntersect) {
			posy -= speed;
		}
		if (MainScene.downPressed && !downIntersect) {
			posy += speed;
		}
		g.drawImage(image, posx, posy, null);
	}

	public void shoot() {
		Rectangle rectangle = this.getRect();
		Shell shell = new Shell("shell.png", getDirection(), rectangle.getCenterX(), rectangle.getCenterY());
		Map.shells.add(shell);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

}
