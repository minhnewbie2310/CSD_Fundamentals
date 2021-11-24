/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import java.util.Random;

/**
 *
 * @author User
 */
public class MyQueue {
    Node head,tail;

    public MyQueue() {
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
    void enqueue(int value){
        Node n = new Node(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            tail.next=n;
            tail=n;
        }
    }
    void dequeue(){
        if(isEmpty()) return;
        head = head.next;
    }
    int dequeueReturnValue(){
        if(isEmpty()) return -1;
        int value = head.value;
        head = head.next;
        return value;
    }
    public static void main(String[] args) {
        MyQueue my = new MyQueue();
        Random rd = new Random();
        int n = 20;
        for (int i = 0; i < n; i++) {
            my.enqueue(rd.nextInt(100));
        }
    }
}
