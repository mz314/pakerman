
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
    protected pakermanLevel level;
    List<pakermanEntity> objects=new ArrayList<pakermanEntity>(); 
    //public spawnPlayer

   
    
    public gameLogic() {
     //objects=new entitiesList();
        level=new pakermanLevel(32,32);
        level.loadImages();
    }

    public void setUp() {
        player = new pakermanPlayer();
        player.loadImg();
        this.addPlayer(player);
    }

    public List<pakermanEntity> getLevelObjects() {
    	return level.getObstacles();
    }
    
    public List<pakermanEntity> getObjects()  {
        return objects;
    }
    
    public pakermanPlayer getPlayer() {
        return player;
    }

    public void addPlayer(pakermanPlayer p) {
        player = p;
        addObject(player);
    }

   public void addObject(pakermanEntity e) {
     //  if(e!=null && objects!=null)
       
       objects.add(e);
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
