
import java.awt.*;
import java.applet.*;
import java.awt.Toolkit;
import java.awt.Frame;
import java.awt.image.BufferedImage;



abstract class pakermanEntity extends Object {

    protected animation anim;
    public int x, y, w, h;
    
    protected Image img;
    boolean drawn = false;
    public boolean square = false;

    
    int offsetx() {
        return 0;
    }
    int offsety() {
        return 0;
    }
    
    
    public void loadImg(int x, int y, int w, int h) {

//        if (!square) {
//         
//
//        } else {
//            BufferedImage tmpimg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//
//            Graphics2D g = tmpimg.createGraphics();
//            g.setColor(Color.WHITE);
//            g.fillOval(0, 0, w, h);
//            //g.fillRect(0, 0, w, h);
//            g.setColor(Color.WHITE);
//            g.drawOval(0, 0, w, h);
//            //g.drawRect(0, 0, w, h);
//
//            img = (Image) tmpimg;
//        }
           this.loadImg();
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
    }

    public void loadImg() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        img = toolkit.getImage(this.getMyImage());
        x = 200;
        y = 200;
        w = 32;
        h = 32;

    }

    public void place(int x, int y, int w, int h) {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
    }
    
    public void move(int deltax, int deltay) {
        x += deltax;
        y += deltay;
    }

  
    
    public boolean collision(pakermanEntity e,Point delta) {
        int oldx=x,oldy=y;
        x+=delta.x;
        y+=delta.y;
        boolean ret=false;     
        int ew=e.x+e.w,ww=this.x+this.w,eh=e.y+e.h,hh=this.y+this.h;
        
        if(
                x<e.x+e.w 
                && x+w>e.x 
                && y<e.y+e.h 
                && y+h>e.y
                ) {
       
           ret=true;
             
        }
        x=oldx;
        y=oldy;
        return ret;
    }
    
    public void show(Graphics2D g) {
        g.drawImage(img, x, y, null);
        
    }

    abstract public String getMyImage();
}
