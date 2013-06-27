import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;


class turnableAnimation extends animation {
 
 public static final int FACING_LEFT=0,
 FACING_RIGHT=1,FACING_UP=2,FACING_DOWN=3;
 
 
 private BufferedImage faced_frames[][];
 private int current_facing;
 
 protected BufferedImage makeFlipped(BufferedImage img) {
  BufferedImage flipped=new BufferedImage(img.getWidth(),img.getHeight(),img.getType());
  AffineTransform rotated=new AffineTransform();
  rotated.rotate(Math.toRadians(90));
  Graphics2D fg=flipped.createGraphics();
  fg.setTransform(rotated);
  fg.drawImage(img,0,0,null);
  fg.dispose();
  return flipped;
 }
 
 protected BufferedImage [] loadFile() {
  System.out.println("load");
  
  return super.loadFile();
 }
 
 public void show(Graphics2D g,int x, int y,int facing) {
  frames=faced_frames[facing];
  super.show(g,x,y);
 }
 
 public turnableAnimation(String file,int frame_width,int frame_height,int frame_count,int fps,int offsetx) {
  super(file,frame_width,frame_height,frame_count,fps,offsetx);
  faced_frames=new BufferedImage[4][];
  faced_frames[0]=frames;
 }
 
}