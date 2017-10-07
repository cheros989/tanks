package game.models;

import java.awt.Graphics;

import game.MainScene;
import game.map.Map;

public class Tank extends Sprite {

	public Tank(String path) {
		super(path);
		speed = 6;
	}

	@Override
	public void draw(Graphics g) {
		for (Block block : Map.blocks) {
			boolean isCollide = this.isCollide(block);
			if (isCollide) {
				System.out.println("NMB: " + block.hashCode() + "RIGHT: " + this.rightCollide(block) + ";LEFT: " + this.leftCollide(block) + ";UP: " + this.upCollide(block) + ";DOWN: " + this.downCollide(block));
				if (this.leftCollide(block)) {
					MainScene.leftPressed = false;
				}
				if (this.rightCollide(block)) {
					MainScene.rightPressed = false;
				}

				if (this.upCollide(block)) {
					MainScene.upPressed = false;
				}
				if (this.downCollide(block)) {
					MainScene.downPressed = false;
				}
				break;
			}
		}
		if (MainScene.leftPressed) {
			posx -= speed;
			MainScene.rightBlock = false;
		}
		if (MainScene.rightPressed && !MainScene.rightBlock) {
			posx += speed;
			MainScene.leftBlock = false;
		}
		if (MainScene.upPressed && !MainScene.upBlock) {
			posy -= speed;
			MainScene.downBlock = false;
		}
		if (MainScene.downPressed && !MainScene.downBlock) {
			posy += speed;
			MainScene.upBlock = false;
		}
		g.drawImage(image, posx, posy, null);
	}

	public void shoot() {
		
	}

}
