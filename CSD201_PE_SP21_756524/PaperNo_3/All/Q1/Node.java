// =========== DO NOT EDIT THE GIVEN CONTENT OF THIS FILE ============
// == You can insert setters and/or getters only if you need them ==== 
class Node {
  Balloon info;
  Node next;
  Node() {
   }
  Node(Balloon x, Node p) {
    info=x;next=p;
   }
  Node(Balloon x) {
    this(x,null);
   }
 }

