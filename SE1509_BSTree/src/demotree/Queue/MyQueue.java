/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotree.Queue;

import demotree.Node;

/**
 *
 * @author User
 */
public class MyQueue {

    NodeQueue head;
    NodeQueue tail;

    public MyQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void EnQueue(Node c) {
        NodeQueue n = new NodeQueue(c);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public Node DeQueue() {
        if (isEmpty()) {
            return null;
        }
        Node c = head.infor;
        head = head.next;
        return c;
    }

}
