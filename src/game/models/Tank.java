package game.models;

import java.awt.*;

import game.MainScene;
import game.constants.Direction;
import game.map.Map;

public class Tank extends Sprite {
	
	private int direction = Direction.UP;
	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean upPressed = false;
	private boolean downPressed = false;
	private long last_shoot;
	private long die_time;
	private int rect_width;
	private int rect_height;

	public Tank(String path) {
		super(path);
		speed = 6;
		this.rect_height = this.image.getHeight(null)/2;
		this.rect_width = this.image.getWidth(null)/2;
	}

	@Override
	public void draw(Graphics g) {
		boolean leftIntersect = false;
		boolean upIntersect = false;
		boolean downIntersect = false;
		boolean rightIntersect = false;
		int side = MainScene.TAIL_SIDE;

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
		g.drawImage(image, posx, posy, posx+side, posy+side, side, 0, side + side, side, null);
	}

	public void shoot() {

		if (!getCooldown()) return;

		last_shoot = System.currentTimeMillis();
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

	private boolean getCooldown() {

		if (System.currentTimeMillis() - last_shoot < 1000)
			return false;

		return  true;
	}

	private boolean isImmortal() {
		if (System.currentTimeMillis() - die_time < 2000)
			return true;

		return false;
	}

	public void die() {

		if (isImmortal())
			return;

		System.out.println("DIE");
		die_time = System.currentTimeMillis();
		this.setPosition(MainScene.TAIL_SIDE, MainScene.TAIL_SIDE);
	}

	@Override
	public Rectangle getRect() {
		return new Rectangle(getPosX(), getPosY(), rect_width, rect_height);
	}
}
