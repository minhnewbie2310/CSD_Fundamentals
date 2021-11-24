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
public class Car {
String name;
int price;  //KEY

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "("+name+","+price+")";
    }

}
