import java.awt.Graphics;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;


class turnableAnimation extends animation {
 BufferedImage facings[][]=new BufferedImage[4][];
 
 protected void copyAndFlip(int degrees,int facing) { 
    for(int i=0; i<frames.length; i++) {
  BufferedImage flipped=new BufferedImage(frames[i].getWidth(),frames[i].getHeight(),frames[i].getType());
  AffineTransform rotated=new AffineTransform();
  rotated.rotate(Math.toRadians(degrees),frames[i].getWidth()/2,frames[i].getHeight()/2);
  Graphics2D fg=flipped.createGraphics();
  fg.setTransform(rotated);
  fg.drawImage(frames[i],0,0,null);
  fg.dispose();
  frames[i]=flipped;
  }

 }
  
  
  public void setFacing(int i) {
   this.frames=this.facings[i];
  }
  
  
  public turnableAnimation(String dir,int frame_width,int frame_height,int frame_count,int fps,int offsetx) {
   super(dir,frame_width,frame_height,frame_count,fps,offsetx);
  //this.facings=new BufferedImage[4][];
   this.facings[0]=this.frames;
   this.facings[1]=copyAndFlip(90);
   this.facings[2]=copyAndFlip(270);
   this.facings[3]=copyAndFlip(180);
  }
  
 }