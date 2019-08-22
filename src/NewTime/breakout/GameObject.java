package NewTime.breakout;

import java.awt.Graphics;

public class GameObject {

	protected float x, y;
	protected int width, height;
	
	protected Texture texture;
	
	public GameObject(float x, float y, int width, int height, Texture texture) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.texture = texture;
	}
	
	public void tick(Breakout breakout) {
		
	}
	
	public void render(Breakout breakout, Graphics g) {
		
	}
	
}
