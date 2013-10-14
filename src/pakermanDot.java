
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
       return "dot_small.png";
   }
}
