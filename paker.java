import java.awt.Graphics;
import java.awt.*;

class paker {
 
 public static void main(String args[]) {
  gameLogic game=new gameLogic();
  game.setUp();
  pakerWindow win=new pakerWindow(game);
  win.c=new Color(0,0,0);
  int inc=1;
  while(true) {
   try {
   Thread.sleep(1);
   } catch(Exception e) {}
    /*win.c=new Color(win.x,win.x,win.x);
    win.x+=inc;
    if(win.x==255) 
    inc=-1;
    if(win.x==0)
     inc=1;*/
    win.render();
  }
 }
}