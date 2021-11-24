/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demotree;

/**
 *
 * @author User
 */
public class Node {
    Car infor;
    Node left,right;

    public Node(Car infor) {
        this.infor = infor;
        left=right=null;
    }

    public Node(String name,int price) {
        this(new Car(name,price));
    }
    
    
    
}
