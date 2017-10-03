package game.models;

import java.awt.Graphics;

import game.MainScene;

public class Tank extends Sprite {
	
	public Tank(String path) {
		super(path);
	}
	
	@Override
	public void draw(Graphics g) {
		if (MainScene.leftPressed) {
			posx -= speed;
		}
		if (MainScene.rightPressed) {
			posx += speed;
		}
		if (MainScene.upPressed) {
			posy -= speed;
		}
		if (MainScene.downPressed) {
			posy += speed;
		}
		g.drawImage(image, posx, posy, null);
	}
	
	public void shoot() {
		
	}
}
