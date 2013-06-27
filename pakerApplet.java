

import java.applet.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyListener.*;
import java.awt.event.*;
import java.net.*;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;

/*
<applet code="pakerApplet.class" width="640" height="480">
</applet>
*/



public class pakerApplet extends Applet
implements   KeyListener
{
 BufferStrategy buffer;
 String message="";
 pakermanPlayer player;
 gameLogic game;
 Canvas canv;
 Image image;
 MediaTracker tr;
 Dimension dim;
 
 boolean exit=false;
 
 public void destroy() {
  exit=true;
  super.destroy();
 }
 
 public void keyReleased(KeyEvent k) {}
 public void keyTyped(KeyEvent k) { 
  
 }
  public void keyPressed(KeyEvent k) {
  System.out.println("key");
  if(k.getKeyChar()=='w') 
   game.setDeltaY(-1);
  if(k.getKeyChar()=='s')
   game.setDeltaY(1);
  if(k.getKeyChar()=='a')
   game.setDeltaX(-1);
  if(k.getKeyChar()=='d')
   game.setDeltaX(1);
   
 
 }

 
 public void init() {
 tr=new MediaTracker(this);
  //addKeyListener(this);
  player=new pakermanPlayer();
  player.loadImg(this,tr);
  
  
  
  game=new gameLogic(this);
   game.addPlayer(player);
  game.start();
  
  
 }
 
 
 public void update(Graphics g) {
  player.show(g);

 }
 
 
 private void debugMsg(Graphics g,String msg) {
  g.drawString(msg,10,10);
 }
 
  
 
 
 
 
 
 
 
 
}