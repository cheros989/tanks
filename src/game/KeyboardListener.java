package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			MainScene.hero.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			MainScene.hero.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			MainScene.hero.moveUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			MainScene.hero.moveDown();
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			MainScene.hero.shoot();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			MainScene.hero.stopLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			MainScene.hero.stopRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			MainScene.hero.stopUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			MainScene.hero.stopDown();
		}
	}
}
