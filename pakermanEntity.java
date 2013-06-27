import java.awt.*;
import java.applet.*;
import java.awt.Toolkit;
import java.awt.Frame;
import java.awt.image.BufferedImage;

abstract class pakermanEntity {
 animation anim;
 public int x,y,w,h;
 Image img;
 public void loadImg() {
   Toolkit toolkit = Toolkit.getDefaultToolkit();
   img = toolkit.getImage(this.getMyImage());
  anim=new animation(this.getMyImage(),24,34,4,10,0);
   anim.animate();
   x=200;
   y=200;
   w=32;
   h=32;
 }
 
 public void move(int deltax,int deltay)  {
  x+=deltax;
  y+=deltay;
 }
 
 public void show(Graphics2D g) {
  //BufferedImage img=anim.getCurrentFrame();
  //if(img)
   anim.show(g,x,y);
   //g.fillRect(x,y,10,10);
 }
 
 
 abstract public String getMyImage();
 
 
}

