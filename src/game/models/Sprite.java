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

	public Image getImage() {
		return this.image;
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

	public boolean isCollide(Sprite sprite) {

		return horizontalCollide(sprite) && verticalCollide(sprite);
	}

	protected boolean verticalCollide(Sprite sprite) {
		if (sprite.getPosY() <= getPosY() + getHeight() && sprite.getPosY() >= getPosY()
				|| sprite.getPosY() + sprite.getHeight() >= getPosY()
						&& sprite.getPosY() + sprite.getHeight() <= getPosY() + getHeight())
			return true;

		return false;
	}

	protected boolean horizontalCollide(Sprite sprite) {
		if (sprite.getPosX() <= getPosX() + getWidth() && sprite.getPosX() >= getPosX()
				|| sprite.getPosX() + sprite.getWidth() >= getPosX()
						&& sprite.getPosX() + sprite.getWidth() <= getPosX() + getWidth())
			return true;

		return false;
	}
}
