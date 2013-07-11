import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.*;

class pakermanPlayer extends pakermanEntity {
 // lepiej zrobić TUTAJ 4 animacjie dla każdego kierunku
 public void loadImg() {
   Toolkit toolkit = Toolkit.getDefaultToolkit();
   img = toolkit.getImage(this.getMyImage());
  anim=new animation(this.getMyImage(),24,34,4,10,0);
   anim.flip(90);
   anim.animate();
   x=200;
   y=200;
   w=32;
   h=32;
 }

  public String getMyImage() {
   return "pacman_animation.png";
  }
  
  public void show(Graphics2D g) {
  //BufferedImage img=anim.getCurrentFrame();
  //if(img)
   anim.show(g,x,y);
   //g.fillRect(x,y,10,10);
 }
}