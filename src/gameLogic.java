
import java.util.List;
import java.util.ArrayList;
import java.applet.*;


import java.awt.Toolkit;
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

    private void checkLevelCollisions() { // add delta changes later
        List<pakermanObstacle> walls = level.getWalls();
        pakermanEntity wall;
        for (int i = 0; i < walls.size(); i++) {
            wall = walls.get(i);
            boolean col = player.collision(wall);
            if (col) {
                collisions++;
                System.out.println("Collision counter: " + collisions);
            } else {
                // System.out.println(' ');
            }
        }
    }

    public void run() {
        long stime = System.nanoTime();
        while (!exit) {
            checkLevelCollisions();
            player.moveDelta();

            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}
