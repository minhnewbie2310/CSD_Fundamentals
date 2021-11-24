/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book_pe_se1509;

/**
 *
 * @author User
 */
public class Node {
    Book info;
  Node next;
  Node(Book x, Node p)
   {info=x;next=p;
   }
  Node(Book x)
   {this(x,null);
   }
}
