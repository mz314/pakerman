/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciek
 */

enum obstacleType {
 h,
 v,
 vur,
 vul,
 vdr,
 vdl,
 none
}

public class pakermanObstacle extends pakermanEntity{
    protected obstacleType type;
    
    pakermanObstacle(obstacleType type) {
        this.type=type;
    }
    
    
    
    
    public obstacleType getType() {
        return this.type;
    }
    public String getMyImage() {
        if (type==obstacleType.h)
        return "obstacle_h.png";
        else if (type==obstacleType.v) 
            return "obstacle_v.png";
        else if(type==obstacleType.vur)
            return "obstacle_vur.png";
        else if(type==obstacleType.vul)
            return "obstacle_vul.png";
         else if(type==obstacleType.vdl)
            return "obstacle_vdl.png";
         else if(type==obstacleType.vdr)
            return "obstacle_vdr.png";
        return "";
        
    }
}
