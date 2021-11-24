// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Balloon {
  String owner;
  int color,size;
  Balloon() {
   }
  Balloon(String xOwner, int xColor, int xSize){
    owner=xOwner;color=xColor; size=xSize;
   }
  public String toString(){
    return("(" +owner+","+color + "," + size + ")");
   }
 }
