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
public class Node {
    int value;
    Node next,prev;

    public Node(int value) {
        this.value = value;
        next=prev=null;
    }
    
}
