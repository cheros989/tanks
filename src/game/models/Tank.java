package game.models;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.MainScene;
import game.map.Map;

public class Tank extends Sprite {

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
				t.setLocation(getPosX() - speed, getPosY());
				if (t.intersects(b)) {
					leftIntersect = true;
				}
			}
			if (MainScene.upPressed) {
				t.setLocation(getPosX(), getPosY() - speed);
				if (t.intersects(b)) {
					upIntersect = true;
				}
			}
			if (MainScene.downPressed) {
				t.setLocation(getPosX(), getPosY() + speed);
				if (t.intersects(b)) {
					downIntersect = true;
				}
			}
			if (MainScene.rightPressed) {
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

	}

}
