/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author User
 */
public class Node {
    Person info;
    Node next;

    public Node() {
    }

    public Node(Person info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    public Node(Person x){
        this(x,null);
    }
}
