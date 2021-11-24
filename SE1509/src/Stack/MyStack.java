/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import java.util.Random;

/**
 *
 * @author User
 */
public class MyStack {
    Node head,tail;

    public MyStack() {
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
    void push(int value){
        Node n = new Node(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            n.next=head;
            head=n;
        }
    }
    void pop(){
        if(isEmpty()) return;
        head = head.next;
    }
    int popReturnValue(){
        if(isEmpty()) return -1;
        int value = head.value;
        head = head.next;
        return value;
    }
    int top(){
        int value = head.value;
        return value;
    }
    public static void main(String[] args) {
        MyStack my = new MyStack();
        Random rd = new Random();
        int n = 20;
        for (int i = 0; i < n; i++) {
            my.push(rd.nextInt(100));
        }
    }
}
