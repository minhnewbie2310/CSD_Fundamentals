/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {
  Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty() {
    return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception {
    if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception {
    Node p = head;
    while(p!=null) {
       fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadData(int k) { //do not edit this function
    String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
*/
  void addLast(String xOwner, int xColor, int xSize) {
    //You should write here appropriate statements to complete this function.
    if(xOwner.charAt(0)=='B'){
        return;
    }
    Balloon x = new Balloon(xOwner, xColor, xSize);
    Node q = new Node(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
   }

  //You do not need to edit this function. Your task is to complete the addLast function above only.
  void f1() throws Exception {
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
 void addFirst(Balloon x) {
        head = new Node(x, head);
        if (tail == null) {
            tail = head;
        }
    }
  void insertPositionK(Balloon x, int position) {
		if (isEmpty()) head = tail = new Node(x);
		int count = 1;
		Node p = head;
		while (p!= null && count < position) {
			p = p.next;
			count ++;
		}
		Node temp = p.next;
		p.next = new Node(x, temp);
	}
  void f2() throws Exception {
     clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Balloon x, y;
     x = new Balloon("X",1,2);
     y = new Balloon("Y",3,4);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      addFirst(x);
      insertPositionK(y, 2);
      


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  Node findSecondMaxAge() {
        Node p, q;
        int maxAge;
        p = q = head;
        maxAge = q.info.color;
        p = p.next;
        while (p != null) {
            if (p.info.color > maxAge) {
                q = p;
                maxAge = p.info.color;
            }
            p = p.next;
        }
        p = q = head;
        p = p.next;
        int count = 0;
        while (p != null) {
            if (p.info.color < maxAge) {
                q = p;
                count++;
                if (count == 2) {
                    break;
                }
            }
            p = p.next;
        }
        if (count == 1) {
            return null;
        } else {
            return (q);
        }

    }
  void removeFirst() {
        if (isEmpty()) {
            return;
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
    }
void remove(Node q) {
        if (q == null) {
            return;
        }
        if (q == head) {
            removeFirst();
            return;
        }
        Node f = head;
        while (f != null && f.next != q) {
            f = f.next;
        }
        if (f == null) {
            return; // q is not in the list
        }
        Node q1 = q.next;
        f.next = q1;
        if (f.next == null) {
            tail = f;
        }
    }
  void f3() throws Exception {
    clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      remove(findSecondMaxAge());


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  Node getNode(int k) {
        int i = 0;
        Node p = head;
        while (p != null) {
            if (i == k) {
                return (p);
            }
            i++;
            p = p.next;
        }
        return (null);
    }
 void Sort4FirstNode() {
        for (int i = 3; i<7; i++) {
            for (int j = i+1; j <7; j++) {
                Node pi = getNode(i);
                Node pj = getNode(j);
                if (pi.info.color > pj.info.color) {
                    Balloon temp = pi.info;
                    pi.info = pj.info;
                    pj.info = temp;
                }
            }
        }
  }
  void f4() throws Exception {
    clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/

     Sort4FirstNode();

    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
