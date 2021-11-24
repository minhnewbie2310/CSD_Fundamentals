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
public class NodeQueue {
    Node infor;
    NodeQueue next;

    public NodeQueue() {
    }

    public NodeQueue(Node infor) {
        this.infor = infor;
        this.next = null;
    }

}
