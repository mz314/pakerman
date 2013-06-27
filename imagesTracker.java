import java.util.Dictionary;
import java.awt.*;

class imagesTracker extends MediaTracker{
 private static imagesTracker me;
 private Dictionary<String,Image> images;
 static public imagesTracker getMe() { //this is a singleton
  if(me==null)
   me=new imagesTracker();
  return me;
 }
 
 public imagesTracker() {
 tr = new MediaTracker(this);
 }
 
 public boolean loadImage(String fn) {
  
      Image image = getImage(getCodeBase(), fn);
      addImage(image,0);
      images.put(fn,image);

 }
 
 
}