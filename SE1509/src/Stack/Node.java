package Stack;

import LinkedList.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Node {
    int value;
    Node next;

    public Node() {
    }
    
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
    public Node(int value) {
        this.value = value;
        this.next = null;
    }
    
    
}
