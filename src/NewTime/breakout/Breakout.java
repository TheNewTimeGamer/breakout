package NewTime.breakout;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Breakout extends Canvas implements Runnable {

	public static void main(String[] args) {
		new Breakout();
	}
	
	private JFrame frame;
	private Thread thread;	
	
	private int tickRate = 60;
	
	private BufferedImage screen;
	
	private GameState[] states = new GameState[16];
	private int state = 0;
	
	public Breakout(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1280,720);
		frame.setLocationRelativeTo(null);
		frame.add(this);
		frame.setVisible(true);
		
		screen = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
		
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		init();
		long last = 0;
		while(true) {
			if(System.currentTimeMillis() - last > (1000/tickRate)) {
				tick();
				render();
				last = System.currentTimeMillis();
			}
		}
	}
	
	private void init() {
		this.states[0] = new MapState();
		this.states[0].init(this);
	}
	
	private void setGameState(int newState) {
		this.states[this.state].exit(this);
		this.state = newState;
		this.states[this.state].init(this);
	}
	
	private void tick() {
		states[state].tick(this);
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics graphics = bs.getDrawGraphics();	
		
		Graphics g = screen.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		states[state].render(this, g);
		
		g.dispose();
		
		graphics.drawImage(screen, 0, 0, getWidth(), getHeight(), null);
		graphics.dispose();
		
		bs.show();
	}
	
}
