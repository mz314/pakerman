
import java.util.List;
import java.util.ArrayList;
import java.applet.*;


import java.awt.Toolkit;
import java.awt.Point;
import java.util.Collection;
import java.util.ListIterator;

class gameLogic extends Thread {

    boolean exit = false;
    pakermanPlayer player;
    Applet applet;
    int collisions = 0;
    protected pakermanLevel level;
    List<pakermanEntity> objects = new ArrayList<pakermanEntity>();
    public int w, h;

    public gameLogic(int w, int h) {
        this.w = w;
        this.h = h;
        System.out.println("W: " + w + "H: " + h);
        level = new pakermanLevel("lvl.txt");
        level.loadImages(w, h);
    }

    public void setUp() {
        player = new pakermanPlayer();
        player.loadImg();
        this.addPlayer(player);
    }

    public pakermanPlayer getPlayer() {
        return player;
    }

    public void addPlayer(pakermanPlayer p) {
        player = p;
        addObject(player);
    }

    public void addObject(pakermanEntity e) {
        objects.add(e);
    }

    private void checkDotCollisions() {
        List<pakermanDot> dots=level.getDots();
        pakermanDot dot;
        for(int i=0; i<dots.size(); i++) {
            dot=dots.get(i);
            boolean col=dot.collision(player,new Point(player.deltax,player.deltay));
            if(col) {
                dot.off();
                
            }
            
        }
    }
    
    private void checkLevelCollisions() { // add delta changes later
        List<pakermanObstacle> walls = level.getWalls();
        pakermanEntity wall;
        for (int i = 0; i < walls.size(); i++) {
            wall = walls.get(i);
            boolean col = player.collision(wall,new Point(player.deltax,player.deltay)); //player.collision(wall);
            facing_dirs d=player.lastCollisionDir();
            if (col) {
                switch(d) {
                    case LEFT: 
                        player.facing(facing_dirs.UP);
                        player.setDeltaY(-1);
                        break;
                    case RIGHT:
                        player.facing(facing_dirs.DOWN);
                        player.setDeltaY(1);
                        break;
                    case UP:
                        player.facing(facing_dirs.RIGHT);
                        player.setDeltaX(1);
                        break;
                    case DOWN: 
                        player.facing(facing_dirs.LEFT);
                        player.setDeltaX(-1);
                        break;
                }
                collisions++;
                System.out.println("Collision counter: " + collisions+", "+d);
            } else {
                // System.out.println(' ');
            }
        }
    }

    public void run() {
        long stime = System.nanoTime();
        while (!exit) {
            checkLevelCollisions();
            checkDotCollisions();
            player.moveDelta();

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}
