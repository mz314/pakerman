/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciek
 */

enum obstacleType {
 horizontal,
 vertical,
 none
}

public class pakermanObstacle extends pakermanEntity{
    protected obstacleType type;
    
    pakermanObstacle(obstacleType type) {
        this.type=type;
    }
    
    
    
    public String getMyImage() {
        if (type==obstacleType.horizontal)
        return "obstacle_h.png";
        else if (type==obstacleType.vertical) 
            return "obstacle_v.png";
        return "";
        
    }
}
