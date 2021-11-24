/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotree;

import demotree.Queue.MyQueue;
import java.util.Random;

/**
 *
 * @author User
 */
public class BStree {

    Node root;

    public BStree() {
        root = null;
    }

    boolean isEmpty() {
        return root == null;
    }

    void insert(Car c) {
        Node node = new Node(c);
        if (isEmpty()) {
            root = node;
        } else {
            Node cu = root;
            Node father = null;
            while (cu != null) {
                if (cu.infor.price == c.price) {
                    System.out.println("Da ton tai key " + c.price + " Khong the add vao tree ");
                    return;
                } else {
//                if(cu.infor.price<c.price){
//            cu=cu.right;
//            }else cu=cu.left;
                    father = cu;
                    cu = cu.infor.price < c.price ? cu.right : cu.left;
                } 
            }
            if (father.infor.price < c.price) {
                father.right = node;
            } else {
                father.left = node;
            }
        }
    }

    void visit(Node p) {
        if (p == null) {
            return;
        }
        System.out.print(p.infor + "->");
    }

    void preOrder(Node p) {
        if (p == null) {
            return;
        }
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void preOrder() {
        preOrder(root);
    }

    void postOrder() {
        postOrder(root);
    }

    void postOrder(Node p) {
        if (p == null) {
            return;
        }
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

    void inOrder() {
        inOrder(root);
    }

    void inOrder(Node p) {
        if (p == null) {
            return;
        }
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void breadth_first() {
        breadth_first(root);
    }

    void breadth_first(Node pp) {
        MyQueue q = new MyQueue();
        q.EnQueue(pp);
        while (!q.isEmpty()) {
            Node p = q.DeQueue();
            if (p.left != null) {
                q.EnQueue(p.left);
            }
            if (p.right != null) {
                q.EnQueue(p.right);
            }
            visit(p);
        }
    }
    Node search(int key){
        Node cu = root;
        while(cu!=null){
            if(cu.infor.price==key) return cu;
            if(cu.infor.price<key) cu=cu.right;
            else cu=cu.left;
        }
        return null;
    }
    void deleteByCopyLeft(int key){
        Node needDelete = search(key);
        if(needDelete==null||needDelete.left==null) return;
        Node cu = needDelete.left;
        if(cu.right==null){
            needDelete.infor=cu.infor;
            needDelete.left=cu.left;
        }else{
            Node f = cu;
            while(cu.right!=null){
                f = cu;
                cu=cu.right;
            }
            needDelete.infor=cu.infor;
            f.right=cu.left;
        }
    } 
    void deleteByCopyRight(int key){
        Node needDelete = search(key);
        if(needDelete==null||needDelete.right==null) return;
        Node cu = needDelete.right;
        if(cu.left==null){
            needDelete.infor=cu.infor;
            needDelete.right=cu.right;
        }else{
            Node f = cu;
            while(cu.left!=null){
                f = cu;
                cu=cu.left;
            }
            needDelete.infor=cu.infor;
            f.left=cu.right;
        }
    }
    Node findFather(int key){
        Node cu = root;
        Node f = null;
        while(cu!=null){
            if(cu.infor.price==key) return f;
            f=cu;
            cu=cu.infor.price<key?cu.right:cu.left;
        }
        return null;
    }
    void deleteByMergingLeft(int key){
        Node f = findFather(key);
        if(f==null){
            if(root.infor.price==key&&root.left!=null){
                if(root.left.right==null){
                    root.left.right=root.right;
                    root=root.left;
                }else{
                    Node cu = root.left;
                    while(cu.right!=null){
                        cu=cu.right;
                    }
                    cu.right=root.right;
                    root=root.left;
                }
            }
        }else{
            Node needDelete = f.left.infor.price >key? f.left:f.right;
            if(needDelete.left==null) return;
            if(needDelete.left.right==null){
                needDelete.left.right=needDelete.right;
                
            }else{
                Node cu = needDelete.left.right;
                while(cu.right!=null) cu=cu.right;
                cu.right=needDelete.right;
                
            }
            if(f.infor.price>key) f.left=needDelete.left;
            else f.right=needDelete.left;
        }
    }
    Node rightRotate(Node p){
        if(p==null||p.left==null) return p;
        Node c=p.left;
        p.left=c.right;
        c.right=p;
        return c;
    }
    Node leftRotate(Node p){
        if(p==null||p.right==null) return p;
        Node c=p.right;
        p.right=c.left;
        c.left=p;
        return c;
    }
    void f3(){
        //quay node dau tien co con trai chia het cho 3
        breadth_first2(root);
        Node father = findFather(nodeCanQuay.infor.price);
        Node afterRotate = rightRotate(nodeCanQuay);
        if(father==null) root=afterRotate;
        else{
            if(father.infor.price>afterRotate.infor.price)
                father.left=afterRotate;
            else
                father.right=afterRotate;
        }
    }
    Node nodeCanQuay=null;
    void breadth_first2(Node pp){
        MyQueue q = new MyQueue();
        q.EnQueue(pp);
        while(!q.isEmpty()){
            Node p = q.DeQueue();
            if(p.infor.price%3==0&p.left!=null){
                nodeCanQuay=p;
            }
            if (p.left != null) {
                q.EnQueue(p.left);
            }
            if (p.right != null) {
                q.EnQueue(p.right);
            }
            
        }
    }
    public static void main(String[] args) {
        BStree tree = new BStree();
        tree.insert(new Car("A", 8));
        tree.insert(new Car("B", 4));
        tree.insert(new Car("C", 12));
        tree.insert(new Car("D", 2));
        tree.insert(new Car("E", 6));
        tree.insert(new Car("F", 10));
        tree.insert(new Car("G", 14));
        tree.insert(new Car("H", 1));
        tree.insert(new Car("I", 3));
        tree.insert(new Car("K", 5));
        tree.insert(new Car("L", 7));
        tree.insert(new Car("M", 9));
        tree.insert(new Car("N", 11));
        tree.insert(new Car("O", 13));
        tree.insert(new Car("P", 15));
//        tree.insert(new Car("P", 25));
//        tree.insert(new Car("P", 51));
//        tree.insert(new Car("P", 85));
//        tree.insert(new Car("P", 83));
//        tree.insert(new Car("P", 15));
//        tree.insert(new Car("P", 63));
//        tree.insert(new Car("P", 43));
//        tree.insert(new Car("P", 82));
//        tree.insert(new Car("P", 5));
//        tree.insert(new Car("P", 17));
        Random rd = new Random();
        int n=10;
        int[] a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=rd.nextInt(100);
        }
        System.out.println("");
        for (int i = 0; i < n; i++) {
            tree.insert(new Car("P", a[i]));
//            System.out.print(a[i]+", ");
        }
//        tree.breadth_first();
//        Node f = tree.search(11);
//        if(f==null){
//            System.out.println("Khong tim thay !");
//        }else{
//            System.out.println("Da tim thay node !");
//        }
//        tree.deleteByCopy(8);
//        tree.deleteByCopy(6);
//        tree.deleteByCopy(2);
//        tree.deleteByMergingLeft(8);
        tree.breadth_first();
    }
}
