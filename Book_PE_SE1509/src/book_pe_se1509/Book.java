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
public class Book {
    String name;
  int price;
  Book(String xName, int xPrice)
   {name=xName;price=xPrice;
   }
  public String toString()
   {return("(" +name+","+ price + ")");
   }
}
