package LinkedList;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MyList {
    Node head,tail;

    public MyList() {
        head = tail = null;
    }  
    boolean isEmpty(){
        return head==null;
    }
    void display(){
        Node cu = head;
        while(cu!=null){
            System.out.print(cu.value+" ");
            cu = cu.next;
        }
    }
    void addFirst(int value){
        Node n = new Node(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            n.next=head;
            head=n;
        } 
    }
    void addLast(int value){
        Node n = new Node(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            tail.next=n;
            tail=n;
        }
    }
    void addIndex(int index, int value){  
        Node n = new Node(value);
        if(index<0) return;
        if(index==0) addFirst(value);
        else{
            Node cu = head;
            int count=0;
            while(cu!=null&&count!=(index-1)){
                cu=cu.next;
                count++;
            }
            if(cu==null&&count+1<index) return;
            if(cu.next==null&&index==count+1) addLast(value);
            n.next=cu.next;
            cu.next=n;
        }
    }

    boolean isPrimeNumber(int n) {
        // so nguyen n < 2 khong phai la so nguyen to
        if (n < 2) {
            return false;
        }
        // check so nguyen to khi n >= 2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    void addCondition1(int value){
        //add vao trc phan tu so nguyen to dau tien cua list 1 so co gia tri 1000
        Node cuP = head;
        int countPrime =0;
        while(cuP.next!=null&&isPrimeNumber(cuP.value)==false){
            countPrime++;
            cuP=cuP.next;
        }
        int index = countPrime;
        addIndex(index, value);
    }
    void addCondition2(int value){
        //add vao trc phan tu so nguyen to cuoi cung cua list 1 so co gia tri 1000
        Node cu = head;
        int count =0;
        int countPrime=0;
        while(cu.next!=null){
            count++;
            cu=cu.next;
            if(isPrimeNumber(cu.value)==true){
                countPrime=count;
            }
        }
        int index = countPrime;
        addIndex(index, value);
    }
    void addCondition3(int value){
        //add mot phan tu vao truoc phan tu cuoi
        Node cu = head;
        int count =0;
        while(cu.next!=null){
            count++;
            cu=cu.next;
        }
        int index = count;
        addIndex(index, value);
    }
    void addCondition4(int value1, int value2){
        //add 2 phan tu vao list (pt1 vao vt2, pt2 vao vt4)
        Node cu = head;
        int count =0;
        while(cu.next!=null){
            count++;
            cu=cu.next;
            if(count==2){                
                addIndex(2, value1);
            }
            if(count==4){
                addIndex(4, value2);
            }
        }
    }
    
    int deleteFirst(){
        if(isEmpty()) return -1;
        int value = head.value;
        head = head.next;
        return value;
    }
    void deleteFirst1(){
        if(isEmpty()) return;
        head = head.next;
    }
    void deleteLast(){
        if(isEmpty()) return;
        Node cu = head;
        if(cu.next==null) head = tail = null;
        while(cu.next.next!=null){
            cu = cu.next;
        }
        cu.next=null;
        tail=cu;
    }
    int deleteLast1(){
        if(isEmpty()) return -1;
        Node cu = head;
        int value = tail.value;
        if(cu.next==null) head = tail = null;
        while(cu.next.next!=null){
            cu = cu.next;
        }
        cu.next=null;
        tail=cu;
        return value;
    }
    void deleteIndex(int index){       
        Node cu = head;
        if(isEmpty()) return;
        int count=1;
        while(cu!=null){
            count++;
            cu = cu.next;
        }
        if(index<0||index>=count) return;
        if(index==0) deleteFirst();
        else if(index==count-1) deleteLast();
        else{
            count=0;
            cu=head;
            while(count!=index-1){
                cu=cu.next;
                count++;
            }
            cu.next=cu.next.next;
        }
    }
    public static void main(String[] args) {
        MyList my = new MyList();
        Random rd = new Random();
        int n = 20;
        for (int i = 0; i < n; i++) {
            my.addLast(rd.nextInt(100));
        }
//        my.addFirst(1);
//        my.addFirst(2);
//        my.addFirst(3);
//        my.addFirst(4);
//        my.addFirst(5);
//        my.addLast(10);
//        my.addLast(20);
//        my.addLast(30);
//        my.addLast(40);

//        my.addIndex(9, 50);

//        my.display();
//        int x = my.deleteFirst();
//        System.out.println("x="+x);
//        my.display();

//        my.display();
//        my.deleteLast();
//        my.deleteLast();
//        System.out.println("");
          
//            my.display();
//            my.deleteIndex(10);
//            System.out.println("");
            my.display();
            my.addCondition4(99,98);
            System.out.println("");
            my.display();
    }
    
    //Viet stack va queue dua tren nhung gi da lam
    //stack : addFirst->push(value), deleteFirst->pop(), getFirst->top(){RETURN INT}
    //queue : addLast->enqueue(value), deleteFirst->dequeue()
    
}
