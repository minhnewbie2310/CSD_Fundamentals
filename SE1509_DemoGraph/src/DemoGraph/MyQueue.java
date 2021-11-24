/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoGraph;

/**
 *
 * @author User
 */
public class MyQueue {
    Node head,tail;
    
    public MyQueue(){
        head=tail=null;
        
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void EnQueue(int value){
        Node n = new Node(value);
        if(isEmpty()){
            head=tail=n;
        }else{
            tail.next=n;
            tail=n;
        }
    }
    public int DeQueue(){
        if(isEmpty()) return 100;
        int value = head.value;
        head = head.next;
        return value;
    }
}
class Node{
    int value;
    Node next;
    
    public Node(int value){
        this.value=value;
        next = null;
    }
}
