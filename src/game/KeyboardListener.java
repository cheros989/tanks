package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {

		/**
		 * First player listener
		 */
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

		/**
		 * Second player listener
		 */
		if (e.getKeyCode() == KeyEvent.VK_A) {
			MainScene.hero2.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			MainScene.hero2.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			MainScene.hero2.moveUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			MainScene.hero2.moveDown();
		}
		if (e.getKeyCode() == KeyEvent.VK_G) {
			MainScene.hero2.shoot();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {

		/**
		 * First player listener
		 */
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

		/**
		 * Second player listener
		 */
		if (e.getKeyCode() == KeyEvent.VK_A) {
			MainScene.hero2.stopLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			MainScene.hero2.stopRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			MainScene.hero2.stopUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			MainScene.hero2.stopDown();
		}

	}
}
