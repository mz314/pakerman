import java.util.List;
import java.util.ArrayList;

enum entity_type {
	empty, dot, bigdot, teleport, wall
};

public class pakermanLevel {
	protected entity_type[] data; // despite of textual always to byte array
	// enemies as part of a game logic not here
	// setting deltas for each enemy/player moe away from game logic

	protected List<pakermanEntity> obstacles = new ArrayList<pakermanEntity>();
	protected int width, height;

	public List<pakermanEntity> getObstacles() {
		return obstacles;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	protected void loadFile(String fn) {
		// data=File.readAllBytes(fn);
	}

	public boolean loadImages(int winw, int winh) { // will be moved
		// int cnt=winw*winh;
		int rows = obstacles.size() / this.width, cols = obstacles.size()
				/ this.height, ow = 5, oh = 5, ox = ow/2, oy = oh,
				spacing=1;
		

		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).loadImg(ox, oy, ow, oh);
			if (i % (rows+1) == 0) {
				oy += oh+spacing;
				ox = 0;
			}
			ox += ow+spacing;
		}
		return true;
	}

	pakermanLevel(int w, int h) { // for testing
		this.width = w;
		this.height = h;
		int cnt = w * h;
		data = new entity_type[cnt];
		for (int i = 0; i < cnt; i++)
			// hmm... I think Im going to remove that
			data[i] = entity_type.dot; // 0 = empty space 1 = normal dot 2 = big
										// dot 3 = teleport 4 = wall
		for (int i = 0; i < cnt; i++)
			obstacles.add(new pakermanDot(dotType.normal));
		System.out.println(cnt);
	}

	pakermanLevel(String fn) {

	}
}
