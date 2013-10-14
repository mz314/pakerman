import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.*;

enum facing_dirs {
 UP,
 DOWN,
 LEFT,
 RIGHT
};

class pakermanPlayer extends pakermanCharacter {
 protected turnableAnimation anim;
 protected facing_dirs facing;
 protected int rotation=0;

 public void facing(facing_dirs facing) {
 switch(facing) {
   case LEFT: anim.setFacing(0); break;
   case RIGHT: anim.setFacing(2); break;
   case UP: anim.setFacing(1); break;
   case DOWN: anim.setFacing(3); break;
  }
  this.facing=facing;
 }
 
 public void loadImg() {
   Toolkit toolkit = Toolkit.getDefaultToolkit();
   img = toolkit.getImage(this.getMyImage());
   anim=new turnableAnimation(this.getMyImage(),24,24,4,20,0);
   facing=facing_dirs.LEFT;
   anim.animate();
   x=200;
   y=200;
   w=32;
   h=32;
   anim.setFacing(2);
 }

  public String getMyImage() {
   return "pacman_animation";
  }
  
  public void show(Graphics2D g) {
   //   g.drawRect(x, y, 10, 10);
   anim.show(g,x,y);
 
 }
}