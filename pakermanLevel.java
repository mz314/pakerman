

public class pakermanLevel {
    protected byte [] data; //despite of textual always to byte array
    //enemies as part of a game logic not here
    //setting deltas for each enemy/player move away from game logic
    protected int width,height;
    
    protected void loadFile(String fn) {
    //    data=File.readAllBytes(fn);
    }
    
    pakermanLevel(int w,int h) { //for testing
        this.width=w;
        this.height=h;
        int cnt=w*h;
        data=new byte[cnt];
        for(int i=0; i<cnt; i++)
            data[i]=0; //0 = empty space 1 = normal dot 2 = big dot
    }
    
    pakermanLevel(String fn) {
        
    }
}
