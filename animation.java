
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.util.List;
import java.io.File;
import java.awt.geom.AffineTransform;

interface animationInteface {

    public void animate();

    public void show(Graphics2D g, int x, int y);
}

class animation implements Runnable, animationInteface {

    protected int frame_width, frame_height, frame_count, interval, current_frame_i = 0, offsetx;
    protected String dir;
    Toolkit tk;
    boolean exit = false,rd=false;
    BufferedImage frames_image, frames[];

    public void flip(int degrees) {
        for (int i = 0; i < frames.length; i++) {
            BufferedImage flipped = new BufferedImage(frames[i].getWidth(), frames[i].getHeight(), frames[i].getType());
            AffineTransform rotated = new AffineTransform();
            rotated.rotate(Math.toRadians(degrees), frames[i].getWidth() / 2, frames[i].getHeight() / 2);
            Graphics2D fg = flipped.createGraphics();
            fg.setTransform(rotated);
            fg.drawImage(frames[i], 0, 0, null);
            fg.dispose();
            frames[i] = flipped;
        }
    }

    public void kill() {
     exit=true;
    }

    public void animate() {
        exit = false;
        new Thread(this).start();
    }

    public void run() {
        while (exit == false) {
            try {
                Thread.sleep(interval);
            } catch (Exception e) {
            }
            current_frame_i = (current_frame_i + 1) % frame_count;
            //System.out.println("X");
        }
    }

    protected BufferedImage[] loadFile() {
        BufferedImage frame_facing[] = new BufferedImage[frame_count];
        String fn;
        for (int i = 0; i < frame_count; i++) {
            fn = dir + "/" + Integer.toString(i) + ".png";
            try {

                frames_image = ImageIO.read(new File(fn));


            } catch (Exception e) {
                System.out.println(fn + " error.");
            }
            frame_facing[i] = frames_image;

        }

        return frame_facing;
    }

    public BufferedImage getCurrentFrame() {

        return frames_image;
    }

    public void show(Graphics2D g, int x, int y) {
        // here get part of the screen
    	g.drawImage(frames[current_frame_i], x, y, frame_width, frame_height, null);
    }

    public void setRedraw(boolean rd) {
     this.rd=rd;	
    }
    
    public animation(String dir, int frame_width, int frame_height, int frame_count, int fps, int offsetx) {
        this.frame_width = frame_width;
        this.frame_height = frame_height;
        this.frame_count = frame_count;
        this.dir = dir;
        this.offsetx = offsetx;
        tk = Toolkit.getDefaultToolkit();

        frames = loadFile();
        interval = (60 / fps) * 10;
    }
};