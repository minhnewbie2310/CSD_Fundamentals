/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     Queue q = new Queue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xOwner, int xPrice)
     {//You should insert here statements to complete this function

         if(xOwner.charAt(0)=='B'||xPrice>100){
             return;
         }else{
             Car c = new Car(xOwner,xPrice);
             Node node = new Node(c);
        if (isEmpty()) {
            root = node;
        } else {
            Node cu = root;
            Node father = null;
            while (cu != null) {
                if (cu.info.price == c.price) {
                    System.out.println("Da ton tai key " + c.price + " Khong the add vao tree ");
                    return;
                } else {
//                if(cu.infor.price<c.price){
//            cu=cu.right;
//            }else cu=cu.left;
                    father = cu;
                    cu = cu.info.price < c.price ? cu.right : cu.left;
                } 
            }
            if (father.info.price < c.price) {
                father.right = node;
            } else {
                father.left = node;
            }
        }
         }
     }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  void preOrder2(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
//=============================================================
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        
        preOrder2(root, f);
    

    


    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  
  Node search(Node p, int key) 
    {if(p == null) return null;
     if(p.info.price < key) return p;
     else if(p.info.price >= key) return search(p.left, key);
     else return search(p.right, key);
    }
void deleteByCopy(int x) 
    {Node p = search(root, x);
     if(p==null) {System.out.println("Key "+x+" does not exists, deletion failed"); return;}
     //find f is father of p
     Node f = null, q = root;
     while(q!=p) {f=q; 
      if(q.info.price>p.info.price) q=q.left;
      else q=q.right;}
      //1.p has no child
      if(p.left==null&&p.right==null) {
       if(f==null) root=null;
       else if(f.left==p) f.left=null;
       else f.right = null;
      }
      //2.p has left child only
      else if(p.left!=null&&p.right==null) {
       if(f==null) root=p.left;
       else if(f.left==p) f.left=p.left;
       else f.right=p.left;
      }
      //3.p has right child only
      else if(p.left==null&&p.right!=null) {
       if(f==null) root=p.right;
       else if(f.left==p) f.left=p.right;
       else f.right=p.right;
      }
      //4.p has both child
      else if(p.left!=null&&p.right!=null) {
       //tim q la node lon nhat ben con trai cua p -> q la con phai nhat
       //cua con trai cua p
       q = p.left;f = null;
       while(q.right != null) {f=q;q=q.right;}
       p.info = q.info;
       //delete q
       if(f==null) p.left=q.left;
       else f.right=q.left;
      }
    }
// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
  void f3() throws Exception
    {clear();
     loadData(7);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteByCopy(7);


    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
Node rotateRight(Node p) {
     if(p.left == null) return p;
     Node p1 = p.left;
     p.left = p1.right;
     p1.right = p;
     return p1;
    } 
//=============================================================
  void f4() throws Exception
    {clear();
     loadData(10);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        


    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
