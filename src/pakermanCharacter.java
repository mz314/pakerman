import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.*;

abstract class pakermanCharacter extends pakermanEntity {

    protected int deltax = 1, deltay = 0;
    protected Rectangle needle=new Rectangle(0,0,10,10); 
    
    public pakermanCharacter() {
        setNeedle(0,0,10,10);
    }
    
    public void moveDelta() {
        this.move(deltax, deltay);
    }
    
    
    
     public void setNeedle(int x, int y, int w, int h) { //x and y relative to upper left
        needle = new Rectangle(x, y, w, h);
    }
    
      public void show(Graphics2D g) {
        if(needle==null)
            return;
//        System.out.println(needle.x);
//        System.out.println(needle.y);
//        System.out.println("----");
        g.setColor(Color.BLUE);
        g.fillRect(needle.x+x,needle.y+y,needle.width,needle.height);
      }
     
    public Rectangle getNeedle() {
        return needle;
    }

    public void setDeltaX(int deltax) {
        if (this.deltay != 0) {
            this.deltay = 0;
        }
        this.deltax = deltax;
    }

    public void setDeltaY(int deltay) {
        if (this.deltax != 0) {
            this.deltax = 0;
        }
        this.deltay = deltay;
    }
}
