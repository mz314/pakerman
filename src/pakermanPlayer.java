
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
    protected Rectangle nleft,nright,nup,ndown;
    protected int rotation = 0,lastx=0,lasty=0;

    public pakermanPlayer(){
          
      
    }
    
    @Override
    public void setNeedle(int x, int y, int w, int h) {
        super.setNeedle(x,y,w,h);
        if(nleft==null) {
            nright=new Rectangle(x+needle.width,y+needle.height/2,needle.width,needle.height);
            nleft=new Rectangle(x,y+needle.height/2,w,h);
            nup=new Rectangle(x+needle.width/2,0,needle.width,needle.height);
            ndown=new Rectangle(x+needle.width/2,needle.height,needle.width,needle.height);
        
        }
    }
    
    public void facing(facing_dirs facing) {
       
        Rectangle n=null;
        switch (facing) {
            case LEFT:
                anim.setFacing(0);
                n=nleft;
                break;
            case RIGHT:
                anim.setFacing(2);
                n=nright;
                break;
            case UP:
                anim.setFacing(1);
                n=nup;
                break;
            case DOWN:
                n=ndown;
                anim.setFacing(3);
                break;
        }
        if(n!=null)
         setNeedle(n.x,n.y,n.width,n.height);
        this.facing = facing;
    }

   

    @Override
     public void move(int deltax, int deltay) {
        lastx=x;
        lasty=y;
        super.move(deltax, deltay);
     }
    
    @Override 
    public void loadImg() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        img = toolkit.getImage(this.getMyImage());
        anim = new turnableAnimation(this.getMyImage(), 24, 24, 4, 20, 0);
        facing = facing_dirs.LEFT;
        anim.animate();
        x = 200;
        y = 200;
        w = 16;
        h = 16;
        this.facing(facing_dirs.RIGHT);
        
    }

    @Override
    public String getMyImage() {
        return "pacman_animation";
    }

    @Override
    public void show(Graphics2D g) {
        //g.setColor(Color.BLUE);
        //g.fillRect(x, y, 32, 32);
        anim.show(g,x,y);
        super.show(g);

    }
    
    public facing_dirs lastCollisionDir() {
        //System.out.println((lastx-x)+","+(lasty-y));
        if(lastx-x>0)
         return facing_dirs.LEFT; 
        else if(lastx-x<0)
            return facing_dirs.RIGHT;
        else if(lasty-y>0)
            return facing_dirs.UP;
        else if(lasty-y<0)
            return facing_dirs.DOWN;
        return facing_dirs.DOWN;
    }
    
    @Override
    public boolean collision(pakermanEntity e,Point delta) {
        boolean ret=super.collision(e,delta);
        return ret;
    }
}