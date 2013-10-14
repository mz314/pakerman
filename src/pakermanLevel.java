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
		int  	spacing=1,rows =obstacles.size() / this.width, cols = obstacles.size()
				/ this.height, ow = 18,
                        oh = 18, ox = ow/2-1, oy = 30
			;
		
                System.out.println("Size: "+obstacles.size());
                System.out.println("WIN: "+winw+","+winh);
                System.out.println("DOT: "+ow+","+oh+"-"+ox+":"+oy);
		for (int i = 1; i <= obstacles.size(); i++) { 
                     obstacles.get(i-1).square=true;
                     obstacles.get(i-1).loadImg(ox, oy, ow, oh);
			//if (i % (rows+1) == 0) 
                     ox += ow+spacing;
                     if((i)%32 == 0)
                     {
				//System.out.println("---");
                                oy += oh+spacing;
				ox = ow/2-1;
			}
			
		}
		return true;
	}

	pakermanLevel(int w, int h) { // for testing
		this.width = w;
		this.height = h;
		int cnt = w * h;
		data = new entity_type[cnt];
		for (int i = 0; i < cnt; i++) {
			if(i%2==0)
                            data[i] = entity_type.dot; // 0 = empty space 1 = normal dot 2 = big
                         else
                            data[i]=entity_type.empty;
                }				// dot 3 = teleport 4 = wall
		for (int i = 0; i < cnt; i++) {
			obstacles.add(new pakermanDot(dotType.normal));
                        
                }
		System.out.println(cnt);
	}

	pakermanLevel(String fn) {

	}
}
