
enum dotType {
    normal,
    big
};

class pakermanDot extends pakermanObject {

    dotType type;

    pakermanDot(dotType type) {
        this.type = type;
    }

    @Override public String getMyImage() {
       if(this.type==dotType.normal)
         return "dot_small.png";
       return "dot_big.png";
   }
}
