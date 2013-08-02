

class particle {
 public particle() {}; 
 public void show() {};
 
};

class particleSystem implements Runnable  {
 int x,y,w,h;
 particle particles[];
 public particleSystem(particle template,int particle_count,int x,int y,int w,int h) {
  this.x=x;
  this.y=y;
  this.w=w;
  this.h=h;
  particles=new particle[particle_count];
  
 }
 public void run() {
 }
};