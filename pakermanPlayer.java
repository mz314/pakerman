import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.*;

enum facing_dirs {
 UP,
 DOWN,
 LEFT,
 RIGHT
};

class pakermanPlayer extends pakermanEntity {
 // lepiej zrobić TUTAJ 4 animacjie dla każdego kierunku
 animation anim;
 facing_dirs facing;
 private
 int rotation=0;

 public void facing(facing_dirs facing) {
  int rot=0;
  
  
  switch(facing) {
   case LEFT: rot=0; break;
   case RIGHT: rot=180; break;
   case UP: rot=90; break;
   case DOWN: rot=-90; break;
  }
  
  rotation=rotation-(rot+rotation);
  //rotation=rotation % 360;
  anim.flip(rotation);
  this.facing=facing;
 }
 
 public void loadImg() {
   Toolkit toolkit = Toolkit.getDefaultToolkit();
   img = toolkit.getImage(this.getMyImage());
   anim=new animation(this.getMyImage(),24,24,4,20,0);
   facing=facing_dirs.LEFT;
   anim.animate();
   x=200;
   y=200;
   w=32;
   h=32;
 }

  public String getMyImage() {
   return "pacman_animation";
  }
  
  public void show(Graphics2D g) {
  //BufferedImage img=anim.getCurrentFrame();
  //if(img)
   anim.show(g,x,y);
   //g.fillRect(x,y,10,10);
 }
}