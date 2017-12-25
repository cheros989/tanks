package game;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import game.map.Map;
import game.models.Tank;

public class MainScene extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private boolean running = true;
	private final long UPDATE_TIME = 60;
	private static final String NAME = "THE GAME";
	public static final int TAIL_SIDE = 30;
	public static final int ROWS = 21;
	public static final int COLS = 30;
	public static final int WIDTH = TAIL_SIDE * COLS;
	public static final int HEIGHT = TAIL_SIDE * ROWS;
	public static Tank hero;
	public static Tank hero2;

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
		Thread game = new Thread(mainScene);
		game.start();
	}
	
	public void init() {
		hero = new Tank("tank1.png");
		hero2 = new Tank("tank2.png");
		Map.tanks.put("me", hero);
		Map.tanks.put("hero2", hero2);
		addKeyListener(new KeyboardListener());
		Map.buildMap();
	}

	@Override
	public void run() {
		init();
		hero.setPosition(162, 162);
		hero2.setPosition(192, 192);
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
		graphics.setColor(new Color(0, 0, 0));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		graphics.setColor(new Color(255, 255, 255));
		graphics.setFont(new Font("Arial", 120, 20));
		graphics.drawString("<PLAYER 1>: " + hero.getFrags() + "    <PLAYER 2>: " + hero2.getFrags(), 10, 20);
		Map.drawMap(graphics);
		graphics.dispose();
		bStrategy.show();
	}
}
