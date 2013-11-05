
import java.awt.Graphics2D;
import java.awt.Point;


enum dotType {
    normal,
    big,
    off
};

class pakermanDot extends pakermanObject {

    dotType type;
    
    public void off() {
        this.type=dotType.off;
    }
    
    pakermanDot(dotType type) {
        this.type = type;
    }

    @Override
     public boolean collision(pakermanEntity e,Point delta) {
         if(this.type!=dotType.off) {
             boolean ret=super.collision(e,delta);
             return ret;
         }
         return false;
     }
    
    @Override
    public void show(Graphics2D g) {
        if(this.type!=dotType.off)
         super.show(g);
    }
    
    @Override public String getMyImage() {
       if(this.type==dotType.normal)
         return "dot_small.png";
       else if(this.type==dotType.big)
        return "dot_big.png";
       return "";
   }
}
