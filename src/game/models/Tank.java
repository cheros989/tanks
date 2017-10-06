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
<<<<<<< HEAD
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
=======
		
//		System.out.println("LEFT: " + MainScene.leftBlock);
//		System.out.println("RIGHT: " + MainScene.rightBlock);
//		System.out.println("UP: " + MainScene.upBlock);
//		System.out.println("DOWN: " + MainScene.downBlock);
		
		if (MainScene.leftPressed && !MainScene.leftBlock) {
>>>>>>> 66cdf14da9f231c0ba078f884f2eb46a497be44b
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
<<<<<<< HEAD

=======
		
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
>>>>>>> 66cdf14da9f231c0ba078f884f2eb46a497be44b
	}

}
