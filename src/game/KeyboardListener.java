package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardListener extends KeyAdapter {
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			MainScene.leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			MainScene.rightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			MainScene.upPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			MainScene.downPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			MainScene.hero.shoot();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			MainScene.leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			MainScene.rightPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			MainScene.upPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			MainScene.downPressed = false;
		}
	}
}
