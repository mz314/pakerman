
import java.util.List;
import java.applet.*;


import java.awt.Toolkit;

class gameLogic extends Thread {
    boolean exit = false;
    pakermanPlayer player;
    Applet applet;
   
    private List<pakermanEntity> entities; //to level (?)
    //public spawnPlayer

   
    
    public gameLogic() {
    }

    public void setUp() {
        player = new pakermanPlayer();
        player.loadImg();
    }

    public pakermanPlayer getPlayer() {
        return player;
    }

    public void addPlayer(pakermanPlayer p) {
        player = p;
    }

    public void addEntity(pakermanEntity e) {
        entities.add(e);
    }

   

    public void run() {
        long stime = System.nanoTime();
        while (!exit) {
            player.moveDelta();
            try {
                Thread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}
