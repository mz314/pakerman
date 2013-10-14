
import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;

class turnableAnimation implements animationInteface {

    protected animation facings[] = new animation[4];
    protected int current_facing=0;
    
    void setFacing(int i) {
        facings[current_facing].kill();
        current_facing=i;
        facings[current_facing].animate();
    }
    
    public void animate() {
        facings[current_facing].animate();
    }
    
    public void show(Graphics2D g,int x, int y) {
        facings[current_facing].show(g,x,y);
    }
    
    turnableAnimation(String dir, int frame_width, int frame_height, int frame_count, int fps, int offsetx) {
        for (int i = 0; i < facings.length; i++) {
            facings[i] = new animation(dir, frame_width, frame_height, frame_count, fps, offsetx);
        }
        facings[1].flip(90);
        facings[2].flip(180);
        facings[3].flip(270);
    }
}