package game.models;

import java.awt.Graphics;

import game.MainScene;

public class Tank extends Sprite {
	
	public Tank(String path) {
		super(path);
	}
	
	@Override
	public void draw(Graphics g) {
		
//		System.out.println("LEFT: " + MainScene.leftBlock);
//		System.out.println("RIGHT: " + MainScene.rightBlock);
//		System.out.println("UP: " + MainScene.upBlock);
//		System.out.println("DOWN: " + MainScene.downBlock);
		
		if (MainScene.leftPressed && !MainScene.leftBlock) {
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
	
	public void stop(Block block) {
		MainScene.leftBlock = block.leftCollide(this);
		MainScene.upBlock = block.upCollide(this);
		MainScene.rightBlock = block.rightCollide(this);
		MainScene.downBlock = block.downCollide(this);
		System.out.println("VERT_COLLIDE: " + block.verticalCollide(this));
		System.out.println("HORIZONT_COLLIDE: " + block.horizontalCollide(this));
		System.out.println("LEFT: " + MainScene.leftBlock);
		System.out.println("RIGHT: " + MainScene.rightBlock);
		System.out.println("UP: " + MainScene.upBlock);
		System.out.println("DOWN: " + MainScene.downBlock);
	}
}
