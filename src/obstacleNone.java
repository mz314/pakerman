
import java.awt.Graphics2D;

class obstacleNone extends pakermanEntity {
     @Override public void loadImg(int x, int y, int w, int h) {
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
     }
    @Override public String getMyImage() {
        return "";
    }
        public void show(Graphics2D g) {
            
        }
}