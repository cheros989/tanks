package game.models;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.net.URL;

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
	private int side = MainScene.TAIL_SIDE;
	private int sx1 = 0;
	private int sy1 = 0;
	private int sx2 = side;
	private int sy2 = side;
	private int deaths = 0;
	private int frags = 0;
	private AudioClip shoot;
	private AudioClip explosion;


	public Tank(String path) {
		super(path);
		speed = 6;
		this.rect_height = this.image.getHeight(null)/2;
		this.rect_width = this.image.getWidth(null)/2;
		shoot = Applet.newAudioClip(getUrl("sounds/shoot.wav"));
		explosion = Applet.newAudioClip(getUrl("sounds/explosion.wav"));
	}

	private URL getUrl(String path) {
		return this.getClass().getClassLoader().getResource(path);
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
		g.drawImage(image, posx, posy, posx+side, posy+side, sx1, sy1, sx2, sy2, null);
	}

	public void shoot() {

		if (!getCooldown()) return;

		shoot.play();
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
		setBounds(0, 0, side, side);
	}
	
	public void moveDown() {
		stop();
		downPressed = true;
		setBounds(side, side, side*2, side*2);
	}
	
	public void moveRight() {
		stop();
		rightPressed = true;
		setBounds(side, 0, side*2, side);
	}
	
	public void moveLeft() {
		stop();
		leftPressed = true;
		setBounds(0, side, side, side*2);
	}

	private void setBounds(int sx1, int sy1, int sx2, int sy2) {
		this.sx1 = sx1;
		this.sx2 = sx2;
		this.sy1 = sy1;
		this.sy2 = sy2;
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

		if (System.currentTimeMillis() - last_shoot < 200)
			return false;

		return  true;
	}

	public boolean isImmortal() {
		if (System.currentTimeMillis() - die_time < 2000)
			return true;

		return false;
	}

	public void die() {

		if (isImmortal())
			return;

		explosion.play();
		deaths++;
		die_time = System.currentTimeMillis();
		RespawnPosition position = Map.respawnPositions.get((int) Math.round(Math.random()*9));
		this.setPosition(position.getX(), position.getY());
	}

	public int getDeaths() {
		return deaths;
	}

	public void setFrags(int frags) {
		this.frags = frags;
	}

	public int getFrags() {
		return frags;
	}

	@Override
	public Rectangle getRect() {
		return new Rectangle(getPosX(), getPosY(), rect_width, rect_height);
	}
}
