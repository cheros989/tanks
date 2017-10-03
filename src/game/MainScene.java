package game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import game.map.Map;
import game.models.Sprite;
import game.models.Tank;

public class MainScene extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private boolean running = true;
	private final long UPDATE_TIME = 60;
	private static final String NAME = "THE GAME";
	private static final int WIDTH = 900;
	private static final int HEIGHT = 600;
	public static final int TAIL_SIDE = 30;
	public static boolean leftPressed = false;
	public static boolean rightPressed = false;
	public static boolean upPressed = false;
	public static boolean downPressed = false;
	public static Sprite hero;

	public static void main(String args[]) {
		MainScene mainScene = new MainScene();
		mainScene.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		JFrame jFrame = new JFrame(NAME);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(new BorderLayout());
		jFrame.add(mainScene, BorderLayout.CENTER);
		jFrame.pack();
		jFrame.setResizable(false);
		jFrame.setVisible(true);
		jFrame.setBackground(new Color(0, 255, 0));
		Thread game = new Thread(mainScene);
		game.start();
	}
	
	public void init() {
		hero = new Tank("man.png");
		addKeyListener(new KeyboardListener());
	}

	@Override
	public void run() {
		init();
		while (running) {
			update(UPDATE_TIME);
		}
	}
	
	private void update(long updateTime) {
		render();
		try {
			Thread.sleep(updateTime);
		} catch (InterruptedException e) {
			
		}
	}
	
	private void render() {
		BufferStrategy bStrategy = getBufferStrategy();
		
		if (bStrategy == null) {
			createBufferStrategy(2);
			requestFocus();
			return;
		}
		
		Graphics graphics = bStrategy.getDrawGraphics();
		graphics.setColor(new Color(0, 155, 0));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		Map.buildMap(graphics);
		hero.draw(graphics);
		graphics.dispose();
		bStrategy.show();
	}
}
