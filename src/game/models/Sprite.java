package game.models;

import java.awt.Graphics;
import java.awt.Image;

public abstract class Sprite {

	protected Image image;
	protected int posx, posy = 0;
	protected int speed = 3;
	
	public Sprite(Image image) {
		this.image = image;
	}
	
	public int getWidth() {
		return image.getWidth(null);
	}
	
	public int getHeight() {
		return image.getHeight(null);
	}
	
	public abstract void draw(Graphics g);
	
	public void setPosition(int x, int y) {
		this.posx = x;
		this.posy = y;
	}
	
	public int getPosX() {
		return this.posx;
	}
	
	public int getPosY() {
		return this.posy;
	}
	
}
