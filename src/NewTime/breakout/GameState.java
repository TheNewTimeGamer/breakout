package NewTime.breakout;

import java.awt.Graphics;
import java.util.ArrayList;

public abstract class GameState {

	protected ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public abstract void init(Breakout breakout);
	
	public void tick(Breakout breakout) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			if(object != null) {
				object.tick(breakout);
			}
		}
	}
	
	public void render(Breakout breakout, Graphics g) {
		for(int i = 0; i < objects.size(); i++) {
			GameObject object = objects.get(i);
			if(object != null) {
				object.render(breakout, g);
			}
		}
	}
	
	public abstract void exit(Breakout breakout);
	
}
