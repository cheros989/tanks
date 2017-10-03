package game.models;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;

public abstract class Sprite {

	protected Image image;
	protected int posx, posy = 0;
	protected int speed = 3;
	
	public Sprite(String path) {
		BufferedImage sourceImage = null;
		
		try {
			URL url = this.getClass().getClassLoader().getResource(path);
			sourceImage = ImageIO.read(url);
		} catch (Exception e) {
			e.getMessage();
		}
		this.image = Toolkit.getDefaultToolkit().createImage(sourceImage.getSource());
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
