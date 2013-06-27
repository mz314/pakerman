import java.util.List;
import java.applet.*;


import java.awt.Toolkit;

class gameLogic extends Thread {
 boolean exit=false;
 pakermanPlayer player;
 Applet applet;
 int deltax=1,deltay=0;
 private List<pakermanEntity> entities;
 //public spawnPlayer
 
 public gameLogic() {
  
 }
 
 public void setUp() {
  player=new pakermanPlayer();
  player.loadImg();
 }
 
 public pakermanPlayer getPlayer() {return player;}
 
 public void addPlayer(pakermanPlayer p) {
  player=p;
 }
 public void addEntity(pakermanEntity e) {
  entities.add(e);
 }
 
 public void setDeltaX(int deltax) {
  if(this.deltay!=0)
   this.deltay=0;
  this.deltax=deltax;
 }
 
 public void setDeltaY(int deltay) {
  if(this.deltax!=0)
   this.deltax=0;
  this.deltay=deltay;
 
 }
 
 public void run() {
  long stime=System.nanoTime();
  while(!exit) {
   
   player.move(deltax,deltay);
   try {
   Thread.sleep(10); } catch(Exception e) {}
   
  
   
   }
 }
 
 }
