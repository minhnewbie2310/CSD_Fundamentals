/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLL;

/**
 *
 * @author User
 */
public class DbLinkedList {
    Node head, tail;

    public DbLinkedList() {
        head = tail=null;
    }
    
    boolean isEmpty(){
        return head == null;
    }
    
    void addFirst(int value){
        Node n = new Node(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            n.next=head;
            head.prev=n;
            head=n;
        }
    }
    void addLast(int value){
        Node n = new Node(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            tail.next=n;
            n.prev=tail;
            tail=n;
        }
    }
    void addIndexPrev(int index, int value){
        Node cu = head;
        Node n = new Node(value);
        if(index<0) return;
        if(index==0) addFirst(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            int count=0;
            while(cu!=null&&count!=(index-1)){
                cu=cu.next;
                count++;
            }
            if(cu==null&&count+1<index) return;
            if(cu.next==null&&index==count+1) addLast(value);
            n.next=cu.next;
            cu.next.prev=n;
            n.prev=cu;
            cu.next=n;
        }    
    }
    void addIndexNext(int index, int value){
        Node cu = head;
        Node n = new Node(value);
        if(index<0) return;
        if(index==0) addFirst(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            int count=0;
            while(cu!=null&&count!=(index-1)){
                cu=cu.next;
                count++;
            }
            if(cu==null&&count+1<index) return;
            if(cu.next==null&&index==count+1) addLast(value);
            n.prev=cu.prev;
            cu.prev.next=n;
            n.next=cu;
            cu.prev=n;
        }
    }
    void deleteFirst(){
        if(isEmpty()) return;
        head.next.prev=null;
        head=head.next;
    }
    void deleteLast(){
        if(isEmpty()) return;
        tail.prev.next=null;
        tail=tail.prev;
    }
    void deleteIndexPrev(int index){
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
            cu.prev=cu.prev.prev;
            cu.prev.prev=cu;
        }
        
    }
    void deleteIndexNext(int index){
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
            cu.next.prev=cu;
        }
    }
    void display(int direct){
        if(direct==0){
            Node cu = head;
            while(cu!=null){
                System.out.print(cu.value+" -> ");
                cu=cu.next;
            }
        }else{
            Node cu = tail;
            while(cu!=null){
                System.out.print(cu.value+" -> ");
                cu=cu.prev;
            }
        }
    }
    public static void main(String[] args) {
        DbLinkedList my = new DbLinkedList();
        my.addFirst(0);
        my.addFirst(1);
        my.addFirst(2);
        my.addFirst(3);
        my.addFirst(4);
        my.addFirst(5);
        my.addFirst(6);
        my.display(0);
    }
}
