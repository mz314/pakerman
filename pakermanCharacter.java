import java.awt.Graphics2D;


abstract class pakermanCharacter extends pakermanEntity {

    protected int deltax = 1, deltay = 0;
    
    public void moveDelta() {
        this.move(deltax, deltay);
    }

    public void setDeltaX(int deltax) {
        if (this.deltay != 0) {
            this.deltay = 0;
        }
        this.deltax = deltax;
    }

    public void setDeltaY(int deltay) {
        if (this.deltax != 0) {
            this.deltax = 0;
        }
        this.deltay = deltay;
    }
}
