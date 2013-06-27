import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Toolkit;
import java.util.List;
import java.io.File;

class animation implements Runnable {
 protected int frame_width,frame_height,frame_count,interval,current_frame_i=0,offsetx;
 protected String file;
 Toolkit tk;
 
 BufferedImage frames_image,frames[];
 
 public void animate() {
  new Thread(this).start();
 }
 
 public void run() {
  while(true) {
   try {
    Thread.sleep(interval);
   } catch(Exception e) {}
   current_frame_i=(current_frame_i+1) % frame_count;
   //System.out.println("X");
  }
 }
 
 protected BufferedImage [] loadFile() {
 BufferedImage frame_facing[]=new BufferedImage[frame_count];
 try {
 
  frames_image=ImageIO.read(new File(file));
 
 
  } catch(Exception e) {
  System.out.println(file + " error.");
  }
  for(int i=0; i<frame_count; i++) {
   frame_facing[i]=frames_image.getSubimage(i*(frame_width+offsetx),0,(frame_width-offsetx),frame_height);
  }
  return frame_facing;
 }
 
 public BufferedImage getCurrentFrame() {
  
  return frames_image;
 }
 
 
 public void show(Graphics2D g,int x, int y) {
  g.drawImage(frames[current_frame_i],x,y,frame_width,frame_height,null);
 }
 
 public animation(String file,int frame_width,int frame_height,int frame_count,int fps,int offsetx) {
  this.frame_width=frame_width;
  this.frame_height=frame_height;
  this.frame_count=frame_count;
  this.file=file;
  this.offsetx=offsetx;
  tk=Toolkit.getDefaultToolkit();
  
  frames=loadFile();
  interval=(60/fps)*10;
 }
};