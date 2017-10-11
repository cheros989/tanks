package game.models;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.constants.Direction;
import game.map.Map;

public class Tank extends Sprite {
	
	private int direction = Direction.UP;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean upPressed = false;
	private boolean downPressed = false;

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
			if (leftPressed) {
				setDirection(Direction.LEFT);
				t.setLocation(getPosX() - speed, getPosY());
				if (t.intersects(b)) {
					leftIntersect = true;
				}
			}
			if (upPressed) {
				setDirection(Direction.UP);
				t.setLocation(getPosX(), getPosY() - speed);
				if (t.intersects(b)) {
					upIntersect = true;
				}
			}
			if (downPressed) {
				setDirection(Direction.DOWN);
				t.setLocation(getPosX(), getPosY() + speed);
				if (t.intersects(b)) {
					downIntersect = true;
				}
			}
			if (rightPressed) {
				setDirection(Direction.RIGHT);
				t.setLocation(getPosX() + speed, getPosY());
				if (t.intersects(b)) {
					rightIntersect = true;
				}
			}
		}
		if (leftPressed && !leftIntersect) {
			posx -= speed;
		}
		if (rightPressed && !rightIntersect) {
			posx += speed;
		}
		if (upPressed && !upIntersect) {
			posy -= speed;
		}
		if (downPressed && !downIntersect) {
			posy += speed;
		}
		g.drawImage(image, posx, posy, null);
	}

	public void shoot() {
		Rectangle rectangle = this.getRect();
		Shell shell = new Shell("shell.png", getDirection(), rectangle.getCenterX(), rectangle.getCenterY(), this);
		Map.shells.add(shell);
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void moveUp() {
		stop();
		upPressed = true;
	}
	
	public void moveDown() {
		stop();
		downPressed = true;
	}
	
	public void moveRight() {
		stop();
		rightPressed = true;
	}
	
	public void moveLeft() {
		stop();
		leftPressed = true;
	}
	
	public void stopUp() {
		upPressed = false;
	}
	
	public void stopDown() {
		downPressed = false;
	}
	
	public void stopRight() {
		rightPressed = false;
	}
	
	public void stopLeft() {
		leftPressed = false;
	}
	
	public void stop() {
		upPressed = false;
		downPressed = false;
		leftPressed = false;
		rightPressed = false;
	}

}
