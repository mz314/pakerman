
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
    protected Rectangle needle; //move to player
    protected int rotation = 0,lastx=0,lasty=0;

    public void facing(facing_dirs facing) {
        switch (facing) {
            case LEFT:
                anim.setFacing(0);
                break;
            case RIGHT:
                anim.setFacing(2);
                break;
            case UP:
                anim.setFacing(1);
                break;
            case DOWN:
                anim.setFacing(3);
                break;
        }
        this.facing = facing;
    }

    public void setNeedle(int x, int y, int w, int h) { //x and y relative to upper left
        needle = new Rectangle(x, y, w, h);
    }
    
    public Rectangle getNeedle() {
        return needle;
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
        anim.setFacing(2);
    }

    public String getMyImage() {
        return "pacman_animation";
    }

    public void show(Graphics2D g) {
        //g.setColor(Color.BLUE);
        //g.fillRect(x, y, 32, 32);
        anim.show(g,x,y);

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