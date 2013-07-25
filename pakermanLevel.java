

public class pakermanLevel {
    byte [] data;
    protected void loadFile(String fn) {
        data=File.readAllBytes(fn);
    }
    pakermanLevel(String fn) {
        
    }
}
