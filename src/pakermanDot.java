
enum dotType {
    normal,
    big
};

class pakermanDot extends pakermanObject {

    dotType type;
    
    int offsetx() {
        if(this.type==dotType.big)
            return 0;
        else
        return 5;
    }
    
    int offsety() {
        if(this.type==dotType.big)
            return 0;
        else
        return 6;
    }
    
    pakermanDot(dotType type) {
        this.type = type;
    }

    @Override public String getMyImage() {
       if(this.type==dotType.normal)
         return "dot_small.png";
       return "dot_big.png";
   }
}
